package com.example.education.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Notice(val title: String, val date: String, val content: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoticeBoardScreen(onBack: () -> Unit) {
    val notices = listOf(
        Notice("Annual Day Celebration", "15th May 2024", "Join us for the annual day celebration in the school auditorium."),
        Notice("Exam Schedule Updated", "10th May 2024", "The final exam schedule has been updated. Please check the notice board for details."),
        Notice("Scholarship Application", "5th May 2024", "Applications for the merit-based scholarship are now open."),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notice Board") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(notices) { notice ->
                NoticeCard(notice)
            }
        }
    }
}

@Composable
fun NoticeCard(notice: Notice) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = notice.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = notice.date, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondary)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = notice.content)
        }
    }
}
