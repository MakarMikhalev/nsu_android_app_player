package ru.nsu.mikhalev.repository

import ru.nsu.mikhalev.R

class ImageRepository {

    private val images: List<Int> = listOf(
        R.drawable.image
    )

    fun getImageByIndex(index: Int): Int {
        return images[index % images.size]
    }
}