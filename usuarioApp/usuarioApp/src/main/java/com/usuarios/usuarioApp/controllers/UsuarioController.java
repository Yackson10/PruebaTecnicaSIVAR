package com.usuarios.usuarioApp.controllers;

import com.usuarios.usuarioApp.dto.response.UsuarioResponseDTO;
import com.usuarios.usuarioApp.service.imp.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Operation(summary = "Valida la salud de la aplicación")
    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<UsuarioResponseDTO> consultar(@PathVariable Long id ){
        return new ResponseEntity<>(usuarioService.consultar(id), HttpStatus.OK);
    }

}
