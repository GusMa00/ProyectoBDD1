package DAO;

import java.util.List;

public interface SODDAO {
    public void registrar (sod sodetail) throws Exception;
    public void modificar (sod sodetail) throws Exception;
    public void eliminar (sod sodetail) throws Exception;
    public List<sod> listar() throws Exception; 
}
