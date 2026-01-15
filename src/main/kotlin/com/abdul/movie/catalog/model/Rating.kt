package com.abdul.movie.catalog.model

class Rating {
    var movieId: String? = null
    var rating: Int = 0

    constructor()


    constructor(movieId: String?, rating: Int) : super() {
        this.movieId = movieId
        this.rating = rating
    }
}