package com.example.springrest.jpaplayground.manytomany.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ToyRepository extends PagingAndSortingRepository<Toy, Long>, CrudRepository<Toy, Long> {}
