package pe.edu.upc.calmsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.calmsphere.entities.Evento;

import java.util.List;

public interface IEventoRepository extends JpaRepository<Evento, Integer> {
    List<Evento> findByUsuario_IdUsuario(int idUsuario);
    List<Evento> findByProfesionalServicio_IdProfesionalServicio(int idProfesionalServicio);
    List<Evento> findByMetodoPago_Id(int idMetodoPago);
}
