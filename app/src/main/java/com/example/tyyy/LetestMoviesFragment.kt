package com.example.tyyy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        CustomNetworkSDK.get("https://dummy.restapiexample.com/api/v1/employees",object :
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
        return inflater.inflate(R.layout.fragment_letest_movies, container, false)



    }

}