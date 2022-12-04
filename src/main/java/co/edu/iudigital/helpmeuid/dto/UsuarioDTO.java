package co.edu.iudigital.helpmeuid.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Data
public class UsuarioDTO {
    Long id;
    String username;
    String nombre;
    String apellido;
    String password;
    Boolean enabled;
    Boolean redSocial;
    String image;
    Long roleId;
}
