package co.edu.iudigital.helpmeuid.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class CasoResposeDTO {
    Long id;
    String fechaHora;
    Float latitud;
    Float longitud;
    Float altitud;
    Boolean visible;
    String descripcion;
    String urlMap;
    String rmiUrl;
    UsuarioResponseDTO usuario;
    DelitoResposeDTO delito;

}
