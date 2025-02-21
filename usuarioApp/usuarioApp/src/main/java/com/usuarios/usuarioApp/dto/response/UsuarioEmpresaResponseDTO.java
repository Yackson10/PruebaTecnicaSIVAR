package com.usuarios.usuarioApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioEmpresaResponseDTO {

    private Long id;
    private String usuario;
    private EmpresaResponseDTO empresa;
    private String rol;
}
