package co.edu.iudigital.helpmeuid.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class RoleDTO {
    String nombre;
    String descripcion;

}
