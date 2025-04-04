package com.example.agendaContactos.repository;

import com.example.agendaContactos.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

//1.3 Crea un repositorio para gestionar las operaciones CRUD de los contactos
// Repositorio que proporciona operaciones CRUD gracias a JpaRepository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}
