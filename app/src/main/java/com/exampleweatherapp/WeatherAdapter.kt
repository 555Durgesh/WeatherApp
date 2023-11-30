package com.iitkgp.weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exampleweatherapp.MainActivity
import com.exampleweatherapp.R

class WeatherAdapter(val mainActivity: MainActivity, val list: List<ResponseModel?>) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view=LayoutInflater.from(parent.context).inflate(R.layout.weathercardview,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.CityTxt.text=list.get(position)!!.main!!.temp.toString()
        holder.weathertxt.text=list.get(position)!!.name.toString()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var weathertxt=itemView.findViewById<TextView>(R.id.WeatherTxt)
        var CityTxt=itemView.findViewById<TextView>(R.id.CityTxt)

    }
}