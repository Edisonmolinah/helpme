package co.edu.iudigital.helpmeuid.service;

import co.edu.iudigital.helpmeuid.dto.DelitoDTO;
import co.edu.iudigital.helpmeuid.dto.DelitoResposeDTO;
import javassist.NotFoundException;

import java.util.List;

public interface IDelitoService {

	List<DelitoResposeDTO> findAll();
	
	DelitoResposeDTO findById(Long id) throws NotFoundException;
	
	Long save(DelitoDTO delitoDTO) throws NotFoundException;
	
	void delete(Long id);
}
