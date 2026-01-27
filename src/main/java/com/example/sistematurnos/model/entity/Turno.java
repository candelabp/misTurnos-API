package com.example.sistematurnos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.example.sistematurnos.model.enums.EstadoTurno;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    @Enumerated(EnumType.STRING)
    private EstadoTurno estado;

    @ManyToOne
    @JoinColumn(name="cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="profesional_id", nullable = false)
    private Profesional profesional;

    @ManyToOne
    @JoinColumn(name="servicio_id", nullable = false)
    private Servicio servicio;

    @Column(length = 500)
    private String observaciones;

    @Column(length = 300)
    private String motivoCancelacion;

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
        updateAt = createdAt;
    }
    @PreUpdate
    public void preUpdate(){
        updateAt = LocalDateTime.now();
    }

}
