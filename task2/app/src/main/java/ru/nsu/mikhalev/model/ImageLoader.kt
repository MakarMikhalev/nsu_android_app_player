package ru.nsu.mikhalev.model

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import ru.nsu.mikhalev.R

object ImageLoader {
    private const val ROUNDING_RADIUS = 20;

    fun loadRoundedImage(imageView: ImageView, imageUrl: Any) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(ROUNDING_RADIUS)))
            .error(R.drawable.rounded_corners)
            .placeholder(R.drawable.rounded_corners)
            .into(imageView)
    }
}