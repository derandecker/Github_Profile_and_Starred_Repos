package com.derandecker.githubprofileandstarredrepos

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("profileImage")
fun bindProfileImage(imageView: ImageView, url: String?) {
        Picasso.get()
            .load(url)
            .into(imageView)
}