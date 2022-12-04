package co.edu.iudigital.helpmeuid.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Data
public class UsuarioResponseDTO {
    Long id;
    String username;
    String nombre;
    String apellido;
    String password;
    Boolean enabled;
    Boolean redSocial;
    String image;
    List<RoleDTO> roles;
}
