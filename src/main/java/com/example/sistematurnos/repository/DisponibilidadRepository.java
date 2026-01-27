package com.example.sistematurnos.repository;

import com.example.sistematurnos.model.entity.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface DisponibilidadRepository extends JpaRepository<Disponibilidad,Long> {
    @Query("""
    SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END
    FROM Disponibilidad d
    WHERE d.profesional.id = :profesionalId
      AND d.diaSemana = :dia
      AND d.horaInicio <= :horaInicio
      AND d.horaFin >= :horaFin
  """)
    boolean estaDentroDeDisponibilidad(
            @Param("profesionalId") Long profesionalId,
            @Param("dia") DayOfWeek dia,
            @Param("horaInicio") LocalTime horaInicio,
            @Param("horaFin") LocalTime horaFin
    );
}
