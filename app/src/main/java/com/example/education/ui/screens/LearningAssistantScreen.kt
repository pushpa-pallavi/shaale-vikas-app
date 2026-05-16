package com.example.education.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Message(val text: String, val isFromUser: Boolean)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearningAssistantScreen(onBack: () -> Unit) {
    var query by remember { mutableStateOf("") }
    val messages = remember { 
        mutableStateListOf(Message("Hello! I am your AI Learning Assistant. How can I help you today?", isFromUser = false))
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AI Learning Assistant") },
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
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(messages) { message ->
                    ChatBubble(message)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = query,
                    onValueChange = { query = it },
                    placeholder = { Text("Ask a question...") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(Modifier.width(8.dp))
                IconButton(
                    onClick = {
                        if (query.isNotEmpty()) {
                            messages.add(Message(query, isFromUser = true))
                            // Simulate AI Response
                            messages.add(Message("That's a great question about $query! Let me look that up for you.", isFromUser = false))
                            query = ""
                        }
                    }
                ) {
                    Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "Send")
                }
            }
        }
    }
}

@Composable
fun ChatBubble(message: Message) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = if (message.isFromUser) Alignment.CenterEnd else Alignment.CenterStart
    ) {
        Surface(
            color = if (message.isFromUser) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondaryContainer,
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = message.text,
                modifier = Modifier.padding(12.dp),
                color = if (message.isFromUser) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}
