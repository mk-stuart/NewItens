/**
 * 
 */
package br.com.newitens.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.newitens.vo.NiCategoryVO;

/**
 * @author Felipe
 *
 */
public class NiCategoryDAO {

	public List<NiCategoryVO> getFatherCategories(){
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		NiCategoryVO categoryVO = null;
		List<NiCategoryVO> categories = new ArrayList<NiCategoryVO>();
		
		try{
			conn = DatabaseManager.getConnection();
			
			String sql = " SELECT * FROM new_itens_owner.ni_category " +
				         " WHERE father_category_id = 0 " +
				         " ORDER BY description ";
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				categoryVO = new NiCategoryVO();
				categoryVO.setCategoryId(rs.getLong("CATEGORY_ID"));
				categoryVO.setDescription(rs.getString("DESCRIPTION"));
				
				categories.add(categoryVO);
			}
			
		}catch (SQLException e) {  
	         e.printStackTrace();  
	      } catch (Exception e) {  
		     e.printStackTrace();  
		  }finally{
	    	try {
				ps.close();
				rs.close();
				DatabaseManager.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {  
		        e.printStackTrace();  
		    }
	      }
		
		return categories;
		
	}
	
	
	public List<NiCategoryVO> getChildCategories(long fatherCategoryId){
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		NiCategoryVO categoryVO = null;
		List<NiCategoryVO> categories = new ArrayList<NiCategoryVO>();
		
		try{
			conn = DatabaseManager.getConnection();
			
			String sql = " SELECT * FROM ni_category " +
				         " WHERE father_category_id = ? " +
				         " ORDER BY description ";
			
			ps = conn.prepareStatement(sql);
			ps.setLong(1, fatherCategoryId);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				categoryVO = new NiCategoryVO();
				categoryVO.setCategoryId(rs.getLong("CATEGORY_ID"));
				categoryVO.setDescription(rs.getString("DESCRIPTION"));
				
				categories.add(categoryVO);
			}
			
		}catch (SQLException e) {  
	         e.printStackTrace();  
	      } catch (Exception e) {  
		     e.printStackTrace();  
		  }finally{
	    	try {
				ps.close();
				rs.close();
				DatabaseManager.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {  
		        e.printStackTrace();  
		    }
	      }
		
		return categories;
		
	}
}
