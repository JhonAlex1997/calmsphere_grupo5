package pe.edu.upc.suscripcion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.suscripcion.SuscripcionApplication;
@Repository

public interface ISuscripcionRepository extends JpaRepository <SuscripcionApplication,Integer> {
}
