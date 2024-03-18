package com.example.weather.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.databinding.ItemListBinding
import com.squareup.picasso.Picasso


class WeatherAdapter : ListAdapter<WeatherInformations, WeatherAdapter.Holder>(Comparator())  {

    class Holder (view : View) : RecyclerView.ViewHolder(view){
        val binding = ItemListBinding.bind(view)

        fun bind (item : WeatherInformations) = with(binding){

            textViewDate.text = item.time
            textViewCondition.text = item.condition
            textViewTemperature.text = item.currentTemp.ifEmpty { "${item.maxTem}°C/${item.minTem}°C" }
            Picasso.get().load("https:" + item.imageUrl).into(im)

        }

    }

    class Comparator : DiffUtil.ItemCallback<WeatherInformations>(){
        override fun areItemsTheSame(
            oldItem: WeatherInformations,
            newItem: WeatherInformations
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: WeatherInformations,
            newItem: WeatherInformations
        ): Boolean {
            return  oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

}