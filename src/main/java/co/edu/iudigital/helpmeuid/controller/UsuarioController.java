package co.edu.iudigital.helpmeuid.controller;


import co.edu.iudigital.helpmeuid.dto.UsuarioDTO;
import co.edu.iudigital.helpmeuid.dto.UsuarioResponseDTO;
import co.edu.iudigital.helpmeuid.service.IUsuarioService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO) throws NotFoundException {
        return ResponseEntity
                .ok()
                .body(usuarioService.save(usuarioDTO));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> findAllUsuarios(){
        return ResponseEntity
                .ok()
                .body(usuarioService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findUsuarioById(@PathVariable Long id) throws NotFoundException {
        return ResponseEntity
                .ok()
                .body(usuarioService.findById(id));
    }

    @GetMapping("/name/{userName}")
    public ResponseEntity<UsuarioResponseDTO> findByUserName(@PathVariable String userName){
        return ResponseEntity
                .ok()
                .body(usuarioService.findByUsername(userName));
    }

}
