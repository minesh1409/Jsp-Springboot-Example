package com.specta.card.services;

import java.text.ParseException;
import java.util.List;

import com.specta.card.model.Role;

public interface IRoleService {
	
	boolean createRole(Role u) throws ParseException;

	List<Role> getAllRoles();

	void updateRole(Role u);
	
	public void deleteRole(int RoleId);
	
	Role getRoleById(int roleId);

}
