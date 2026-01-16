package com.abdul.movie.catalog

import com.abdul.movie.catalog.model.CatalogItem
import com.abdul.movie.catalog.model.Movie
import com.abdul.movie.catalog.model.Rating
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.util.*


@RestController
@RequestMapping("/catalog")
class MovieCatalogResource(
    private val restTemplate: RestTemplate

) {



    @GetMapping("/{userId}")
    fun getCatalog(@PathVariable("userId") userId: String?): CatalogItem {


//        val ratings: List<Rating> = Arrays.asList<Rating>(
//            //mocking call to ratings ms
//            Rating("movieOne", 1),
//            Rating("movieTwo", 2),
//            Rating("movieThree", 3)
//        )
//        val ratingsBag = Arrays.asList(
//            Rating("1234", 4),
//            Rating("5678", 3)
//        )

        val rating = restTemplate.getForObject<Rating>(
            "http://localhost:8082/ratingsdata/users",
            Rating::class.java
        )
        val movie: Movie? = restTemplate?.getForObject(
            "http://movie-info-service/movies/abdul",
                   Movie::class.java
               )


       var catalogItem = CatalogItem(movie?.movieName,
                         "description"+ rating!!.movieId,
            rating.rating
        )
        return catalogItem


//        return ratings!!.userRatings!!.stream() //putting the list of items [emptying the bag on a] conveyor belt
//            ?.map(Function { rating: Rating? ->
//
//                val movie: Movie? = restTemplate?.getForObject(
//                    "http://localhost:8083/movies/abdul",
//                    Movie::class.java
//                )
//                CatalogItem(
//                    ""+movie!!.movieName,
//                    "description"+ rating!!.movieId,
//                    rating.rating
//                )
//            })!!.toList()

    }
}
