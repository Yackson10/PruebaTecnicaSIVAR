package com.usuarios.usuarioApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponseDTO {

    private String numeroDocumento;
    private String nombre;
    private String apellido;
    private String telefono;

}
