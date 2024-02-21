package com.example.tyyy

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devrevtesst.CustomNetworkSDK
import com.example.devrevtesst.NetworkCallback
import com.google.gson.Gson


class LetestMoviesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_letest_movies, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)

        CustomNetworkSDK.get("https://api.themoviedb.org/3/movie/latest?api_key=909594533c98883408adef5d56143539",object :
            NetworkCallback {
            override fun onSuccess(response: String?) {
                val gson = Gson()

                val moviesesResponse: MovieModel = gson.fromJson(response, MovieModel::class.java)
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = ItemAdapter(moviesesResponse)
                println("hhh"+response);
            }


            override fun onError(errorMessage: String?) {
                println("hhh"+errorMessage);
            }

        })
        // Inflate the layout for this fragment
        return view



    }

}