package ru.nsu.mikhalev

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.nsu.mikhalev.databinding.ItemSongBinding
import ru.nsu.mikhalev.model.ImageLoader
import ru.nsu.mikhalev.model.Song

class SongAdapter : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {
    var data: List<Song> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class SongViewHolder(val binding: ItemSongBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSongBinding.inflate(inflater, parent, false)
        return SongViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = data[position]
        with(holder.binding) {
            nameTextView.text = song.name
            companyTextView.text = song.author
            playingImageView.setImageResource(if (song.isPlayed) R.drawable.ic_pause else R.drawable.ic_play)

            playingImageView.setOnClickListener {
                handlePlayClick(song, position)
            }
            ImageLoader.loadRoundedImage(imageView, song.photo)
        }
    }

    private fun handlePlayClick(song: Song, position: Int) {
        song.isPlayed = !song.isPlayed
        val playingSongId = song.id

        data.filter { it.id != playingSongId && it.isPlayed }
            .forEach { otherSong ->
                otherSong.isPlayed = false
                notifyItemChanged(otherSong.id.toInt())
            }
        notifyItemChanged(position)
    }
}