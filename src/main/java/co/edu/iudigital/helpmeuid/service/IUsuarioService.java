package co.edu.iudigital.helpmeuid.service;

import co.edu.iudigital.helpmeuid.dto.UsuarioDTO;
import co.edu.iudigital.helpmeuid.dto.UsuarioResponseDTO;
import javassist.NotFoundException;

import java.util.List;

public interface IUsuarioService {

	List<UsuarioResponseDTO> findAll();
	
	UsuarioDTO findById(Long id) throws NotFoundException;
	
	UsuarioDTO save(UsuarioDTO usuarioDTO) throws NotFoundException;
	
	UsuarioResponseDTO findByUsername(String username);
}
