package com.example.crytoui

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.majorik.sparklinelibrary.SparkLineLayout
import java.text.DecimalFormat

class CryptoAdapter(var list: List<ItemData>,var context: Context):RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {
    val formatted: DecimalFormat = DecimalFormat("###,###,###,###")

    //inner class viewholder
    inner class  CryptoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.tvTitle)
        val money = itemView.findViewById<TextView>(R.id.tvMoney)
        val up = itemView.findViewById<TextView>(R.id.tvUp)
        val amount = itemView.findViewById<TextView>(R.id.tvAmount)
        val cast = itemView.findViewById<TextView>(R.id.tvCast)
        val symbol = itemView.findViewById<ImageView>(R.id.imgLogo)
        val line  = itemView.findViewById<SparkLineLayout>(R.id.Line)
    }
    //declare inflate convert from xml to view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_wallet,parent,false)
        return CryptoViewHolder(view)
    }
    //return the size of list
    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.title.text =list.get(position).cryptoName
        holder.money.text = formatted.format(list.get(position).cryptoPrice).toString()
        holder.up.text = list.get(position).changePercent.toString() +"%"
        holder.cast.text ="$" + formatted.format(list.get(position).PropertyCast).toString()
        holder.amount.text = list.get(position).propertyAmount.toString() + list.get(position).cryptoName

        val drawableResourceID:Int =  holder.itemView.context.resources.getIdentifier(
            list[position].cryptoSymbol,"drawable",context.packageName)
        Glide.with(context).load(drawableResourceID).into(holder.symbol)

        if(list.get(position).changePercent > 0){
            holder.up.setTextColor(Color.parseColor("#12c737"))
        }else if(list.get(position).changePercent < 0){
            holder.up.setTextColor(Color.parseColor("#fc0000"))
        }else {
            holder.up.setTextColor(Color.parseColor("#ffffff"))
        }

        holder.line.setData(list.get(position).lineData)
    }
}

