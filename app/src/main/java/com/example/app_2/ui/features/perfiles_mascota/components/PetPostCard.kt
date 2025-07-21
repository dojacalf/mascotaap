package com.example.app_2.ui.features.perfiles_mascota.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.app_2.R
import com.example.app_2.ui.features.perfiles_mascota.viewmodel.PetPost

@Composable
fun PetPostCard(
    post: PetPost,
    onAdoptClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(post.owner.profilePictureUrl)
                        .crossfade(true)
                        .error(R.drawable.ic_launcher_background) // Placeholder
                        .build(),
                    contentDescription = "Owner profile picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = post.owner.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            // Pet Image
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(post.pet.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = post.pet.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )

            // Actions
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* TODO: Handle like */ }) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "Like")
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { onAdoptClick(post.pet.id) },
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Icon(Icons.Default.Pets, contentDescription = "Adopt")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Adoptar")
                }
            }

            // Info
            Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)) {
                Text(
                    text = post.pet.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = post.pet.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2
                )
            }
        }
    }
}