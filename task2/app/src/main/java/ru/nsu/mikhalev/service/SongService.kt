package ru.nsu.mikhalev.service

import com.github.javafaker.Faker
import ru.nsu.mikhalev.model.Song
import ru.nsu.mikhalev.repository.ImageRepository

class SongService {
    private var songs = mutableListOf<Song>()
    private val imageRepository = ImageRepository()
    init {
        val startIndex = 0
        val endIndex = 50
        val faker = Faker.instance()
        songs = (startIndex..endIndex).map {
            Song(
                id = it.toLong(),
                name = faker.name().fullName(),
                author = faker.company().name(),
                photo = imageRepository.getImageByIndex(it),
                isPlayed = false
            )
        }.toMutableList()
    }

    fun getSongs(): List<Song> = songs
}