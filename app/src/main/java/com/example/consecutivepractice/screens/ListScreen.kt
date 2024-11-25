package com.example.consecutivepractice.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Card
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.consecutivepractice.components.MovieViewModel

@Composable
fun ListScreen(onCardClick: (Int) -> Unit) {
    val viewModel = viewModel<MovieViewModel>()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(viewModel.movies) { movie ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .shadow(8.dp, RoundedCornerShape(8.dp))
                    .clickable { onCardClick(movie.id) }
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberImagePainter(movie.posterUrl),
                        contentDescription = null,
                        modifier = Modifier.size(170.dp)
                    )
                    Column {
                        Text(
                            movie.title,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = movie.genres,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = movie.description.take(50) + "...",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun FilmPreviewImage(imageUri: Uri) {

}