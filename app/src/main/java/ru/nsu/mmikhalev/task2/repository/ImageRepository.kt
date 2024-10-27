package ru.nsu.mmikhalev.task2.repository

import ru.nsu.mmikhalev.task2.R

class ImageRepository {

    private val images: List<Int> = listOf(
        R.drawable.image
    )

    fun getImageByIndex(index: Int): Int {
        return images[index % images.size]
    }
}