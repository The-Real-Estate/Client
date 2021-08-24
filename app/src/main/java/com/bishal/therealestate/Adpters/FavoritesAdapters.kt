package com.bishal.therealestate.Adpters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bishal.therealestate.DashboardActivity
import com.bishal.therealestate.R
import com.bishal.therealestate.api.ServiceBuilder
import com.bishal.therealestate.model.Estate
import com.bumptech.glide.Glide

class FavoritesAdapters (

    private val context: Context,
    private val listUsers: Array<Estate>


): RecyclerView.Adapter<FavoritesAdapters.StoryViewHolder>() {

    class StoryViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var imgProfile: ImageView
        val tvName: TextView
        val tvaddress : TextView
        val tvowner : TextView
        val tvdes : TextView
        val tvRate : TextView
        val btnDelete: Button



        init{
            imgProfile = view.findViewById(R.id.imgProfile)
            tvName= view.findViewById(R.id.tvName)
            tvowner= view.findViewById(R.id.tvowner)
            tvdes= view.findViewById(R.id.tvdes)
            tvaddress = view.findViewById(R.id.tvaddress)
            tvRate = view.findViewById(R.id.tvRate)
            btnDelete = view.findViewById(R.id.btnDelete)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favoritesdesign, parent, false)

        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val artist = listUsers[position]
//        println(artist)
        holder.tvName.text = artist.EstateName
        holder.tvaddress.text = artist.Address
        holder.tvRate.text=artist.PriceRate
        holder.tvdes.text = artist.Description
        holder.tvowner.text=artist.OwnerName
        holder.btnDelete.setOnClickListener({
            Toast.makeText(context," Estate Deleted From Favorites !!", Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context, DashboardActivity::class.java))
        })

        val imagePath = ServiceBuilder.loadImagePath() + artist.Pimage
        Log.d("TAG", "onBindViewHolder: "+ imagePath)
        if (!artist.Pimage.equals("noimg.png")) {
            Glide.with(context)
                .load(imagePath)
//                .fitCenter()
                .into(holder.imgProfile)
        }
    }

    override fun getItemCount(): Int {
        return listUsers.size

    }


}