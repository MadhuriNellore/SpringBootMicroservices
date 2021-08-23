package com.Inno.ratingsdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Inno.ratingsdataservice.model.Ratings;
import com.Inno.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("ratingsData")
public class RatingsResource {
	@GetMapping(path = "movieId")
	public Ratings getRatings(@RequestParam String movieId) {
		return new Ratings(movieId, 8);
	}

	@GetMapping(path = "users")
	public UserRating getUserRating(@RequestParam String userId) {
		List<Ratings> ratings = Arrays.asList(new Ratings("101", 4), new Ratings("102", 3), new Ratings("103", 4));
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}

}
