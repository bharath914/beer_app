package com.bharath.beerapp.data.mappers

import com.bharath.beerapp.data.remote.beerDto
import com.bharath.beerapp.domain.Beer
import com.bharath.beerapp.local.BeerEntity

fun beerDto.toBeerEntity(): BeerEntity{
    return BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = first_brewed,
        imageUrl = image_url
    )

}

fun BeerEntity.toBeer() :Beer{
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        first_brewed = firstBrewed,
        image_url = imageUrl
    )
}