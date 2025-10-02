package pe.edu.upc.calmsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.calmsphere.entities.Suscripcion;

public interface ISuscripcionRepository extends JpaRepository<Suscripcion, Integer> {
}
