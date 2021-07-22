package com.vti.rxjavawithretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_android_version.view.*

class AndroidAdapter(var androidVersions : List<AndroidVersion>):
    RecyclerView.Adapter<AndroidAdapter.AndroidHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AndroidHolder {
      return AndroidHolder.create(parent)
    }

    override fun onBindViewHolder(holder: AndroidHolder, position: Int) = holder.bind(androidVersions[position])

    override fun getItemCount(): Int  = androidVersions.size
    class AndroidHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        companion object  {
            fun create (parent: ViewGroup):AndroidHolder {
                 return AndroidHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_android_version,parent,false))
            }
        }
        fun bind(androidVersion: AndroidVersion){
            itemView.apply {
                tv_name.text = androidVersion.name
                tv_version.text = androidVersion.version
                tv_api_level.text = androidVersion.api

            }
        }

    }


}