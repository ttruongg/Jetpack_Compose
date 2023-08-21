package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameTopic: Int,
    val availableCourse: Int,
    @DrawableRes val imageResourceID: Int,

)
