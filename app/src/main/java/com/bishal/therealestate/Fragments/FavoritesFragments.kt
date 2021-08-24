package com.bishal.therealestate.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bishal.therealestate.Adpters.FavoritesAdapters
import com.bishal.therealestate.R
import com.bishal.therealestate.model.Estate
import com.bishal.therealestate.repository.ArtistRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritesFragments : Fragment() {
private lateinit var rvFav : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_favorites_fragments, container, false)
        rvFav=view.findViewById(R.id.rvFav)

        loadFavAdapter()

        return view
    }
    private fun loadFavAdapter() {
        CoroutineScope(Dispatchers.IO).launch {
//            try {
                val productRepository= ArtistRepository()
                val response = productRepository.getAllArtist()
                if (response.success == true) {
                    // Put all the student details in lstStudents
                    val listUsers: Array<Estate>? = response.data
                    Log.d("response",response.toString());
                    withContext(Dispatchers.Main) {
                        val adapter= FavoritesAdapters( requireContext(),listUsers!!)
                        rvFav.layoutManager= LinearLayoutManager(context)
                        rvFav.adapter=adapter
                    }
                }
//            } catch (ex: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(
//                        context,
//                        "Success ", Toast.LENGTH_SHORT
//                    ).show()
//                }
            }
        }
//    }

}