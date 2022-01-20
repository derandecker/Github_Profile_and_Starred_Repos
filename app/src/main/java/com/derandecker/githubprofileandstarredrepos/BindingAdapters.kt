package com.derandecker.githubprofileandstarredrepos

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("profileImage")
fun bindProfileImage(imageView: ImageView, url: String?) {
        Picasso.get()
            .load(url)
            .into(imageView)
}

@BindingAdapter("watchersText")
fun bindWatchers(textView: TextView, number: Int) {
    val context = textView.context
    textView.text = String.format("$number " + context.getString(R.string.watchers))
}

@BindingAdapter("forksText")
fun bindForks(textView: TextView, number: Int) {
    val context = textView.context
    textView.text = String.format("$number " + context.getString(R.string.forks))
}

@BindingAdapter("starsText")
fun bindStars(textView: TextView, number: Int) {
    val context = textView.context
    textView.text = String.format("$number " + context.getString(R.string.stars))
}