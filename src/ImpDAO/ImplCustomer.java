package ImpDAO;
import Conex.ConexionI2SS;
import DAO.CUSDAO;
import DAO.cus;
import DAO.soh;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;

public class ImplCustomer extends ConexionI2SS implements CUSDAO {

    @Override
    public void modificar(cus customer) throws Exception {
        try{
            this.conectar();
            PreparedStatement st= this.cone.prepareStatement("update customer set PersonID = ? where CustomerID = ?");
            st.setInt(1, customer.getCustomerID());
            st.setInt(2, customer.getPersonID());
            st.setInt(3, customer.getStoreID());
            st.setInt(4, customer.getTerritoryID());
            st.setString(5, customer.getAccountNumber());
            st.setString(6, customer.getRowguid());
            st.setString(7, customer.getModifiedDate());
            st.executeUpdate();

        }catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }
        
    }

    @Override
    public void eliminar(cus customer) throws Exception {
        try{
            this.conectar();
            PreparedStatement st= this.cone.prepareStatement("delete from customer where id = ?");
            st.setInt(1, customer.getCustomerID());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }        
    }    
}
