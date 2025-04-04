package com.example.agendaContactos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

//1.2 Define una entidad JPA que represente un contacto en la base de datos
//1.9 Añade validación de datos en el formulario de creación de contactos
@Entity
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre es obligatorio")
    private String nombre;

    @NotEmpty(message = "El teléfono es obligatorio")
    private String telefono;

    @NotEmpty(message = "El correo es obligatorio")
    @Email(message = "Formato de correo inválido")
    private String email;

    // Getter y Setter para ID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters y setters para los demás atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
