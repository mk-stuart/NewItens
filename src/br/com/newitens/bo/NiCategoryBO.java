package br.com.newitens.bo;

import java.util.List;

import br.com.newitens.dao.NiCategoryDAO;
import br.com.newitens.vo.NiCategoryVO;

public class NiCategoryBO {
	
	private NiCategoryDAO categoryDAO = new NiCategoryDAO();
	
	private List<NiCategoryVO> getFatherCategories(){
		return categoryDAO.getFatherCategories();
	}
	
	private List<NiCategoryVO> getChildCategories(long fatherCategoryId){
		return categoryDAO.getChildCategories(fatherCategoryId);
	}
	
	public List<NiCategoryVO> getCategories(){
		List<NiCategoryVO> temp;
		
		temp = this.getFatherCategories();
		
		System.out.println("TEMPO.SIZE -> " + temp.size());
		
		for(NiCategoryVO x : temp){
			x.setChildrens(this.getChildCategories(x.getCategoryId()));
			System.out.println("NAME -> " + x.getDescription());
			for(NiCategoryVO y : x.getChildrens()){
				System.out.println("DESC CHILD" + y.getDescription());
			}
			
		}
		
		return temp;
	}
}
