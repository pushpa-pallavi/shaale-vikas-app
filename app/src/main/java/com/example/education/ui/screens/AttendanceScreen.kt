package com.example.education.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Student(val id: Int, val name: String, var isPresent: Boolean)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen(onBack: () -> Unit) {
    val students = remember {
        mutableStateListOf(
            Student(1, "Rahul Kumar", isPresent = false),
            Student(2, "Priya Singh", isPresent = false),
            Student(3, "Amit Sharma", isPresent = false),
            Student(4, "Sneha Reddy", isPresent = false),
            Student(5, "Vikram Das", isPresent = false),
        )
    }

    val currentDate = remember { 
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Digital Attendance") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        },
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp)) {
            Text("Date: $currentDate", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(16.dp))
            
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(students) { student ->
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(student.name)
                        Checkbox(
                            checked = student.isPresent,
                            onCheckedChange = { isChecked ->
                                val index = students.indexOfFirst { it.id == student.id }
                                if (index != -1) {
                                    students[index] = students[index].copy(isPresent = isChecked)
                                }
                            }
                        )
                    }
                    HorizontalDivider()
                }
            }

            Button(
                onClick = { /* TODO: Submit Attendance */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit Attendance")
            }
        }
    }
}
