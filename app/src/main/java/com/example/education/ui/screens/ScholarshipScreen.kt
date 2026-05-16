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

data class Scholarship(val name: String, val eligibility: String, val amount: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScholarshipScreen(onBack: () -> Unit) {
    val scholarships = listOf(
        Scholarship("National Merit Scholarship", "80% and above in 10th", "₹10,000 / year"),
        Scholarship("Rural Education Support", "Students from rural areas", "₹5,000 / year"),
        Scholarship("Science Talent Search", "Top 1% in Science", "₹15,000 / year"),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Scholarship Information") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(scholarships) { scholarship ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(scholarship.name, fontWeight = FontWeight.Bold)
                        Text("Eligibility: ${scholarship.eligibility}", style = MaterialTheme.typography.bodySmall)
                        Spacer(Modifier.height(4.dp))
                        Text("Amount: ${scholarship.amount}", color = MaterialTheme.colorScheme.primary)
                        Spacer(Modifier.height(8.dp))
                        Button(onClick = { /* Apply */ }) {
                            Text("Apply Now")
                        }
                    }
                }
            }
        }
    }
}
