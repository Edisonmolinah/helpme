package co.edu.iudigital.helpmeuid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class Usuario implements Serializable {

    private static final long serialVersionUID = 9132267639491250466L;

    //id INT NOT NULL AUTO_INCREMENT
    @Id // PRIMARY KEY(id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //username VARCHAR(120) NOT NULL,
    @Column(name = "username",
            length = 120, nullable = false, unique = true)
    private String username;

    //nombre VARCHAR(120) NOT NULL,
    @Column(name = "nombre", length = 120, nullable = false)
    private String nombre;

    //apellido VARCHAR(120) NULL,
    @Column(name = "apellido", length = 120)
    private String apellido;

    //password VARCHAR(250) NULL,
    @Column(name = "password", length = 250)
    private String password;

    //enabled TINYINT NULL DEFAULT 1
    //@Column(columnDefinition = "NULL DEFAULT 1")
    private Boolean enabled;

    //red_social TINYINT NULL DEFAULT 0,
    @Column(name = "red_social")
    private Boolean redSocial;

    //image TEXT NULL DEFAULT 'https://happytravel.viajes/wp-content/uploads/2020/04/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png',
    private String image;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.REMOVE,
                    CascadeType.REFRESH
            })
    @JoinTable(name = "roles_usuarios",
            joinColumns = {
                    @JoinColumn(name = "usuarios_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "roles_id")
            })
    @JsonIgnore
    private List<Role> roles;

    @PrePersist
    public void persist() {
        if(enabled == null) {
            enabled = true;
        }
        if(redSocial == null) {
            redSocial = false;
        }
        if(image == null || "".equals(image)) {
            image = "https://happytravel.viajes/wp-content/uploads/2020/04/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png";
        }
    }


}
