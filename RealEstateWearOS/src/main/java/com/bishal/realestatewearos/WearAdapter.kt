package com.bishal.realestatewearos

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bishal.realestatewearos.R
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class  WearAdapter(

    private val context: Context,
    private val listEstate: Array<Estate>


): RecyclerView.Adapter<WearAdapter.StoryViewHolder>() {

    class StoryViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var imgProfile: ImageView
        val tvName: TextView
        val tvaddress : TextView
        val tvowner : TextView
        val tvdes : TextView
        val tvRate : TextView
        val btnbuy: ImageButton
        val btnfav: ImageButton


        init{
            imgProfile = view.findViewById(R.id.imgProfile)
            tvName= view.findViewById(R.id.tvName)
            tvowner= view.findViewById(R.id.tvowner)
            tvdes= view.findViewById(R.id.tvdes)
            tvaddress = view.findViewById(R.id.tvaddress)
            tvRate = view.findViewById(R.id.tvRate)
            btnbuy = view.findViewById(R.id.btnbuy)
            btnfav = view.findViewById(R.id.btnfav)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weardesign, parent, false)

        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val artist = listEstate[position]
//        println(artist)
        holder.tvName.text = artist.EstateName
        holder.tvaddress.text = artist.Address
        holder.tvRate.text=artist.PriceRate
        holder.tvdes.text = artist.Description
        holder.tvowner.text=artist.OwnerName
        holder.btnfav.setOnClickListener {
            Toast.makeText(context," Estate Added to Favorites !!", Toast.LENGTH_SHORT).show()
        }
//        holder.btnbuy.setOnClickListener({
//            context.startActivity(Intent(context,HireArtist::class.java))
//        })

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
        return listEstate.size

    }


}