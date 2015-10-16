package com.ssh.service.impl;


import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;

import com.ssh.dao.impl.RegisterDaoImpl;
import com.ssh.entity.User;
import com.ssh.forms.UserForm;
import com.ssh.service.RegisterService;


public class RegisterServiceImpl implements RegisterService{

	private RegisterDaoImpl registerDao;
	public RegisterDaoImpl getRegisterDao() {
		return registerDao;
	}

	public void setRegisterDao(RegisterDaoImpl registerDao) {
		this.registerDao = registerDao;
	}
	
	@Override
	public void registerUser(UserForm userForm) throws HibernateException {
		//创建user对象
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		registerDao.saveObject(user);
	}
}
