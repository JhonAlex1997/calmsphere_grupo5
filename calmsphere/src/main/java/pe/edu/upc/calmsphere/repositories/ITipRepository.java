package pe.edu.upc.calmsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.calmsphere.entities.Tip;

public interface ITipRepository extends JpaRepository<Tip, Integer> {
}
