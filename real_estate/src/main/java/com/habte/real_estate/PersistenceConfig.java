/**
 * 
 */
package com.habte.real_estate;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.habte.real_estate.property.Property;
import com.habte.real_estate.property.PropertyAddress;
import com.habte.real_estate.realtor.Address;
import com.habte.real_estate.realtor.Realtor;

/**
 * @author habta
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = {
		 
		  "com.habte.real_estate.realtor"
		  
		}) 
public class PersistenceConfig {

}
