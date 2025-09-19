package pe.edu.upc.calmsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.calmsphere.entities.EventoEstres;

import java.time.LocalDate;
import java.util.List;

public interface IEventoEstresRepository extends JpaRepository<EventoEstres, Integer> {
    //Listar por fecha ascendente
    @Query(value = "Select u.nombre, e.fecha ASC\n" +
            " from usuario u inner join evento_estres e\n" +
            " on u.id_usuario = e.id_usuario\n" +
            " order by e.fecha ", nativeQuery = true)
    public List<String[]> buscarPorFecha();
}
