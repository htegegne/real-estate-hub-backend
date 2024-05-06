/**
 * 
 */
package com.habte.real_estate.property;

import com.habte.real_estate.realtor.Realtor;

/**
 * @author habtamu
 *
 */
public class PropertyDTO {

	 private Integer propertyId;
		
		private String title;
		
		private String description;
		
		private double price;
		
		private double area;
		
		private int bedrooms;
		
		private double bathrooms;
		
		private PropertyAddress propertyAddress;
		
		private Realtor realtor;

		/**
		 * @return the propertyId
		 */
		public Integer getPropertyId() {
			return propertyId;
		}

		/**
		 * @param propertyId the propertyId to set
		 */
		public void setPropertyId(Integer propertyId) {
			this.propertyId = propertyId;
		}

		/**
		 * @return the title
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param title the title to set
		 */
		public void setTitle(String title) {
			this.title = title;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		/**
		 * @return the price
		 */
		public double getPrice() {
			return price;
		}

		/**
		 * @param price the price to set
		 */
		public void setPrice(double price) {
			this.price = price;
		}

		/**
		 * @return the area
		 */
		public double getArea() {
			return area;
		}

		/**
		 * @param area the area to set
		 */
		public void setArea(double area) {
			this.area = area;
		}

		/**
		 * @return the bedrooms
		 */
		public int getBedrooms() {
			return bedrooms;
		}

		/**
		 * @param bedrooms the bedrooms to set
		 */
		public void setBedrooms(int bedrooms) {
			this.bedrooms = bedrooms;
		}

		/**
		 * @return the bathrooms
		 */
		public double getBathrooms() {
			return bathrooms;
		}

		/**
		 * @param bathrooms the bathrooms to set
		 */
		public void setBathrooms(double bathrooms) {
			this.bathrooms = bathrooms;
		}

		/**
		 * @return the propertyAddress
		 */
		public PropertyAddress getPropertyAddress() {
			return propertyAddress;
		}

		/**
		 * @param propertyAddress the propertyAddress to set
		 */
		public void setPropertyAddress(PropertyAddress propertyAddress) {
			this.propertyAddress = propertyAddress;
		}

		/**
		 * @return the realtor
		 */
		public Realtor getRealtor() {
			return realtor;
		}

		/**
		 * @param realtor the realtor to set
		 */
		public void setRealtor(Realtor realtor) {
			this.realtor = realtor;
		}

		@Override
		public String toString() {
			return "PropertyDTO [propertyId=" + propertyId + ", title=" + title + ", description=" + description
					+ ", price=" + price + ", area=" + area + ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms
					+ ", propertyAddress=" + propertyAddress + ", realtor=" + realtor + "]";
		}
		
		
		

}
