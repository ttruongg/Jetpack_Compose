package com.example.superheroes.data

import com.example.superheroes.R
import com.example.superheroes.model.SuperHero

object HeroesRepository {
    val heroes = listOf(
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
}