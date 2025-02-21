package com.usuarios.usuarioApp.service.imp;

import com.usuarios.usuarioApp.dto.response.UsuarioResponseDTO;
import com.usuarios.usuarioApp.entity.UsuarioEntity;
import com.usuarios.usuarioApp.repository.IUsuarioRepository;
import com.usuarios.usuarioApp.service.IUsuarioService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @PostConstruct
    public void init() {
        UsuarioEntity usuarioEntity = UsuarioEntity.builder()
                .numeroDocumento("10121314")
                .nombre("Juan")
                .apellido("Moreno")
                .telefono("3117897898")
                .build();

        iUsuarioRepository.save(usuarioEntity);
    }

    @Override
    public UsuarioResponseDTO consultar(Long id) {

        Optional<UsuarioEntity> usuarioOptional = iUsuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){

            return UsuarioResponseDTO.builder()
                    .numeroDocumento(usuarioOptional.get().getNumeroDocumento())
                    .nombre(usuarioOptional.get().getNombre())
                    .apellido(usuarioOptional.get().getApellido())
                    .telefono(usuarioOptional.get().getTelefono())
                    .build();

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe");
        }
    }
}
