package com.specta.card.dao;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.specta.card.model.Role;


@Transactional
@Repository
public class RoleDao implements IRoleDao{
	
	@Autowired
	private EntityManager em;

	@Override
	public void createRole(Role u) throws ParseException {
		em.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRoles() {
		return em.createQuery("FROM Role").getResultList();
	}

	@Override
	public void updateRole(Role u) {
		Role role=getRoleById(u.getId());
		role.setRole(u.getRole());
		role.setType(u.getType());
		em.flush();
	}

	@Override
	public void deleteRole(int RoleId) {
		Role role=getRoleById(RoleId);
		em.remove(role);
	}

	@Override
	public Role getRoleById(int roleId) {
		return em.find(Role.class, roleId);
	}

	

}
