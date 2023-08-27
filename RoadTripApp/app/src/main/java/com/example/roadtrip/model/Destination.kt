package com.example.roadtrip.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Destination(
    @DrawableRes val imageResource: Int,
    @StringRes val description: Int
)
