package ImpDAO;
import Conex.ConexionI2SS;
import DAO.CUSDAO;
import DAO.cus;
import java.sql.PreparedStatement;

public class ImplCustomer extends ConexionI2SS implements CUSDAO {

    @Override
    public void modificar(cus customer) throws Exception {
        try{
            this.conectar();
            PreparedStatement st= this.cone.prepareStatement("update customer set PersonID = ?, StoreID = ?, TerritoryID = ?, AccountNumber = ?, Rowguid = ?, ModifiedDate = ? where CustomerID = ?");            
            st.setInt(1, customer.getPersonID());
            st.setInt(2, customer.getStoreID());
            st.setInt(3, customer.getTerritoryID());
            st.setString(4, customer.getAccountNumber());
            st.setString(5, customer.getRowguid());
            st.setTimestamp(6, customer.getModifiedDate());
            st.setInt(7, customer.getCustomerID());
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
