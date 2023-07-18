package com.bharath.beerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.bharath.beerapp.presentation.BeerScreen
import com.bharath.beerapp.presentation.BeerViewModel
import com.bharath.beerapp.ui.theme.BeerAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeerAppTheme {
                Surface(color = MaterialTheme.colorScheme.surface) {

                    val beerVm= hiltViewModel<BeerViewModel>()
                    val beers = beerVm.beerPagingFlow.collectAsLazyPagingItems()
                    BeerScreen(beers = beers)

                }


            }
        }
    }
}
