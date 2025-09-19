package pe.edu.upc.calmsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.calmsphere.entities.Rol;

import java.util.List;

public interface IRolRepository extends JpaRepository<Rol,Integer> {
    //Listar por tipo de Rol
    @Query("Select r from Rol r where r.tipoRol like %:tipo%")
    public List<Rol> buscarTipoRol(@Param("tipo") String tipo);
}