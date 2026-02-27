package com.example.praktam_2407051006.model

import androidx.annotation.DrawableRes

data class Habit(
    val nama: String,
                 val deskripsi: String,
                 val target: String,
                 @DrawableRes val imageRes: Int
)
