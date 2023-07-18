package com.bharath.beerapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bharath.beerapp.domain.Beer
import com.bharath.beerapp.ui.theme.BeerAppTheme

@Composable
fun BeerItem(
    beer: Beer,
    modifier: Modifier = Modifier,
) {

    Card(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(16.dp)
        ) {

            AsyncImage(
                model = beer.image_url,
                contentDescription = "Name of the Beer",
                modifier = Modifier
                    .weight(1f)
                    .height(145.dp)
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column(modifier = Modifier.weight(3f).fillMaxHeight()) {
                Text(
                    text = beer.name,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = beer.tagline,
                    fontStyle = FontStyle.Italic,
                    color = Color.LightGray,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = beer.description,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis

                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "First Brewed in : "+beer.first_brewed, modifier=Modifier.fillMaxWidth(), textAlign = TextAlign.End, color = MaterialTheme.colorScheme.primary, fontSize = 10.sp)
            }

        }
    }
}

@Preview
@Composable
private fun BeerPreview() {
    BeerAppTheme {
        BeerItem(
            beer = Beer(
                id = 1,
                name = "Budweiser",
                tagline = "Taste the thunder ! ",
                first_brewed = "02/2002",
                description = "This is a nice beer but tastes bad .\n I will Never Drink Alcohol again ",
                image_url = null
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}