package ImpDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import Conex.ConexionI2SS;
import DAO.SODDAO;
import DAO.sod;

public class ImplSOrderDetail extends ConexionI2SS implements SODDAO {
    @Override
    public void registrar(sod sodetail) throws Exception {
        try{
            this.conectar();
            PreparedStatement st= this.cone.prepareStatement("insert into "+"Sales.Customer "+"Values(?,?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, sodetail.getSalesOrderID());
            st.setInt(2, sodetail.getSalesOrderDetailID());
            st.setString(3, sodetail.getCarrierTrackingNumber());
            st.setInt(4, sodetail.getOrderQty());
            st.setInt(5, sodetail.getProductID());
            st.setInt(6, sodetail.getSpecialOfferID());
            st.setString(7, sodetail.getUnitPrice());
            st.setString(8, sodetail.getUnitPriceDiscount());
            st.setString(9, sodetail.getLineTotal());
            st.setString(10, sodetail.getRowguid());
            st.setString(11, sodetail.getModifiedDate());
            st.executeUpdate();

        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
        
    }

    @Override
    public void modificar(sod sodetail) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.cone.prepareStatement("update customer set SalesOrderID = ?, CarrierTrackingNumber = ?, OrderQty = ?, ProductID = ?, SpecialOfferID= ?, UnitPrice = ?, UnitPriceDiscount = ?, LineTotal = ?, rowguid = ?, ModifiedDate = ? where SalesOrderDetailID = ?");            
            st.setInt(1, sodetail.getSalesOrderID());
            st.setString(2, sodetail.getCarrierTrackingNumber());
            st.setInt(3, sodetail.getOrderQty());
            st.setInt(4, sodetail.getProductID());
            st.setInt(5, sodetail.getSpecialOfferID());
            st.setString(6, sodetail.getUnitPrice());
            st.setString(7, sodetail.getUnitPriceDiscount());
            st.setString(8, sodetail.getLineTotal());
            st.setString(9, sodetail.getRowguid());
            st.setString(10, sodetail.getModifiedDate());            
            st.setInt(11, sodetail.getSalesOrderDetailID());
            st.executeUpdate();

        }catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }
        
    }

    @Override
    public void eliminar(sod sodetail) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.cone.prepareStatement("delete from SalesOrderDetail where SalesOrderDetailID = ?");
            st.setInt(1, sodetail.getSalesOrderDetailID());
            st.executeUpdate();
        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
        
    }
    

    @Override
    public void listar(sod sodetail) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.cone.prepareStatement("select * from SalesOrderDetail");            
            ResultSet rs = st.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            System.out.println(numberOfColumns);
            while (rs.next()) {                
                for (int i = 1; i <= numberOfColumns; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " " );
            }
            System.out.println("\n");
        }
            rs.close();
            st.close();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }        
    }    
    
}