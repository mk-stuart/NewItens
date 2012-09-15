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
public class NiCategoryVO {
	private long categoryId;        
	private String description;
	
	private NiCategoryVO father;
	private List<NiCategoryVO> childrens;
 	
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public NiCategoryVO getFather() {
		return father;
	}

	public void setFather(NiCategoryVO father) {
		if(father.childrens == null){
			father.childrens = new ArrayList<NiCategoryVO>();
		}
		
		if(!father.childrens.contains(this)){
			father.childrens.add(this);
		}
		this.father = father;
	}

	public List<NiCategoryVO> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<NiCategoryVO> childrens) {
		for(NiCategoryVO x : childrens){
			if(!this.equals(x.father)){
				x.father = this;
			}
		}
		this.childrens = childrens;
	}
	
	
}
