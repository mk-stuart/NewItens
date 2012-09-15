/**
 * 
 */
package br.com.newitens.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.newitens.bo.NiCategoryBO;
import br.com.newitens.vo.NiCategoryVO;

/**
 * @author Felipe
 *
 */
@ManagedBean
@SessionScoped
public class CategoryBean {

	private String message;
	private List<NiCategoryVO> categories;
	private NiCategoryBO categoryBO;

	
	//Populate Methods
	@PostConstruct
	public void populateCategories(){
		categoryBO = new NiCategoryBO();
		categories = categoryBO.getCategories();
	}
	
	// Getters and Setters
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<NiCategoryVO> getCategories() {
		return categories;
	}
	public void setCategories(List<NiCategoryVO> categories) {
		this.categories = categories;
	}

}
