/**
 * 
 */
package br.com.newitens.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.newitens.bo.NiUserBO;
import br.com.newitens.vo.NiUserVO;

/**
 * @author Felipe
 *
 */
@ManagedBean
@ViewScoped
public class UserBean {
	
	private NiUserVO user = new NiUserVO();
	private String message = new String();
	private List<NiUserVO> users = null;
	
	// Getters and Setters

	public NiUserVO getUser() {
		return user;
	}

	public void setUser(NiUserVO userVO) {
		this.user = userVO;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<NiUserVO> getUsers() {
		return users;
	}

	public void setUsers(List<NiUserVO> users) {
		this.users = users;
	}

	public void startSession(){
		user = new NiUserBO().startSession(user.getEmail(), user.getPassword());
	}
	
	public void insertUser(){
		message = new NiUserBO().newUser(user);
	}
	
	
	// Populate methods
	@PostConstruct
	public void populateUsers(){
		user = new NiUserVO();
		users = new NiUserBO().getAllUsers();
	}

}
