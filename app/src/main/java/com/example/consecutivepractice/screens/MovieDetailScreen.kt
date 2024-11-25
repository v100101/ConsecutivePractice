package com.example.consecutivepractice.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.consecutivepractice.components.MovieViewModel

@Composable
fun MovieDetailScreen(movieId: Int, navController: NavController, viewModel: MovieViewModel = viewModel()) {
    val movie = viewModel.movies.find { it.id == movieId }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        if (movie != null) {
            Image(
                painter = rememberAsyncImagePainter(movie.posterUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = movie.title,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(text = movie.description)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = movie.genres)
            Text(text = movie.releaseDate)
        }
    }
}