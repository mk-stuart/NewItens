/**
 * 
 */
package br.com.newitens.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.newitens.vo.NiProductVO;

/**
 * @author Felipe
 *
 */
@ManagedBean
@ViewScoped
public class ProductBean {
	
	private NiProductVO productVO = new NiProductVO();
	private String message = new String();
	private List<NiProductVO> productList = null;
	
	public NiProductVO getProductVO() {
		return productVO;
	}
	
	public void setProductVO(NiProductVO productVO) {
		this.productVO = productVO;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<NiProductVO> getProductList() {
		return productList;
	}
	
	public void setProductList(List<NiProductVO> productList) {
		this.productList = productList;
	}
	
}
