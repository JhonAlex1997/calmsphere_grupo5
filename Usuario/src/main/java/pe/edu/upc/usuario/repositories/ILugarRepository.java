package pe.edu.upc.usuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.usuario.entities.Lugar;

import java.util.List;

public interface ILugarRepository extends JpaRepository<Lugar,Integer> {
    //Listar por nombre
    @Query("Select l from Lugar l where l.nombre like %:nombre%")
    public List<Lugar> buscar(@Param("nombre") String nombre);
}
