package pe.edu.upc.calmsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.calmsphere.entities.Recordatorio;

public interface IRecordatorioRepository extends JpaRepository<Recordatorio,Integer>{
}
