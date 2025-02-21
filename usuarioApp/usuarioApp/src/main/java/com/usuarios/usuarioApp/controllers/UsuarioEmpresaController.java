package com.usuarios.usuarioApp.controllers;

import com.usuarios.usuarioApp.dto.response.UsuarioEmpresaResponseDTO;
import com.usuarios.usuarioApp.service.IUsuarioEmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuariosEmpresa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UsuarioEmpresaController {

    @Autowired
    private IUsuarioEmpresaService iUsuarioEmpresaService;

    @GetMapping("/consultarUsuariosConEmpresas")
    public ResponseEntity<List<UsuarioEmpresaResponseDTO>> consultarTodos(){
        return new ResponseEntity<>(iUsuarioEmpresaService.consultarTodos(), HttpStatus.OK);
    }
}
