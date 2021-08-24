package com.bishal.realestatewearos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DashBoardActivity : AppCompatActivity() {
    private lateinit var rvArtist: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        rvArtist=findViewById(R.id.rvArtist)

        loadUserAdapter()

    }

    private fun loadUserAdapter() {
        CoroutineScope(Dispatchers.IO).launch {
//            try {
                val productRepository= ArtistRepository()
                val response = productRepository.getAllArtist()
                if (response.success == true) {
                    // Put all the student details in lstStudents
                    val listUsers: Array<Estate>? = response.data
                    Log.d("response",response.toString());
                    withContext(Dispatchers.Main) {
                        val adapter= WearAdapter( this@DashBoardActivity,listUsers!!)
                        rvArtist.layoutManager= LinearLayoutManager(this@DashBoardActivity)
                        rvArtist.adapter=adapter
                    }
                }
//            } catch (ex: Exception) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(
//                        this@DashBoardActivity,
//                        "Error : ${ex.toString()}", Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
        }
    }
}