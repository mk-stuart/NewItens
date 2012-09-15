/**
 * 
 */
package br.com.newitens.bo;

import java.util.List;

import br.com.newitens.dao.NiUserDAO;
import br.com.newitens.util.Constant;
import br.com.newitens.util.Validator;
import br.com.newitens.vo.NiUserVO;

/**
 * @author Felipe
 *
 */
public class NiUserBO {

	public String newUser(NiUserVO userVO){
		
		String retorno = new String();
		boolean birthDate = Validator.isValidDate(userVO.getBirthDate());
		boolean cpf = Validator.isValidCpf(userVO.getCpf());
		
		if(!cpf){
			retorno = retorno + Constant.INVALID_CPF;
		}
		
		if(!birthDate){
			retorno = retorno +  Constant.INVALID_BIRTH_DATE;
		}
		
		if(cpf && birthDate){
			
			if(new NiUserDAO().insertUser(userVO) > 0){
				retorno = Constant.USER_REGISTRATION_SUCCESSFULLY;
			}else{
				retorno = Constant.GENERIC_ERROR;
			}
		}
		
		return retorno;
	}
	
	public NiUserVO startSession(String email, String password){
		NiUserVO user = null;
		if(email != null && password != null){
			user = new NiUserDAO().findUserForSession(email, password);
		}
		
		return user;
	}
	
	public List<NiUserVO> getAllUsers(){
		return new NiUserDAO().getAllUsers();
	}
	
}
