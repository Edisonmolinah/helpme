package co.edu.iudigital.helpmeuid.dto;

import co.edu.iudigital.helpmeuid.model.Delito;
import co.edu.iudigital.helpmeuid.model.Usuario;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class CasoDTO {
    String fechaHora;
    Float latitud;
    Float longitud;
    Float altitud;
    Boolean visible;
    String descripcion;
    String urlMap;
    String rmiUrl;
    Long delitoId;
    Long usuarioId;
}
