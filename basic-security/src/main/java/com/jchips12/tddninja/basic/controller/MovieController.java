package com.jchips12.tddninja.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jchips12.tddninja.basic.entity.Movie;
import com.jchips12.tddninja.basic.repository.MovieRepository;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	private MovieRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Movie add(@RequestBody Movie movie) {
		repository.saveAndFlush(movie);
		return movie;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Movie findOne(@PathVariable String id) {
		return repository.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Movie update(@PathVariable String id, @RequestBody Movie movie) {
		Movie model = repository.findOne(id);
		if (model != null) {
			model.setTitle(movie.getTitle());
			model.setDescription(movie.getDescription());
			return repository.saveAndFlush(model);
		}
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		repository.delete(id);
	}

}
