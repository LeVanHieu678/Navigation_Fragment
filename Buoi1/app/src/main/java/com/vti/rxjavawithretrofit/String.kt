package com.vti.rxjavawithretrofit

import android.content.Context
import android.widget.Toast

fun String?.showToast(text: String,context: Context) {
    Toast.makeText(context,text,Toast.LENGTH_SHORT).show()
}