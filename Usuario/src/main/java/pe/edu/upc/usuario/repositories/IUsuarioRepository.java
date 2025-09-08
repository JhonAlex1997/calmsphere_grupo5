package pe.edu.upc.usuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.usuario.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
