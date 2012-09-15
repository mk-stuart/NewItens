/**
 * 
 */
package br.com.newitens.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Felipe
 *
 */
public class DatabaseManager {

	
	public static Connection getConnection(){
		 /** 
	     * String de conexão: 
	     *    Oracle - jdbc:oracle:thin:@<IP>:<PORTA>:<BANCO> 
	     *    Mysql  - jdbc:mysql://<IP>:<PORTA>/<BANCO> 
	     *  
	     * Class Names: 
	     *    Oracle - oracle.jdbc.driver.OracleDriver 
	     *    Mysql  - com.mysql.jdbc.Driver 
	     */  
		Connection conn = null;
	    try {
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:new_itens_owner/new_itens_owner@localhost:1521:xe");
		} catch(ClassNotFoundException c){
			c.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
	    return conn;
	}
	
	public static void closeConnection(Connection conn){
		try{
			conn.close();
			conn = null;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
