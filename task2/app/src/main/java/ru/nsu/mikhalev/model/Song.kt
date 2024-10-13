package ru.nsu.mikhalev.model

data class Song(
    val id: Long,
    val name: String,
    val author: String,
    val photo: Int,
    var isPlayed: Boolean
)