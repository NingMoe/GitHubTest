package cn.edu.sdust.login;

import cn.edu.sdust.register.Enterprise;

public interface LoginInterface {
	
	boolean Login(Login login);
	boolean Update(Login login,String newPass);
	boolean ifResume(String studentNum);
	Enterprise getAllEncontactByUserName(String userName);
	boolean UpdateRegister(Enterprise enterprise,String userName);
}
