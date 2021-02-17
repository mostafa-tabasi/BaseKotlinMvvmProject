package com.mstf.basekotlinmvvm.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingUtils {

    /*
    @BindingAdapter("adapter")
    fun addBlogItems(recyclerView: RecyclerView, blogs: List<BlogResponse.Blog>?) {
        val adapter: BlogAdapter = recyclerView.adapter as BlogAdapter
        if (adapter != null) {
            adapter.clearItems()
            adapter.addItems(blogs)
        }
    }
    */

    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String) {
        val context = imageView.context
        Glide.with(context).load(url).into(imageView)
    }
}