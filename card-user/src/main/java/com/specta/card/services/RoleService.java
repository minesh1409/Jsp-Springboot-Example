package com.specta.card.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specta.card.dao.IRoleDao;
import com.specta.card.model.Role;

@Service
public class RoleService implements IRoleService{
	
	@Autowired
	private IRoleDao roleDao;

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleDao.getAllRoles();
	}

	@Override
	public void updateRole(Role u) {
		// TODO Auto-generated method stub
		roleDao.updateRole(u);
	}

	@Override
	public void deleteRole(int RoleId) {
		// TODO Auto-generated method stub
		roleDao.deleteRole(RoleId);
	}

	@Override
	public Role getRoleById(int roleId) {
		// TODO Auto-generated method stub
		return roleDao.getRoleById(roleId);
	}

	@Override
	public boolean createRole(Role u) throws ParseException {
		// TODO Auto-generated method stub
		roleDao.createRole(u);
		return true;
	}

}
