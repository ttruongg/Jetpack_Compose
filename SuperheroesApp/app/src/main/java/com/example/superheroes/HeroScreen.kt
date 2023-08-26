package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.data.HeroesRepository
import com.example.superheroes.model.SuperHero


@Composable
fun HeroList(
    Superheroes: List<SuperHero>,
    modifier: Modifier = Modifier) {

    LazyColumn(modifier = modifier) {
        items(Superheroes){ SuperHero ->
        HeroItem(
            hero = SuperHero,
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
        )
        }
    }
}


@Composable
fun HeroItem(
    hero: SuperHero,
    modifier: Modifier = Modifier
){
    Card (
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ){
            Column (modifier = Modifier.weight(1f))  {
                Text(
                    text = stringResource(id = hero.name),
                    style = MaterialTheme.typography.displaySmall
                )

                Text(
                    text = stringResource(id = hero.description),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier
                .size(72.dp)
                .clip(RoundedCornerShape(8.dp))

            ){
                Image(
                    painter = painterResource(id = hero.imageResource) ,
                    contentDescription = null,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillWidth

                )

            }

        }

    }
}

@Preview
@Composable
fun HeroPreview() {
    HeroList(Superheroes = HeroesRepository.heroes)
}