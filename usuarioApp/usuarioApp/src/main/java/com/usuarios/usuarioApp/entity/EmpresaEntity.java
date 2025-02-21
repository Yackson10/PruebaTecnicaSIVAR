package com.usuarios.usuarioApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "empresa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_empresa", nullable = false)
    private String nombre;

    @Column(name = "nit", nullable = false, unique = true)
    private String nit;

    @ManyToMany(mappedBy = "empresas")
    private List<UsuarioEntity> usuarios;

    @ManyToMany
    @JoinTable(
            name = "empresa_punto_de_venta",
            joinColumns = @JoinColumn(name = "id_empresa"),
            inverseJoinColumns = @JoinColumn(name = "id_punto_de_venta")
    )
    private List<PuntoDeVentaEntity> puntosDeVenta;

}
