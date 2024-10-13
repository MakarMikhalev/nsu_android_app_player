package ru.nsu.mikhalev

import android.app.Application
import ru.nsu.mikhalev.service.SongService

class App : Application() {
    val songService = SongService()
}