package co.edu.iudigital.helpmeuid.controller;

import co.edu.iudigital.helpmeuid.dto.CasoDTO;
import co.edu.iudigital.helpmeuid.dto.CasoResposeDTO;
import co.edu.iudigital.helpmeuid.service.ICasoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caso")
public class CasoController {

    @Autowired
    private ICasoService casoService;

    @PostMapping
    public ResponseEntity<CasoDTO> createCaso(@RequestBody @Validated CasoDTO casoDTO) throws NotFoundException {
        return ResponseEntity
                .ok()
                .body(casoService.save(casoDTO));
    }

    @GetMapping
    public ResponseEntity<List<CasoResposeDTO>> findAllCaso(){
        return ResponseEntity
                .ok()
                .body(casoService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<CasoResposeDTO> findCasoById(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity
                .ok()
                .body(casoService.findById(id));
    }

    @PutMapping()
    public ResponseEntity<String> changeVisibleStatus(
            @RequestParam Long id, @RequestParam Boolean visible) throws NotFoundException {

        return ResponseEntity
                .ok()
                .body(casoService.changeVisibleStatus(visible, id));
    }
}
