package ru.nsu.mmikhalev.task2.model

import ru.nsu.mmikhalev.task2.utils.RandomGeneratorUtils

data class Song(
    val id: Long,
    val image: Image,
    var isPlayed: Boolean = false,
    val name: String = RandomGeneratorUtils.getFaker().name().fullName(),
    val author: String = RandomGeneratorUtils.getFaker().company().name()
)