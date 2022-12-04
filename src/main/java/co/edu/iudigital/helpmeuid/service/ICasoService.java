package co.edu.iudigital.helpmeuid.service;

import co.edu.iudigital.helpmeuid.dto.CasoDTO;
import co.edu.iudigital.helpmeuid.dto.CasoResposeDTO;
import javassist.NotFoundException;

import java.util.List;

public interface ICasoService {

	List<CasoResposeDTO> findAll() ;

	CasoDTO save(CasoDTO caso) throws NotFoundException;

	String changeVisibleStatus(Boolean visible, Long id) throws NotFoundException;

	CasoResposeDTO findById(Long id) throws NotFoundException;
}
