package com.usuarios.usuarioApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario_empresa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private EmpresaEntity empresa;

    @Column(name = "rol", nullable = false)
    private String rol;
}
