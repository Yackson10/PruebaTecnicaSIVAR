package com.usuarios.usuarioApp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpresaResponseDTO {

    private String nombre;
    private String nit;
    private List<PuntosVentaResponseDTO> puntosVenta;
}
