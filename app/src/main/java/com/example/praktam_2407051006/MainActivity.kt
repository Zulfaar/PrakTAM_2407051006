package com.example.praktam_2407051006

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.praktam_2407051006.model.Habit
import com.example.praktam_2407051006.model.HabitSource
import com.example.praktam_2407051006.ui.theme.PrakTAM_2407051006Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrakTAM_2407051006Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    val habitList = HabitSource.dummyHabit.take(3) // ambil 3 data

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        items(habitList) { habit ->

            Column {

                Image(
                    painter = painterResource(id = habit.imageRes),
                    contentDescription = habit.nama,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Nama: ${habit.nama}")
                Text(text = "Deskripsi: ${habit.deskripsi}")
                Text(text = "Target: ${habit.target}")

                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}