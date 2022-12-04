package co.edu.iudigital.helpmeuid.service.impl;

import co.edu.iudigital.helpmeuid.dto.CasoDTO;
import co.edu.iudigital.helpmeuid.dto.CasoResposeDTO;
import co.edu.iudigital.helpmeuid.model.Caso;
import co.edu.iudigital.helpmeuid.model.Delito;
import co.edu.iudigital.helpmeuid.model.Usuario;
import co.edu.iudigital.helpmeuid.repository.ICasoRepository;
import co.edu.iudigital.helpmeuid.repository.IDelitoRepository;
import co.edu.iudigital.helpmeuid.repository.IUsuarioRepository;
import co.edu.iudigital.helpmeuid.service.ICasoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CasoServiceImpl implements ICasoService {

	@Autowired
	private ICasoRepository casoRepository;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private IDelitoRepository delitoRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<CasoResposeDTO> findAll() {
		List<Caso> casos = casoRepository.findAll();
		return casos.stream().map(caso ->
				objectMapper.convertValue(caso, CasoResposeDTO.class)).collect(Collectors.toList());
	}

	@Override
	public CasoDTO save(CasoDTO casoDTO) throws NotFoundException {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(casoDTO.getUsuarioId());
		if(usuarioOpt.isEmpty()) {
			throw new NotFoundException("no encontrado el id");
		}

		Optional<Delito> delitoOpt = delitoRepository.findById(casoDTO.getDelitoId());
		if(delitoOpt.isEmpty()) {
			throw new NotFoundException("delito no encontrado");
		}

		Caso caso = objectMapper.convertValue(casoDTO, Caso.class);
		caso.setDelito(delitoOpt.get());
		caso.setUsuario(usuarioOpt.get());
		casoRepository.save(caso);
		return casoDTO;
	}

	@Override
	public String changeVisibleStatus(Boolean visible, Long id) throws NotFoundException {
		int result = casoRepository.setVisible(visible, id);
		if (result == 0)
			throw new NotFoundException("el Caso no fue encontrado");
		return "El estado del caso fue actualizado";
	}

	@Override
	public CasoResposeDTO findById(Long id) throws NotFoundException {
		Optional<Caso> casoOpt = casoRepository.findById(id);
		if(casoOpt.isEmpty()) {
			throw new NotFoundException("Caso no encontrado");
		}
		return objectMapper.convertValue(casoOpt.get(), CasoResposeDTO.class);
	}

}
