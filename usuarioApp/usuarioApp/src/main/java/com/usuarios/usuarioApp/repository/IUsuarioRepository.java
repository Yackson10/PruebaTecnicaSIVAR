package com.usuarios.usuarioApp.repository;

import com.usuarios.usuarioApp.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {


}
