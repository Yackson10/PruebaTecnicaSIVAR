package com.usuarios.usuarioApp.service;

import com.usuarios.usuarioApp.dto.response.UsuarioEmpresaResponseDTO;
import com.usuarios.usuarioApp.entity.UsuarioEmpresaEntity;

import java.util.List;

public interface IUsuarioEmpresaService {

    List<UsuarioEmpresaResponseDTO> consultarTodos();

}
