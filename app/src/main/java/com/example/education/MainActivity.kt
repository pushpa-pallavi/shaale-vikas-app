package com.example.education

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.education.ui.screens.AttendanceScreen
import com.example.education.ui.screens.CommunicationScreen
import com.example.education.ui.screens.HomeScreen
import com.example.education.ui.screens.LearningAssistantScreen
import com.example.education.ui.screens.NoticeBoardScreen
import com.example.education.ui.screens.PerformanceScreen
import com.example.education.ui.screens.ReportIssueScreen
import com.example.education.ui.screens.ScholarshipScreen
import com.example.education.ui.theme.EducationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducationTheme {
                ShaaleVikasApp()
            }
        }
    }
}

@Composable
fun ShaaleVikasApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen { route ->
                navController.navigate(route)
            }
        }
        composable("report") {
            ReportIssueScreen(onBack = {
                navController.popBackStack()
            })
        }
        composable("assistant") {
            LearningAssistantScreen(onBack = {
                navController.popBackStack()
            })
        }
        composable("notices") {
            NoticeBoardScreen(onBack = {
                navController.popBackStack()
            })
        }
        composable("attendance") {
            AttendanceScreen(onBack = {
                navController.popBackStack()
            })
        }
        composable("scholarships") {
            ScholarshipScreen(onBack = {
                navController.popBackStack()
            })
        }
        composable("performance") {
            PerformanceScreen(onBack = {
                navController.popBackStack()
            })
        }
        composable("communication") {
            CommunicationScreen(onBack = {
                navController.popBackStack()
            })
        }
    }
}
