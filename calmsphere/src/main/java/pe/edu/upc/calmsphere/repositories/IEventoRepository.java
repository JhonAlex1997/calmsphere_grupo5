package pe.edu.upc.calmsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.calmsphere.entities.Evento;

import java.util.List;

public interface IEventoRepository extends JpaRepository<Evento, Integer> {
    @Query("select e from Evento e where e.idUsuario = :idUsuario")
    List<Evento> findByUsuario(@Param("idUsuario") int idUsuario);
    @Query("select e from Evento e where e.profesionalServicio = :idProfesionalServicio")
    List<Evento> findByProfesionalServicio(int idProfesionalServicio);
    @Query("select e from Evento e where e.idMetodoPago = :idMetodoPago")
    List<Evento> findByMetodoPago(int idMetodoPago);
}
