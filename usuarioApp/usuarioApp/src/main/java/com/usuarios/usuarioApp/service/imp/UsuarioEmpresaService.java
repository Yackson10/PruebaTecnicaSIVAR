package com.usuarios.usuarioApp.service.imp;

import com.usuarios.usuarioApp.dto.response.EmpresaResponseDTO;
import com.usuarios.usuarioApp.dto.response.PuntosVentaResponseDTO;
import com.usuarios.usuarioApp.dto.response.UsuarioEmpresaResponseDTO;
import com.usuarios.usuarioApp.entity.EmpresaEntity;
import com.usuarios.usuarioApp.entity.PuntoDeVentaEntity;
import com.usuarios.usuarioApp.entity.UsuarioEmpresaEntity;
import com.usuarios.usuarioApp.entity.UsuarioEntity;
import com.usuarios.usuarioApp.repository.IEmpresaRepository;
import com.usuarios.usuarioApp.repository.IPuntosVentaRepository;
import com.usuarios.usuarioApp.repository.IUsuarioEmpresaRepository;
import com.usuarios.usuarioApp.repository.IUsuarioRepository;
import com.usuarios.usuarioApp.service.IUsuarioEmpresaService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioEmpresaService  implements IUsuarioEmpresaService {

    @Autowired
    private IUsuarioEmpresaRepository iUsuarioEmpresaRepository;
    @Autowired
    private IUsuarioRepository iUsuarioRepository;
    @Autowired
    private IEmpresaRepository iEmpresaRepository;
    @Autowired
    private IPuntosVentaRepository iPuntosVentaRepository;

    @PostConstruct
    public void init() {

        UsuarioEntity usuarioEntity = UsuarioEntity.builder()
                .numeroDocumento("111122")
                .nombre("Salvador")
                .apellido("Jamamillo")
                .telefono("4567897873")
                .build();

        iUsuarioRepository.save(usuarioEntity);

        EmpresaEntity empresaEntity = EmpresaEntity.builder()
                .nombre("SIVAR")
                .nit("12345667")
                .build();

        iEmpresaRepository.save(empresaEntity);

        PuntoDeVentaEntity puntoDeVentaEntity = PuntoDeVentaEntity.builder()
                .nombre("Medellin")
                .direccion("82 # 32")
                .empresas(List.of(empresaEntity))
                .build();
        iPuntosVentaRepository.save(puntoDeVentaEntity);

        UsuarioEmpresaEntity usuarioEmpresa = UsuarioEmpresaEntity.builder()
                .usuario(usuarioEntity)
                .empresa(empresaEntity)
                .rol("Admin")
                .build();

        UsuarioEmpresaEntity usuarioEmpresa2 = UsuarioEmpresaEntity.builder()
                .usuario(usuarioEntity)
                .empresa(empresaEntity)
                .rol("Vendedor")
                .build();

        iUsuarioEmpresaRepository.save(usuarioEmpresa);
        iUsuarioEmpresaRepository.save(usuarioEmpresa2);
    }

    @Override
    public List<UsuarioEmpresaResponseDTO> consultarTodos() {
        List<UsuarioEmpresaEntity> listadoDatos = iUsuarioEmpresaRepository.findAll();

        List<UsuarioEmpresaResponseDTO> usuarioEmpresa = new ArrayList<>();

        for(UsuarioEmpresaEntity item : listadoDatos){
            List<PuntosVentaResponseDTO> puntosVentas = new ArrayList<>();
             for(PuntoDeVentaEntity itemVentas : item.getEmpresa().getPuntosDeVenta()){
                 PuntosVentaResponseDTO puntosVentaResponseDTO = PuntosVentaResponseDTO.builder()
                         .nombre(itemVentas.getNombre())
                         .direccion(itemVentas.getDireccion())
                         .build();

                 puntosVentas.add(puntosVentaResponseDTO);
             }

            EmpresaResponseDTO empresaResponseDTO = EmpresaResponseDTO.builder()
                    .nombre(item.getEmpresa().getNombre())
                    .nit(item.getEmpresa().getNit())
                    .puntosVenta(puntosVentas)
                    .build();

            UsuarioEmpresaResponseDTO usuarioEmpresaResponseDTO = UsuarioEmpresaResponseDTO.builder()
                    .id(item.getId())
                    .usuario(item.getUsuario().getNombre())
                    .empresa(empresaResponseDTO)
                    .rol(item.getRol())
                    .build();

            usuarioEmpresa.add(usuarioEmpresaResponseDTO);
        }
        return usuarioEmpresa;
    }
}
