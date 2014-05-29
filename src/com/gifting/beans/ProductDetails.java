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
	private Float originalPrice;
	private Integer percentOff;
	private String imageUrl;
	private Float price;
	private Integer styleId;
	
	public ProductDetails(String productUrl, String color, Float originalPrice,
			Integer percentOff, String imageUrl, Float price, Integer styleId) {
		super();
		this.productUrl = productUrl;
		this.color = color;
		this.originalPrice = originalPrice;
		this.percentOff = percentOff;
		this.imageUrl = imageUrl;
		this.price = price;
		this.styleId = styleId;
	}
	public ProductDetails() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductDetails [productUrl=" + productUrl + ", color=" + color
				+ ", originalPrice=" + originalPrice + ", percentOff="
				+ percentOff + ", imageUrl=" + imageUrl + ", price=" + price
				+ ", styleId=" + styleId + "]";
	}
	public Integer getStyleId() {
		return styleId;
	}
	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
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
	public Float getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(Float originalPrice) {
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
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	
}
