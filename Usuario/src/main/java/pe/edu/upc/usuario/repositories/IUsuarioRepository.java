package pe.edu.upc.usuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.usuario.entities.Usuario;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    //Listar por nombre
    @Query("Select u from Usuario u where u.nombre like %:nombre%")
    public List<Usuario> buscar(@Param("nombre") String nombre);
}
