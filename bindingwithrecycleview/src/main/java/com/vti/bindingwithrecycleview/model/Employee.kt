package com.vti.bindingwithrecycleview.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName
import com.vti.bindingwithrecycleview.R


class  Employee{
    @SerializedName("avatar")
    val avatar: String? = null

    @SerializedName("email")
    val email: String? = null

    @SerializedName("first_name")
    val firstName: String? = null

    @SerializedName("id")
    val id: Long? = null

    @SerializedName("last_name")
    val lastName: String? = null

    companion object{
        @JvmStatic
        @BindingAdapter("avatar")
        fun loadImage(imageView: ImageView, urlImage: String) {
            Glide.with(imageView.context)
                .setDefaultRequestOptions(RequestOptions().circleCrop()).load(urlImage)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)
        }
    }
    // important func for load image here\



}
