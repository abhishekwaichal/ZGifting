/**
 * 
 */
package com.gifting.beans;

/**
 * @author Abhishek
 *
 */

public class ProductDetails {

	
	private String productUrl;
	private String color;
	private Double originalPrice;
	private Integer percentOff;
	private String imageUrl;
	private Double price;
	private Integer styleId;
	
	public ProductDetails() {

	}

	public ProductDetails(String productUrl, String color,
			Double originalPrice, Integer percentOff, String imageUrl,
			Double price, Integer styleId) {
		super();
		this.productUrl = productUrl;
		this.color = color;
		this.originalPrice = originalPrice;
		this.percentOff = percentOff;
		this.imageUrl = imageUrl;
		this.price = price;
		this.styleId = styleId;
	}

	@Override
	public String toString() {
		return "ProductDetails [productUrl=" + productUrl + ", color=" + color
				+ ", originalPrice=" + originalPrice + ", percentOff="
				+ percentOff + ", imageUrl=" + imageUrl + ", price=" + price
				+ ", styleId=" + styleId + "]";
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Integer getPercentOff() {
		return percentOff;
	}

	public void setPercentOff(Integer percentOff) {
		this.percentOff = percentOff;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStyleId() {
		return styleId;
	}

	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result
				+ ((originalPrice == null) ? 0 : originalPrice.hashCode());
		result = prime * result
				+ ((percentOff == null) ? 0 : percentOff.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((productUrl == null) ? 0 : productUrl.hashCode());
		result = prime * result + ((styleId == null) ? 0 : styleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDetails other = (ProductDetails) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (originalPrice == null) {
			if (other.originalPrice != null)
				return false;
		} else if (!originalPrice.equals(other.originalPrice))
			return false;
		if (percentOff == null) {
			if (other.percentOff != null)
				return false;
		} else if (!percentOff.equals(other.percentOff))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productUrl == null) {
			if (other.productUrl != null)
				return false;
		} else if (!productUrl.equals(other.productUrl))
			return false;
		if (styleId == null) {
			if (other.styleId != null)
				return false;
		} else if (!styleId.equals(other.styleId))
			return false;
		return true;
	}
	
	
	
}
