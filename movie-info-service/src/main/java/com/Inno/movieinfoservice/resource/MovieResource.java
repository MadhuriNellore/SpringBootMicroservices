package com.Inno.movieinfoservice.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Inno.movieinfoservice.model.Movie;

@RestController
@RequestMapping("movies")
public class MovieResource {
	@GetMapping("movieId")
	public Movie getMovieInfo(@RequestParam String movieId)
	{
		return new Movie(movieId,"Bahubali");
	}

}
