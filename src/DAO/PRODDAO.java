package DAO;


public interface PRODDAO {
    public void registrar(pprod Producto) throws Exception;
    public void modificar(pprod Producto) throws Exception;
    public void eliminar(pprod Producto) throws Exception;
    public void listar(pprod Producto) throws Exception;
}
