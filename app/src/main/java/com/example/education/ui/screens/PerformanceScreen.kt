package com.example.education.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerformanceScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Performance Tracking") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp)) {
            Text("Student: Rahul Kumar", style = MaterialTheme.typography.headlineSmall)
            Spacer(Modifier.height(16.dp))
            
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Mathematics: 85/100")
                    LinearProgressIndicator(progress = { 0.85f }, modifier = Modifier.fillMaxWidth())
                    Spacer(Modifier.height(8.dp))
                    Text("Science: 92/100")
                    LinearProgressIndicator(progress = { 0.92f }, modifier = Modifier.fillMaxWidth())
                    Spacer(Modifier.height(8.dp))
                    Text("English: 78/100")
                    LinearProgressIndicator(progress = { 0.78f }, modifier = Modifier.fillMaxWidth())
                }
            }
            
            Spacer(Modifier.height(24.dp))
            Text("AI Insights", style = MaterialTheme.typography.titleMedium)
            Text("You are doing great in Science! Focus more on Mathematics geometry sections to improve your overall score.", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
