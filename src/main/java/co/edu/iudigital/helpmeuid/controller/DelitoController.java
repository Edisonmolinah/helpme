package co.edu.iudigital.helpmeuid.controller;

import co.edu.iudigital.helpmeuid.dto.DelitoDTO;
import co.edu.iudigital.helpmeuid.dto.DelitoResposeDTO;
import co.edu.iudigital.helpmeuid.service.IDelitoService;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delitos")
public class DelitoController {

    @Autowired
    private IDelitoService delitoService;



    @PostMapping
    public ResponseEntity<Long> create(@RequestBody DelitoDTO delitoDTO) throws NotFoundException {
        return ResponseEntity
                .ok()
                .body(delitoService.save(delitoDTO));
    }

    @GetMapping
    public ResponseEntity<List<DelitoResposeDTO>> findAll(){
        return ResponseEntity
                .ok()
                .body(delitoService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<DelitoResposeDTO> findById(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity
                .ok()
                .body(delitoService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        delitoService.delete(id);
        return ResponseEntity
                .ok()
                .body("el delito Se elimino con exito");
    }
}
