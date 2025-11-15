package pe.edu.upc.calmsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.calmsphere.entities.MetodoPago;

import java.time.LocalDate;
import java.util.List;

public interface IMetodoPagoRepository extends JpaRepository <MetodoPago,Integer> {

}
