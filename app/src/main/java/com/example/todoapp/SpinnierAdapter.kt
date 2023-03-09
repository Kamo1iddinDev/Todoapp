package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.todoapp.Models.SpinnerItem
import com.example.todoapp.databinding.ItemSpinnerBinding

class SpinnierAdapter(val list: ArrayList<SpinnerItem>):BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
     return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemSpinnerBinding:ItemSpinnerBinding
        itemSpinnerBinding = ItemSpinnerBinding.inflate(LayoutInflater.from(parent?.context),parent, false)
        if (list[position].image!=-1){
            itemSpinnerBinding.image.setImageResource(list[position].image)
        }
        itemSpinnerBinding.tvName.text = list[position].degree
        return itemSpinnerBinding.root
    }
}