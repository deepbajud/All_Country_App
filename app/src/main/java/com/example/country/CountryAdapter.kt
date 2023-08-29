package com.example.country

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class CountryAdapter(countryModal: List<CountryModal>?, clickItem: CountryClick) : Adapter<CountryAdapter.CountryHolder>() {


    lateinit var context: Context
    var clickIntem = clickItem
    var countrylist = countryModal


    class CountryHolder(itemView: View) : ViewHolder(itemView) {

        var imgfleg = itemView.findViewById<ImageView>(R.id.imgfleg)
        var couname = itemView.findViewById<TextView>(R.id.namecou)
        var descou = itemView.findViewById<TextView>(R.id.descou)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {

        context = parent.context
        return CountryHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return countrylist?.size!!

    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.couname.text = countrylist?.get(position)?.name
        holder.descou.text = countrylist?.get(position)?.capital
        Glide.with(context).load(countrylist?.get(position)?.flags?.png).into(holder.imgfleg)

        holder.itemView.setOnClickListener {
            clickIntem.onTap(position)
        }

        }
    }
