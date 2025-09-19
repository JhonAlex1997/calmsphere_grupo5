package pe.edu.upc.ejercicio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.ejercicio.entities.ejercicio;

@Repository
public interface Iejerciciorepository extends JpaRepository<ejercicio, Integer> {
}
