package com.jchips12.tddninja.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jchips12.tddninja.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Serializable> {

}
