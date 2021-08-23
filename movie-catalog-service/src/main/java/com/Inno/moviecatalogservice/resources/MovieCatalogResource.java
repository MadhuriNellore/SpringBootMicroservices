package com.Inno.moviecatalogservice.resources;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.Inno.moviecatalogservice.model.CatalogItem;
import com.Inno.moviecatalogservice.model.Movie;
import com.Inno.moviecatalogservice.model.Ratings;
import com.Inno.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("catalog")
public class MovieCatalogResource {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WebClient.Builder webClientBuilder;

	// Get all rated movie Ids
	@GetMapping(path = "userId")
	public List<CatalogItem> getCatalog(@RequestParam String userId) {

		UserRating ratings = restTemplate.getForObject("http:localhost:8765//ratings-data-service/ratingsData/users?userId=" + userId,
				UserRating.class);
		return ratings.getUserRating().stream().map(rating -> {
			//for each movie Id, call movie info service and get details.
			Movie movie = restTemplate
					.getForObject("http:localhost:8765//movie-info-service/movies/movieId?movieId=" + rating.getMovieId(), Movie.class);
/*			//using webClient
			Movie movie = webClientBuilder.build()
					.get()
					.uri("http://localhost:8082/movies/movieId?movieId="+rating.getMovieId())
					.retrieve()
					.bodyToMono(Movie.class)
					.block();	*/
			//put them all together
			return new CatalogItem(movie.getName(), "Desc", rating.getRating());
		}).collect(Collectors.toList());
		// return Collections.singletonList(new CatalogItem("Bhahubali", "War", 8));
	}
}
