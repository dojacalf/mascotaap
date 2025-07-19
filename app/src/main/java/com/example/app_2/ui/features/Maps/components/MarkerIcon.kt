package com.example.app_2.ui.features.Maps.components

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory

fun createCircularMarkerIcon(
    context: Context,
    imageRes: Int,
    backgroundColor: Color
): BitmapDescriptor {
    val size = 120
    val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)

    // Fondo circular
    val paint = Paint().apply {
        color = backgroundColor.toArgb()
        style = Paint.Style.STROKE
        strokeWidth = 2f
        isAntiAlias = true
    }
    canvas.drawCircle(size / 2f, size / 2f, size / 2f, paint)

    val drawable = ContextCompat.getDrawable(context, imageRes)
    drawable?.let {
        val scale = 1.0f // Escala de la imagen dentro del círculo
        val imageSize = (size * scale).toInt()
        val left = (size - imageSize) / 2
        val top = (size - imageSize) / 2

        it.setBounds(left, top, left + imageSize, top + imageSize)
        it.draw(canvas)
    }

    return BitmapDescriptorFactory.fromBitmap(bitmap)
}