package pe.edu.upc.calmsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.calmsphere.entities.RegistroEstadoAnimo;

public interface IRegistroEstadoAnimoRepository extends JpaRepository<RegistroEstadoAnimo, Integer> {
}
