package com.example.education.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportIssueScreen(onBack: () -> Unit) {
    var description by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Report Infrastructure Issue") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Describe the issue") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )

            OutlinedTextField(
                value = location,
                onValueChange = { location = it },
                label = { Text("Location (Room No / Area)") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = { /* TODO: Implement Camera */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.CameraAlt, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Capture Photo")
            }

            Spacer(Modifier.weight(1f))

            Button(
                onClick = { /* TODO: Submit to AI */ },
                modifier = Modifier.fillMaxWidth(),
                enabled = description.isNotEmpty()
            ) {
                Text("Submit Complaint")
            }
        }
    }
}
