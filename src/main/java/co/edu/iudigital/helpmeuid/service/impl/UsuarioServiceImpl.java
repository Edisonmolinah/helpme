package co.edu.iudigital.helpmeuid.service.impl;

import co.edu.iudigital.helpmeuid.dto.UsuarioDTO;
import co.edu.iudigital.helpmeuid.dto.UsuarioResponseDTO;
import co.edu.iudigital.helpmeuid.model.Role;
import co.edu.iudigital.helpmeuid.model.Usuario;
import co.edu.iudigital.helpmeuid.repository.IRoleRepository;
import co.edu.iudigital.helpmeuid.repository.IUsuarioRepository;
import co.edu.iudigital.helpmeuid.service.IUsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<UsuarioResponseDTO> findAll() {
		List<Usuario> usuarioList = usuarioRepository.findAll();
		return usuarioList.stream().map(usuario -> objectMapper.convertValue(usuario, UsuarioResponseDTO.class)).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioDTO findById(Long id) throws NotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(usuario.isEmpty()){
			throw new NotFoundException("Usuario no encontrado");
		}
		return objectMapper.convertValue(usuario.get(), UsuarioDTO.class);
	}

	@Override
	public UsuarioDTO save(UsuarioDTO usuarioDTO) throws NotFoundException {
		Optional<Role> role = roleRepository.findById(usuarioDTO.getRoleId());
		if (role.isEmpty()) {
			throw new NotFoundException("delito no encontrado");

		}
		Usuario usuario = objectMapper.convertValue(usuarioDTO, Usuario.class);
		usuario.setRoles(List.of(role.get()));
		usuario = usuarioRepository.save(usuario);
		usuarioDTO.setId(usuario.getId());
		return usuarioDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioResponseDTO findByUsername(String username) {
		Usuario usuario = usuarioRepository.findByUsername(username);
		return objectMapper.convertValue(usuario, UsuarioResponseDTO.class);
	}
}
