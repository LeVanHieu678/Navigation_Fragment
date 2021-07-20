package com.vti.mvvmmodule

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("hideIfZero")
fun hideIfZero(view: View, number: Int) {
    if (!(number == 0).also { view.visibility = View.GONE }) {
        view.visibility = View.VISIBLE
    }
}

@BindingAdapter(value = ["app:progressBarScaled", "android:max"], requireAll = true)
fun setProgress(progressBar: ProgressBar, likes: Int, max: Int) {
    //Ensure that a value is special with specified value
    progressBar.progress = (likes * max / 100).coerceAtMost(max)
}

@BindingAdapter("app:progressTint")
fun tintPopularity(view: ProgressBar, popularity: Popularity) {
    val color = getAssociatedColor(popularity, view.context)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
    ) {
        view.progressTintList = color?.let { ColorStateList.valueOf(it) }
    }
}

@BindingAdapter("app:popularityIcon")
fun popularIcon(view: ImageView, popularity: Popularity) {
    val color = getAssociatedColor(popularity, view.context)
    ImageViewCompat.setImageTintList(view, color?.let { ColorStateList.valueOf(it) })
    view.setImageDrawable(getDrawablePopularity(popularity,view.context))
}

fun getAssociatedColor(popularity: Popularity, context: Context): Int? {
    return when (popularity) {
        Popularity.NORMAL ->
            context?.theme?.obtainStyledAttributes(
                intArrayOf(android.R.attr.colorForeground)
            )?.let {
                it.getColor(0, 0x000000)
            }
        Popularity.POPULAR -> ContextCompat.getColor(context, R.color.popular)
        Popularity.STAR -> ContextCompat.getColor(context, R.color.star)

    }
}



fun getDrawablePopularity(popularity: Popularity, context: Context?): Drawable? {
    return  when (popularity){
        Popularity.NORMAL -> context?.let { ContextCompat.getDrawable(it,R.drawable.ic_person_black_96dp) }
        Popularity.POPULAR,
        Popularity.STAR -> context?.let { ContextCompat.getDrawable(it,R.drawable.ic_whatshot_black_96dp) }
    }
}

