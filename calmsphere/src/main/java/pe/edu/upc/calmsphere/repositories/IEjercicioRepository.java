package pe.edu.upc.calmsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.calmsphere.entities.Ejercicio;
import java.util.List;

public interface IEjercicioRepository extends JpaRepository<Ejercicio, Integer> {
    List<Ejercicio> findByCategoria(String categoria);
}
