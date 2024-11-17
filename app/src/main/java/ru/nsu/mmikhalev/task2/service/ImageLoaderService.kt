package ru.nsu.mmikhalev.task2.service

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import ru.nsu.mmikhalev.task2.R

class ImageLoaderService {
    private val roundingRadius = 20;

    private val images: List<Int> = listOf(
        R.drawable.image
    )

    fun getImageByIndex(index: Int): Int {
        return images[index % images.size]
    }

    fun loadRoundedImage(imageView: ImageView, imageUrl: Any) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(roundingRadius)))
            .error(R.drawable.rounded_corners)
            .placeholder(R.drawable.rounded_corners)
            .into(imageView)
    }
}