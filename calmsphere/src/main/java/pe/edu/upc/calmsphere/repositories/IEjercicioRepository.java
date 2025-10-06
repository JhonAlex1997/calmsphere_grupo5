package pe.edu.upc.calmsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.calmsphere.entities.Ejercicio;

import java.util.List;

public interface IEjercicioRepository extends JpaRepository<Ejercicio, Integer> {
    List<Ejercicio> findByCategoria(String categoria);
    @Query("SELECT e FROM Ejercicio e WHERE LOWER(e.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Ejercicio> buscarPorNombreContiene(@Param("nombre") String nombre);
    @Query("SELECT e FROM Ejercicio e WHERE LOWER(e.categoria) = LOWER(:categoria) AND e.duracionSugerida >= :duracionMin")
    List<Ejercicio> buscarPorCategoriaYDuracionMinima(@Param("categoria") String categoria, @Param("duracionMin") int duracionMin);

}
