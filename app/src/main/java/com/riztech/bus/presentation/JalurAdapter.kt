package com.riztech.bus.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.riztech.bus.R

class JalurAdapter(private val list: ArrayList<String>, private val listener: OnClickItem) :RecyclerView.Adapter<JalurAdapter.JalurViewHolder>(){

    interface OnClickItem{
        fun clickJalur(string: String)
    }

    class JalurViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(string: String, listener: OnClickItem){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JalurViewHolder = JalurViewHolder(
        LayoutInflater.from(parent.context).inflate(
        R.layout.jalur_item, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: JalurViewHolder, position: Int) = holder.bind(list[position], listener)
}