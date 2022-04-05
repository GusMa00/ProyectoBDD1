package DAO;
import java.util.*;
public interface SOHDAO {
    public void registrar (soh soheader) throws Exception;
    public void modificar (soh soheader) throws Exception;
    public void eliminar (soh soheader) throws Exception;
    public List<soh> listar() throws Exception; 
}
