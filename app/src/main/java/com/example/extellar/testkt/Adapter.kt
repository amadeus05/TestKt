package com.example.extellar.testkt

import android.app.Dialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class Adapter(val itemsList: ArrayList<Template>) : RecyclerView.Adapter<Adapter.ViewHolder>()  {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)



        val h : ViewHolder = ViewHolder(v)
        h.itemView.setOnClickListener(View.OnClickListener {


        })


        return ViewHolder(v)



    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tamplates: Template = itemsList[position]
        holder?.title1?.text = tamplates.getTitle()
        holder?.content1?.text = tamplates.getBody()
        holder.itemView.setOnClickListener(View.OnClickListener {
            Log.d("CLIIICK " ,  tamplates.getId().toString())




        })

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title1 = itemView.findViewById(R.id.title) as TextView
        val content1 = itemView.findViewById(R.id.content) as TextView




    }

}
