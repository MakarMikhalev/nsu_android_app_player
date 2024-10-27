package ru.nsu.mmikhalev.task2.model

data class Song(
    val id: Long,
    val name: String,
    val author: String,
    val photo: Int,
    var isPlayed: Boolean
)