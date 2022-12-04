package co.edu.iudigital.helpmeuid.service.impl;

import co.edu.iudigital.helpmeuid.dto.DelitoDTO;
import co.edu.iudigital.helpmeuid.dto.DelitoResposeDTO;
import co.edu.iudigital.helpmeuid.model.Delito;
import co.edu.iudigital.helpmeuid.model.Usuario;
import co.edu.iudigital.helpmeuid.repository.IDelitoRepository;
import co.edu.iudigital.helpmeuid.repository.IUsuarioRepository;
import co.edu.iudigital.helpmeuid.service.IDelitoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DelitoServiceImpl implements IDelitoService {

	@Autowired
	private IDelitoRepository delitoRepository;

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Transactional(readOnly = true)
	@Override
	public List<DelitoResposeDTO> findAll() {
		List<Delito> delitos = delitoRepository.findAll();
		return delitos.stream().map((delito ->
				objectMapper.convertValue(delito, DelitoResposeDTO.class)))
				.collect(Collectors.toList());
	}

	@Override
	public DelitoResposeDTO findById(Long id) throws NotFoundException {
		Optional<Delito> delito = delitoRepository.findById(id);
		if(delito.isEmpty()){
			throw new NotFoundException("delito no encontrado");
		}

		return objectMapper.convertValue(delito.get(), DelitoResposeDTO.class);
	}

	@Override
	public Long save(DelitoDTO delitoDTO) throws NotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findById(delitoDTO.getUserId());
		if (usuario.isEmpty()){
			throw new NotFoundException("usuario no encontrado");
		}
		Delito delito = objectMapper.convertValue(delitoDTO, Delito.class);
		delito.setUsuario(usuario.get());
		delito = delitoRepository.save(delito);
		return delito.getId();
	}

	@Override
	public void delete(Long id) {
		delitoRepository.deleteById(id);
	}
}
