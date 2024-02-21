package com.habte.real_estate.realtor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habte.real_estate.realtor.model.Realtor;

@Repository(value="realtorRepository")
public interface RealtorRepository extends JpaRepository<Realtor, Integer> {

}
