package co.edu.iudigital.helpmeuid.model;

import static lombok.AccessLevel.PRIVATE;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role implements Serializable {
    private static final long serialVersionUID = -2928234787085757170L;


    @Id // PRIMARY KEY(id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //nombre VARCHAR(45) NOT NULL
    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    //descripcion TEXT NULL
    private String descripcion;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;
}
