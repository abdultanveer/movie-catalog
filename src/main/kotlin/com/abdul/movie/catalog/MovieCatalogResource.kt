package com.abdul.movie.catalog

import com.abdul.movie.catalog.model.CatalogItem
import com.abdul.movie.catalog.model.Rating
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.function.Function
import java.util.stream.Collectors


@RestController
@RequestMapping("/catalog")
class MovieCatalogResource {
    @GetMapping("/{userId}")
    fun getCatalog(@PathVariable("userId") userId: String?): List<CatalogItem> {

        val ratings: List<Rating> = Arrays.asList<Rating>( //mocking call to ratings ms
            Rating("movieOne", 1),
            Rating("movieTwo", 2),
            Rating("movieThree", 3)
        )

        return ratings.stream() //putting the list of items [emptying the bag on a] conveyor belt
            .map(Function { rating: Rating? ->
                CatalogItem(
                    "movieOne",
                    "description",
                    1
                )
            }) //converting each rating item moving on the conveyor belt TO  catalogitem
            .collect(Collectors.toList()) //after all the items have been converted put it back into the bag[list]

    }
}
