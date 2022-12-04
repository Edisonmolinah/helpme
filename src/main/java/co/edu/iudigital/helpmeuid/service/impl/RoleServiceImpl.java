package co.edu.iudigital.helpmeuid.service.impl;

import co.edu.iudigital.helpmeuid.model.Role;
import co.edu.iudigital.helpmeuid.repository.IRoleRepository;
import co.edu.iudigital.helpmeuid.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleRepository roleRepository;
	
	@Override
	public List<Role> getAll() {
		return roleRepository.findAll();
	}

}
