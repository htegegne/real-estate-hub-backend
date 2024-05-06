/**
 * 
 */
package com.habte.real_estate.generic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * @author habta
 *
 */
public interface GenericService <T, ID> {

	 List<T> findAll();
	    T findById(ID id);
	    T save(T entity);
	    void deleteById(ID id);
}
