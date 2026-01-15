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
import java.util.function.Function
import java.util.stream.Collectors


@RestController
@RequestMapping("/catalog")
class MovieCatalogResource {
    @GetMapping("/{userId}")
    fun getCatalog(@PathVariable("userId") userId: String?): List<CatalogItem> {

        val restTemplate = RestTemplate()

//        val ratings: List<Rating> = Arrays.asList<Rating>(
//            //mocking call to ratings ms
//            Rating("movieOne", 1),
//            Rating("movieTwo", 2),
//            Rating("movieThree", 3)
//        )
        val ratingsBag = Arrays.asList(
            Rating("1234", 4),
            Rating("5678", 3)
        )

        return ratingsBag.stream() //putting the list of items [emptying the bag on a] conveyor belt
            .map(Function { rating: Rating? ->

                val movie: Movie? = restTemplate.getForObject(
                    "http://localhost:8083/movies/abdul",
                    Movie::class.java
                )
                CatalogItem(
                    ""+movie!!.movieName,
                    "description"+ rating!!.movieId,
                    rating.rating
                )
            }) //converting each rating item moving on the conveyor belt TO  catalogitem
            .collect(Collectors.toList()) //after all the items have been converted put it back into the bag[list]

    }
}
