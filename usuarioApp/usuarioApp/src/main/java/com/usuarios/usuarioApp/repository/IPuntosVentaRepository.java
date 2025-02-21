package com.usuarios.usuarioApp.repository;

import com.usuarios.usuarioApp.entity.PuntoDeVentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPuntosVentaRepository extends JpaRepository<PuntoDeVentaEntity, Long> {

}
