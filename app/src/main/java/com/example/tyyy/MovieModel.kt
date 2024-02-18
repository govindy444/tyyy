package com.example.tyyy

data class MovieModel(val title: String, val description: String,val imageMovie: String)


data class MovieResponse(
     val movieRes: List<MovieModel>
)
