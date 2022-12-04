package co.edu.iudigital.helpmeuid.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "casos")
@Data
public class Caso implements Serializable {

    private static final long serialVersionUID = 7509375994430053778L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //fecha_hora DATETIME NULL DEFAULT now(),
    @Column(name = "fecha_hora")
    private String fechaHora;

    //latitud FLOAT NULL,
    private Float latitud;

    //longitud FLOAT NULL,
    private Float longitud;

    //altitud FLOAT NULL,
    private Float altitud;

    //visible TINYINT NULL DEFAULT 1,
    private Boolean visible;

    //descripcion VARCHAR(200) NULL,
    @Column(name = "descripcion", length = 200)
    private String descripcion;

    //url_map TEXT NULL,
    @Column(name = "url_map")
    private String urlMap;

    // rmi_url TEXT NULL,
    @Column(name = "rmi_url")
    private String rmiUrl;

    // usuarios_id INT NOT NULL,
    //FOREIGN KEY (usuarios_id) REFERENCES usuarios(id),
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarios_id")
    private Usuario usuario;

    //delitos_id INT NOT NULL,
    //FOREIGN KEY (delitos_id) REFERENCES delitos(id)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delitos_id")
    private Delito delito;

    @PrePersist
    public void init() {
        if(Objects.isNull(fechaHora)) {//fechaHora==null
            fechaHora = LocalDateTime.now().toString();
        }
        if(Objects.isNull(visible)) {
            visible = true;
        }
    }
}
