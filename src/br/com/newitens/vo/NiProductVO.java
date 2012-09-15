/**
 * 
 */
package br.com.newitens.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Felipe
 *
 */
public class NiProductVO {

	private long productId;        
	private String description; 
	private float price;    
	private String registerDate;
	private List<NiCategoryVO> category;
	private List<NiFeatureVO> feature;
	private List<NiTagSearchVO> tags;
	
	public NiProductVO(){
		productId = 0;
		description = new String();
		price = 0;
		registerDate = new String();
		category = new ArrayList<NiCategoryVO>();
		feature = new ArrayList<NiFeatureVO>();
		tags = new ArrayList<NiTagSearchVO>();
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public List<NiCategoryVO> getCategory() {
		return category;
	}

	public void setCategory(List<NiCategoryVO> category) {
		this.category = category;
	}

	public List<NiFeatureVO> getFeature() {
		return feature;
	}

	public void setFeature(List<NiFeatureVO> feature) {
		this.feature = feature;
	}

	public List<NiTagSearchVO> getTags() {
		return tags;
	}

	public void setTags(List<NiTagSearchVO> tags) {
		this.tags = tags;
	}

}
