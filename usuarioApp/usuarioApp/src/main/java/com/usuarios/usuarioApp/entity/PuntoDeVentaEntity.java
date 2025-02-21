package com.usuarios.usuarioApp.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "punto_de_venta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PuntoDeVentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @ManyToMany(mappedBy = "puntosDeVenta")
    private List<EmpresaEntity> empresas;

}
