package com.example.app_2.ui.features.Maps.components

import com.google.android.gms.maps.model.LatLng

data class PetLocation(
    val id: Int,
    val nombre: String,
    val ubicacion: String,
    val tipo: String,
    val coordenadas: LatLng,
    val imagen: Int
)