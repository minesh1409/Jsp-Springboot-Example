package com.specta.card.controller;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.specta.card.model.Role;
import com.specta.card.services.IRoleService;

@RestController
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);
	@GetMapping("/roles")
	public ResponseEntity<List<Role>> getAllRoles(HttpServletRequest request) {
		
		System.out.println("Request ID::"+UUID.randomUUID().toString());
		System.out.println("Requested URL::"+request.getRequestURL());
		List<Role> list = roleService.getAllRoles();
		LOGGER.info("Get All Customers Data", "LAKA");
		return new ResponseEntity<List<Role>>(list, HttpStatus.OK);
	}


	@PostMapping("/role")
	public ResponseEntity<?> addRole(@RequestBody Role r, UriComponentsBuilder builder) throws ParseException {
		boolean flag = roleService.createRole(r);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post role");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(r.getId()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	
	@GetMapping("role/{id}")
	public ResponseEntity<Role> getUserById(@PathVariable("id") int id) {

		Role r=roleService.getRoleById(id);
		LOGGER.info("Get Customer By Id");
		return new ResponseEntity<Role>(r, HttpStatus.OK);
	}

	
	@PutMapping("updateRole")
	public ResponseEntity<Role> updateRole(@RequestBody Role r) {
		System.out.println("In Controller");
		roleService.updateRole(r);
		System.out.println("Password Updated.......!!!");
		LOGGER.info("updateCustomer");
		return new ResponseEntity<Role>(r, HttpStatus.OK);
	}
	
	@DeleteMapping("deleteRole/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable("id") int id)
	{
		roleService.deleteRole(id);
		return new ResponseEntity<String>("Role Deleted..!!",HttpStatus.OK);
	}
	


}
