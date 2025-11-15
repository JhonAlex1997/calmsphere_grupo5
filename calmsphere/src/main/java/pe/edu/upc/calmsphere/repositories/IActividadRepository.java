package pe.edu.upc.calmsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.calmsphere.entities.Actividad;

import java.time.LocalDate;
import java.util.List;

public interface IActividadRepository extends JpaRepository <Actividad,Integer>{

    @Query(value = "select r.nombre, count(a.id_actividad)\n" +
            " from Usuario r\n" +
            " inner join Actividad a\n" +
            " on r.id_usuario = a.id_usuario\n" +
            " group by r.nombre", nativeQuery = true)
    public List<Actividad> findByFechaRegistro (LocalDate FechaInicio);
}
