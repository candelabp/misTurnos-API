package repository;

import model.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TurnoRepository  extends JpaRepository<Turno, Long> {
    @Query("""
    SELECT CASE WHEN COUNT(t) > 0 THEN true ELSE false END
    FROM Turno t
    WHERE t.profesional.id = :profesionalId
      AND t.estado <> 'CANCELADO'
      AND :inicio < t.fechaFin
      AND :fin > t.fechaInicio
  """)
    boolean existeSolapamiento(
            @Param("profesionalId") Long profesionalId,
            @Param("inicio") LocalDateTime inicio,
            @Param("fin") LocalDateTime fin
    );
}
