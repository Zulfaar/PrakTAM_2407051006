package com.example.praktam_2407051006

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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

    Habit(
        "Minum Air",
        "Minum minimal 8 gelas air setiap hari agar tubuh tetap terhidrasi.",
        R.drawable.minum_air
    ),

    Habit(
        "Olahraga",
        "Olahraga ringan minimal 30 menit setiap hari.",
        R.drawable.olahraga
    ),

    Habit(
        "Tidur Cukup",
        "Tidur 7-8 jam setiap malam agar tubuh tetap sehat.",
        R.drawable.tidur
    ),

    Habit(
        "Makan Sehat",
        "Perbanyak sayur dan buah untuk nutrisi tubuh.",
        R.drawable.makan
    )
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

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Image(
            painter = painterResource(id = habit.image),
            contentDescription = habit.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = habit.name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = habit.description
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Selesai")

        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewHealthyHabit() {
    HealthyHabitScreen()
}