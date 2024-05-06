/**
 * 
 */
package com.habte.real_estate.property;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author habta
 *
 */
@Repository(value = "propertyAddressRepository")
public interface PropertyAddressRepository extends JpaRepository<PropertyAddress, Integer> {

}
