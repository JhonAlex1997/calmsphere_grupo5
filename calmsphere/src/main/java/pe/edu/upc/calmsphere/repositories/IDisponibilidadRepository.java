package pe.edu.upc.calmsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.calmsphere.entities.Disponibilidad;

import java.util.List;

public interface IDisponibilidadRepository extends JpaRepository<Disponibilidad, Integer> {
    List<Disponibilidad> findByDiaSemana(Integer diaSemana);
}
