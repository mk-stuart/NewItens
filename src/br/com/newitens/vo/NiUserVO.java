/**
 * 
 */
package br.com.newitens.vo;


/**
 * @author Felipe
 *
 */
public class NiUserVO {
	
	private long userId;
	private long userLevelId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	private String celPhoneNumber;
	private String birthDate;
	private String registerDate;
	private String cpf;

	public NiUserVO(){
		userId = 0;
		firstName = new String();
		lastName = new String();
		email = new String();
		password = new String();
		phoneNumber = new String();
		celPhoneNumber = new String();
		birthDate = null;
		registerDate = null;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName(){
		return this.firstName + " " + this.lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCelPhoneNumber() {
		return celPhoneNumber;
	}

	public void setCelPhoneNumber(String celPhoneNumber) {
		this.celPhoneNumber = celPhoneNumber;
	}


	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String dayMonthYear) {
		this.birthDate = dayMonthYear;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public long getUserLevelId() {
		return userLevelId;
	}

	public void setUserLevelId(long userLevelId) {
		this.userLevelId = userLevelId;
	}

	@Override
	public String toString() {
		return "NiUserVO [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", phoneNumber=" + phoneNumber
				+ ", celPhoneNumber=" + celPhoneNumber + ", birthDate="
				+ birthDate + ", registerDate=" + registerDate + "]";
	}
	
    
	
}
