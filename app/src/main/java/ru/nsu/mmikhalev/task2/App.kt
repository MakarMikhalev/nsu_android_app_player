package ru.nsu.mmikhalev.task2

import android.app.Application
import ru.nsu.mmikhalev.task2.service.SongService

class App : Application() {
    val songService = SongService()
}