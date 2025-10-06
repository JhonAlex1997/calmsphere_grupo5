package pe.edu.upc.calmsphere.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.calmsphere.entities.Usuario;

import java.util.List;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    //Listar por nombre
    @Query("Select u from Usuario u where u.nombre like %:nombre%")
    public List<Usuario> buscar(@Param("nombre") String nombre);

    @Query(value = "select u.nombre, e.id_evento_estres, e.descripcion, e.fecha, e.nivel_estres\n" +
            " from usuario u inner join evento_estres e\n" +
            " on u.id_usuario = e.id_usuario\n" +
            " order by u.id_usuario, e.id_evento_estres ASC", nativeQuery = true)
    public List<String[]> buscarEventoEstresPorUsuario();

    public Usuario findOneByNombre(String nombre);
}
