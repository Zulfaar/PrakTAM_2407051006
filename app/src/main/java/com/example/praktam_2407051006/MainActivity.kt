package com.example.praktam_2407051006

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HealthyHabitScreen()
        }
    }
}

data class Habit(
    val name: String,
    val description: String,
    val image: Int
)

val habitList = listOf(

    Habit("Minum Air", "Minum minimal 8 gelas air setiap hari.", R.drawable.minum_air),
    Habit("Olahraga", "Olahraga minimal 30 menit.", R.drawable.olahraga),
    Habit("Tidur Cukup", "Tidur 7-8 jam setiap malam.", R.drawable.tidur),
    Habit("Makan Sehat", "Perbanyak sayur dan buah.", R.drawable.makan)
)

@Composable
fun HealthyHabitScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Healthy Habit Tracker",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        habitList.forEach { habit ->
            HabitItem(habit)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun HabitItem(habit: Habit) {


    var isDone by remember { mutableStateOf(false) }


    var isFavorite by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {


        Box {

            Image(
                painter = painterResource(id = habit.image),
                contentDescription = habit.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )


            IconButton(
                onClick = { isFavorite = !isFavorite },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = if (isFavorite) Color.Red else Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = habit.name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Text(text = habit.description)

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { isDone = !isDone },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                if (isDone) "Sudah Selesai ✅"
                else "Tandai Selesai"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHealthyHabit() {
    HealthyHabitScreen()
}