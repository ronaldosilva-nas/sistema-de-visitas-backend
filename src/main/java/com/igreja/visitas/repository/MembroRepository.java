package com.igreja.visitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igreja.visitas.model.Membro;

public interface MembroRepository extends JpaRepository<Membro, Long> {

}
