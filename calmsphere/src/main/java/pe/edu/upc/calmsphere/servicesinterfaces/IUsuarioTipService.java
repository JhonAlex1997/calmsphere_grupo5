package pe.edu.upc.calmsphere.servicesinterfaces;

import pe.edu.upc.calmsphere.entities.UsuarioTip;

import java.util.List;

public interface IUsuarioTipService {
    public List<UsuarioTip> list();
    public void insert(UsuarioTip u);
    public UsuarioTip listId(int id);
    public void delete(int id);
    public void update(UsuarioTip u);
}
