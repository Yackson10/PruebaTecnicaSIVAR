package com.usuarios.usuarioApp.repository;

import com.usuarios.usuarioApp.entity.UsuarioEmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUsuarioEmpresaRepository extends JpaRepository<UsuarioEmpresaEntity, Long> {

}
