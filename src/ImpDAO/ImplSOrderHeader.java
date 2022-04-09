package ImpDAO;

import java.sql.PreparedStatement;
import java.util.List;

import Conex.ConexionI2SS;
import DAO.SODDAO;
import DAO.sod;

public class ImplSOrderHeader extends ConexionI2SS implements SODDAO {

    @Override
    public void registrar(sod sodetail) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void modificar(sod sodetail) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void eliminar(sod sodetail) throws Exception {
        // TODO Auto-generated method stub
        try{
            this.conectar();
            PreparedStatement st= this.cone.prepareStatement("delete from SalesOrderDetail where id = ?");
            st.setInt(1, sodetail.getSalesOrderDetailID());
            st.executeUpdate();

        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
        
    }

    @Override
    public List<sod> listar() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    
}
