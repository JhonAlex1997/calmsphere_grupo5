package pe.edu.upc.calmsphere.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.calmsphere.entities.Usuario;
import pe.edu.upc.calmsphere.repositories.IUsuarioRepository;

import java.util.ArrayList;
import java.util.List;


//Clase 2
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository repo;


    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuario user = repo.findOneByNombre(nombre);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not exists", nombre));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        user.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getTipoRol()));
        });

        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getNombre(), user.getContraseña(), true, true, true, true, roles);

        return ud;
    }
}