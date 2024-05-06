package com.habte.real_estate.realtor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtorRepository extends JpaRepository<Realtor, Integer> {

	@Query("SELECT r FROM Realtor r WHERE r.firstName LIKE %:query% "
			+ "OR r.phoneNumber LIKE %:query%")
	List<Realtor> findByNameOrPhone(@Param("query")String query);

	
}
