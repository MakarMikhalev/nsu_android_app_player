package ru.nsu.mmikhalev.task2.service

import ru.nsu.mmikhalev.task2.model.Image
import ru.nsu.mmikhalev.task2.model.Song

class SongService {
    private var images = mutableListOf<Image>()
    private var songs = mutableListOf<Song>()

    init {
        val startIndex = 0
        val endIndex = 50

        val imageLoaderService = ImageLoaderService()
        images = (startIndex..endIndex).map { index ->
            Image(
                id = index,
                resourceId = imageLoaderService.getImageByIndex(index)
            )
        }.toMutableList()

        songs = images.mapIndexed { index, image ->
            Song(
                id = index.toLong(),
                image = image
            )
        }.toMutableList()
    }

    fun getSongs(): List<Song> = songs
}