package com.example.education.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class ChatItem(val name: String, val lastMessage: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunicationScreen(onBack: () -> Unit) {
    val chats = listOf(
        ChatItem("Mr. Sharma (Math Teacher)", "Your son is doing well."),
        ChatItem("School Office", "Please submit documents."),
        ChatItem("Class Representative", "Tomorrow is a holiday."),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Parent-Teacher Chat") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).fillMaxSize()) {
            items(chats) { chat ->
                ListItem(
                    headlineContent = { Text(chat.name) },
                    supportingContent = { Text(chat.lastMessage) },
                    leadingContent = { Icon(Icons.Default.Person, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth()
                )
                HorizontalDivider()
            }
        }
    }
}
