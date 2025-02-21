package com.usuarios.usuarioApp.repository;

import com.usuarios.usuarioApp.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpresaRepository extends JpaRepository<EmpresaEntity, Long> {


}
