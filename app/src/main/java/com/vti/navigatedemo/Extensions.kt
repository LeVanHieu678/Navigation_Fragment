package com.vti.navigatedemo

import android.content.Context
import android.widget.Button
import android.widget.Toast

fun Button.showMessage(context: Context, content: String, duration : Int){
    Toast.makeText(context,content,duration).show()
}