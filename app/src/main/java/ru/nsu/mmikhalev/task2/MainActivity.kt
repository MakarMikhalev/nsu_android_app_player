package ru.nsu.mmikhalev.task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.nsu.mmikhalev.task2.databinding.ActivityMainBinding
import ru.nsu.mmikhalev.task2.service.SongService

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SongAdapter
    private val songService: SongService
        get() = (applicationContext as App).songService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = LinearLayoutManager(this)

        adapter = SongAdapter()
        adapter.data = songService.getSongs()

        binding.recyclerView.layoutManager = manager
        binding.recyclerView.adapter = adapter
    }

}