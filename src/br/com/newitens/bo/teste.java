/**
 * 
 */
package br.com.newitens.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.newitens.dao.DatabaseManager;
import br.com.newitens.util.Validator;
import br.com.newitens.vo.NiCategoryVO;
import br.com.newitens.vo.NiUserVO;

/**
 * @author Felipe
 *
 */
public class teste {
	
	public static void main(String[] args) {
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		NiCategoryVO temp;
		ArrayList<NiCategoryVO> lista = new ArrayList<NiCategoryVO>();
		
			conn = DatabaseManager.getConnection();
			
			String sql = " SELECT * FROM new_itens_owner.ni_category ";

			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					temp = new NiCategoryVO();
					temp.setCategoryId(rs.getLong("category_id"));
					temp.setDescription(rs.getString("description"));
					lista.add(temp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public long chicoBento(NiUserVO userVO){
		System.out.println("Chico Bento");
		String teste = userVO.getBirthDate();
		
		System.out.println(teste);
		System.out.println(Validator.isValidDate(teste));
		
		return 0;
		//return NiUserDAO.insertUser(userVO);
		
	}

}
