package com.example.agendaContactos.repository;

import com.example.agendaContactos.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio que proporciona operaciones CRUD gracias a JpaRepository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}
