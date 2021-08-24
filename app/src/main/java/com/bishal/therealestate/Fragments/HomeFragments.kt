package com.bishal.therealestate.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bishal.therealestate.Adpters.Useradapters
import com.bishal.therealestate.R
import com.bishal.therealestate.model.Estate
import com.bishal.therealestate.repository.ArtistRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragments : Fragment() {
 private lateinit var rvestate:RecyclerView
 private lateinit var btnHire:Button
 private lateinit var btnLearn:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_home_fragments, container, false)
        rvestate=view.findViewById(R.id.rvestate)

        loadUserAdapter()

        return view

    }

    private fun loadUserAdapter() {
        CoroutineScope(Dispatchers.IO).launch {
//            try {
                val productRepository=ArtistRepository()
                val response = productRepository.getAllArtist()
                if (response.success == true) {
                    // Put all the student details in lstStudents
                    val listUsers: Array<Estate>? = response.data
                    Log.d("response",response.toString());
                    withContext(Dispatchers.Main) {
                        val adapter=Useradapters( requireContext(),listUsers!!)
                        rvestate.layoutManager=LinearLayoutManager(context)
                        rvestate.adapter=adapter
                    }
                }
//            } catch (ex: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(
//                        context,
//                        "Error", Toast.LENGTH_SHORT
//                    ).show()
//                }
            }
        }
//    }
}



