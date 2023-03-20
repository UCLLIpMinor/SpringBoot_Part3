package com.example.springrest.jpaplayground.onetomany.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CartRepository extends PagingAndSortingRepository<Cart, Long>, JpaRepository<Cart, Long> {}
