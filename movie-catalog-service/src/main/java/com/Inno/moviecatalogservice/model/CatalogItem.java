package com.Inno.moviecatalogservice.model;

public class CatalogItem {
	public String movieName;
	public String description;
	public int rating;
	
	public CatalogItem(String movieName, String description, int rating) {
		super();
		this.movieName = movieName;
		this.description = description;
		this.rating = rating;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	

}
