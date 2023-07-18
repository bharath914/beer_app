package com.bharath.beerapp.data.remote

data class beerDto(
    val id :Int,
    val name:String,
    val tagline :String,
    val description:String,
    val first_brewed:String,
    val image_url:String?
)
