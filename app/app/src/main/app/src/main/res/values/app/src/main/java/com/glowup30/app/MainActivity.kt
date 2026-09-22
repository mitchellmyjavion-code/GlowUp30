package com.glowup30.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GlowUp30App()
        }
    }
}

@Composable
fun GlowUp30App() {
    var selectedTab by remember { mutableStateOf("Today") }

    val background = Brush.verticalGradient(
        listOf(
            Color(0xFF09051A),
            Color(0xFF17103A),
            Color(0xFF28165A),
            Color(0xFF0B071D)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {

            Text(
                text = "✨ GlowUp30",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Your life. Your progress. Your journey.",
                color = Color(0xFFBDAEFF),
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(18.dp))

            when (selectedTab) {
                "Today" -> TodayScreen()
                "Schedule" -> ScheduleScreen()
                "Study" -> StudyScreen()
                "Japanese" -> JapaneseScreen()
                "Progress" -> ProgressScreen()
            }

            Spacer(modifier = Modifier.weight(1f))

            NavigationBar(
                containerColor = Color(0xCC100B29)
            ) {
                listOf(
                    "Today" to "🏠",
                    "Schedule" to "📅",
                    "Study" to "📚",
                    "Japanese" to "🇯🇵",
                    "Progress" to "📊"
                ).forEach { (name, icon) ->

                    NavigationBarItem(
                        selected = selectedTab == name,
                        onClick = { selectedTab = name },
                        icon = {
                            Text(icon, fontSize = 20.sp)
                        },
                        label = {
                            Text(name)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun GlassCard(
    title: String,
    subtitle: String,
    icon: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xCC21164A)
        )
    ) {
        Row(
            modifier = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = icon,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.width(14.dp))

            Column {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = subtitle,
                    color = Color(0xFFC7BCEB),
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Composable
fun TodayScreen() {
    LazyColumn {

        item {
            GlassCard(
                "🔥 Daily Streak",
                "Keep your streak going!",
                "🔥"
            )
        }

        item {
            GlassCard(
                "⭐ XP Level",
                "Level 1 • 0 / 100 XP",
                "⭐"
            )
        }

        item {
            GlassCard(
                "📚 Study",
                "25-minute focus session",
                "📚"
            )
        }

        item {
            GlassCard(
                "🇯🇵 Japanese",
                "Practice vocabulary today",
                "🇯🇵"
            )
        }

        item {
            GlassCard(
                "🧴 Self-Care",
                "Morning and night routine",
                "🧴"
            )
        }

        item {
            GlassCard(
                "🎮 Fun Time",
                "Gaming & creator time",
                "🎮"
            )
        }
    }
}

@Composable
fun ScheduleScreen() {
    Column {
        Text(
            "📅 Schedule",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        GlassCard("Morning", "Start your routine", "🌅")
        GlassCard("Afternoon", "School • Study • Activities", "☀️")
        GlassCard("Evening", "Japanese • Self-care • Fun", "🌙")
    }
}

@Composable
fun StudyScreen() {
    Column {
        Text(
            "📚 Study",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        GlassCard(
            "⏱️ Focus Session",
            "25 minutes • Earn XP",
            "⏱️"
        )

        GlassCard(
            "📝 Study Goals",
            "Complete today's tasks",
            "📝"
        )
    }
}

@Composable
fun JapaneseScreen() {
    Column {
        Text(
            "🇯🇵 Japanese",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        GlassCard(
            "🔥 Japanese Streak",
            "0 days",
            "🔥"
        )

        GlassCard(
            "⭐ Japanese XP",
            "0 XP",
            "⭐"
        )

        GlassCard(
            "🧠 Flashcards",
            "Practice vocabulary",
            "🧠"
        )

        GlassCard(
            "✍️ Writing",
            "Practice kana & words",
            "✍️"
        )
    }
}

@Composable
fun ProgressScreen() {
    Column {
        Text(
            "📊 Progress",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        GlassCard(
            "⭐ Total XP",
            "0 XP",
            "⭐"
        )

        GlassCard(
            "🔥 Current Streak",
            "0 days",
            "🔥"
        )

        GlassCard(
            "📚 Study Sessions",
            "0 completed",
            "📚"
        )

        GlassCard(
            "🇯🇵 Japanese Progress",
            "0 XP",
            "🇯🇵"
        )
    }
}
