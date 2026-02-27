package com.example.praktam_2407051006.model

import com.example.praktam_2407051006.R

object HabitSource {

    val dummyHabit = listOf(
        Habit(
            nama = "Minum Air",
            deskripsi = "Minum 8 gelas air per hari",
            target = "8 Gelas",
            imageRes = R.drawable.minum_air
        ),
        Habit(
            nama = "Olahraga",
            deskripsi = "Olahraga minimal 30 menit",
            target = "30 Menit",
            imageRes = R.drawable.olahraga
        ),
        Habit(
            nama = "Tidur Cukup",
            deskripsi = "Tidur minimal 7-8 jam",
            target = "8 Jam",
            imageRes = R.drawable.tidur
        )
    )
}