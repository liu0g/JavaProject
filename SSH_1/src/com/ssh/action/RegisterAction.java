package com.ssh.action;

import com.ssh.forms.UserForm;
import com.ssh.service.impl.RegisterServiceImpl;

public class RegisterAction {
	
	private UserForm userForm;
	private RegisterServiceImpl registerService;
	
	public UserForm getUserForm() {
		return userForm;
	}

	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}

	public RegisterServiceImpl getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterServiceImpl registerService) {
		this.registerService = registerService;
	}

	public String execute(){
		try {
			registerService.registerUser(userForm);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
