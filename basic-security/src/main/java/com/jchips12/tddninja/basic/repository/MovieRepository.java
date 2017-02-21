package com.jchips12.tddninja.basic.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jchips12.tddninja.basic.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Serializable> {

}
