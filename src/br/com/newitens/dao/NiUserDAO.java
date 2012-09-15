/**
 * 
 */
package br.com.newitens.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.newitens.vo.NiUserVO;

/**
 * @author Felipe
 *
 */
public class NiUserDAO {
	
	public NiUserDAO(){
		
	}
	
	public long insertUser(NiUserVO userVO){
		
		 CallableStatement cs = null;
		 Connection conn = null;
		 long id = 0;
		 DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");  
		
		 try {  
	          
			 conn = DatabaseManager.getConnection();
			 
	         String strCmd = "{call new_itens_owner.ni_sp_insert_user(?,?,?,?,?,?,?,?,?)}";
             cs = conn.prepareCall(strCmd);
            
             //Setando paramentros para a SP
             cs.setString(1, userVO.getFirstName()); //FIRST_NAME IN
             cs.setString(2, userVO.getLastName()); //LAST_NAME IN
             cs.setString(3, userVO.getCpf()); //CPF IN
             cs.setString(4, userVO.getEmail().toLowerCase()); //EMAIL IN
             cs.setString(5, userVO.getPassword()); //PASSWORD IN
             cs.setString(6, userVO.getPhoneNumber()); //PHONE_NUMBER IN
             cs.setString(7, userVO.getCelPhoneNumber()); //CELPHONE_NUMBER IN
             cs.setDate(8, new java.sql.Date(fmt.parse(userVO.getBirthDate()).getTime())); //BIRTH_DATE IN
             cs.registerOutParameter(9, java.sql.Types.NUMERIC); //USER_ID OUT
             
             //Executando a SP
             cs.execute();
             
             //Obtendo o retorno da SP
             id = cs.getInt(9);
	           
	      } catch (SQLException e) {  
	         e.printStackTrace();  
	      } catch (Exception e) {  
		     e.printStackTrace();  
		  }finally{
	    	try {
				cs.close();
				DatabaseManager.closeConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {  
		        e.printStackTrace();  
		    }
	      }
		
		return id;
	}
	
	public NiUserVO findUserForSession(String email, String password){
		
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		NiUserVO userVO = null;
		
		try{
			conn = DatabaseManager.getConnection();
			
			String sql = " SELECT * FROM new_itens_owner.ni_user " +
					     " WHERE lower(email) = ? " +
					     " AND password = ? ";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, email.toLowerCase());
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				userVO = new NiUserVO();
				userVO.setUserId(rs.getLong("USER_ID"));
				userVO.setUserLevelId(rs.getLong("USER_LEVEL_ID"));
				userVO.setFirstName(rs.getString("FIRST_NAME"));
				userVO.setLastName(rs.getString("LAST_NAME"));
				userVO.setEmail(rs.getString("EMAIL").toLowerCase());
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
		
		
		return userVO;
	}
	
	public List<NiUserVO> getAllUsers(){
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		NiUserVO userVO = null;
		List<NiUserVO> users = new ArrayList<NiUserVO>();
		
		try{
			conn = DatabaseManager.getConnection();
			
			String sql = " SELECT * FROM new_itens_owner.ni_user ";
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				userVO = new NiUserVO();
				userVO.setUserId(rs.getLong("USER_ID"));
				userVO.setUserLevelId(rs.getLong("USER_LEVEL_ID"));
				userVO.setFirstName(rs.getString("FIRST_NAME"));
				userVO.setLastName(rs.getString("LAST_NAME"));
				userVO.setEmail(rs.getString("EMAIL").toLowerCase());
				
				users.add(userVO);
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
		
		return users;
		
	}

}
