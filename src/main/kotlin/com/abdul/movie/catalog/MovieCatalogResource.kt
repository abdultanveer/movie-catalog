package com.abdul.movie.catalog

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("/catalog")
class MovieCatalogResource {
    @GetMapping("/{userId}")
    fun getCatalog(@PathVariable("userId") userId: String?): List<CatalogItem> {
        return Arrays.asList(
            CatalogItem("firstmovie", "first movie desc", 1),
            CatalogItem("secondmovie", "second movie desc", 2)

        )
    }
}
