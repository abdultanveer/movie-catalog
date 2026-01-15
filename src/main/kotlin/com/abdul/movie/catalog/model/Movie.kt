package com.abdul.movie.catalog.model

class Movie {
    var movieId: String? = null
    var movieName: String? = null


    constructor()

    constructor(movieId: String?, movieName: String?) : super() {
        this.movieId = movieId
        this.movieName = movieName
    }
}





