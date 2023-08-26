package com.example.superheroes.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.superheroes.R

data class SuperHero (
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val imageResource: Int,
)

val SuperHeroes = listOf<SuperHero>(
    SuperHero(
        name = R.string.hero1,
        description = R.string.description1,
        imageResource = R.drawable.android_superhero1
    ),
    SuperHero(
        name = R.string.hero2,
        description = R.string.description2,
        imageResource = R.drawable.android_superhero2
    ),
    SuperHero(
        name = R.string.hero3,
        description = R.string.description3,
        imageResource = R.drawable.android_superhero3
    ),
    SuperHero(
        name = R.string.hero4,
        description = R.string.description4,
        imageResource = R.drawable.android_superhero4
    ),
    SuperHero(
        name = R.string.hero5,
        description = R.string.description5,
        imageResource = R.drawable.android_superhero5
    ),
    SuperHero(
        name = R.string.hero6,
        description = R.string.description6,
        imageResource = R.drawable.android_superhero6
    )
)

