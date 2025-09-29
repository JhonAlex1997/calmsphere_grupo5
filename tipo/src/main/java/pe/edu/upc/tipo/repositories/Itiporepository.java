package pe.edu.upc.tipo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.tipo.entities.tipo;

public interface Itiporepository extends JpaRepository<tipo, Integer> {
}
