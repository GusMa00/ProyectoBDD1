package ImpDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import Conex.ConexionI2SS;
import DAO.SOHDAO;
import DAO.soh;

public class ImplSOrderHeader extends ConexionI2SS implements SOHDAO {

    @Override
    public void registrar(soh soheader) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("insert into "+"Sales.SalesOrderHeader (RevisionNumber,OrderDate,DueDate,ShipDate,Status,OnlineOrderFlag) "+"Values(SYSDATETIME(),SYSDATETIME(),SYSDATETIME(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NEWID(),SYSDATETIME())");            
            st.setInt(2,soheader.getRevisionNumber());
            st.setString(3,soheader.getOrderDate());
            st.setString(4,soheader.getDueDate());
            st.setString(5,soheader.getShipDate());
            st.setInt(6,soheader.getStatus());
            st.setBoolean(7,soheader.getOnlineOrderFlag());
            st.setInt(8,soheader.getSalesOrder());
            st.setInt(9,soheader.getPurchaseOrderNumber());
            st.setInt(10,soheader.getCustomerID());
            st.setInt(11,soheader.getSalesPersonID());
            st.setInt(12,soheader.getTerritoryID());
            st.setInt(13,soheader.getBillToAddressID());
            st.setInt(14,soheader.getShipToAddressID());
            st.setInt(15,soheader.getShipMethodID());
            st.setInt(16,soheader.getCreditCardID());
            st.setString(17,soheader.getCreditCardApprovalCode());
            st.setInt(18,soheader.getCurrencyRateID());
            st.setString(19,soheader.getSubTotal());
            st.setString(20,soheader.getTaxAmt());
            st.setString(21,soheader.getFreight());
            st.setString(22,soheader.getTotalDue());
            st.setString(23,soheader.getComment());
            st.setString(24,soheader.getRowguid());
            st.setString(25,soheader.getModifiedDate());
            st.executeUpdate();

        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
        
        
    }


    @Override
    public void modificar(soh soheader) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("update Sales.SalesOrderHeader set SalesOrderID = ?, CarrierTrackingNumber = ?, OrderQty = ?, ProductID = ?, SpecialOfferID= ?, UnitPrice = ?, UnitPriceDiscount = ?, LineTotal = ?, rowguid = ?, ModifiedDate = ? where SalesOrderID = ?");                        
            st.setInt(1,soheader.getRevisionNumber());
            st.setString(2,soheader.getOrderDate());
            st.setString(3,soheader.getDueDate());
            st.setString(4,soheader.getShipDate());
            st.setInt(5,soheader.getStatus());
            st.setBoolean(6,soheader.getOnlineOrderFlag());
            st.setInt(7,soheader.getSalesOrder());
            st.setInt(8,soheader.getPurchaseOrderNumber());
            st.setInt(9,soheader.getCustomerID());
            st.setInt(10,soheader.getSalesPersonID());
            st.setInt(11,soheader.getTerritoryID());
            st.setInt(12,soheader.getBillToAddressID());
            st.setInt(13,soheader.getShipToAddressID());
            st.setInt(14,soheader.getShipMethodID());
            st.setInt(15,soheader.getCreditCardID());
            st.setString(16,soheader.getCreditCardApprovalCode());
            st.setInt(17,soheader.getCurrencyRateID());
            st.setString(18,soheader.getSubTotal());
            st.setString(19,soheader.getTaxAmt());
            st.setString(20,soheader.getFreight());
            st.setString(21,soheader.getTotalDue());
            st.setString(22,soheader.getComment());
            st.setString(23,soheader.getRowguid());
            st.setString(24,soheader.getModifiedDate());
            st.setInt(25,soheader.getSalesOrderID());
            st.executeUpdate();

        }catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }
        
    }

    @Override
    public void eliminar(soh soheader) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("delete from Sales.SalesOrderHeader where SalesOrderID = ?");
            st.setInt(1, soheader.getSalesOrderID());
            st.executeUpdate();

        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }
    }


    @Override
    public void listar(soh soheader) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("select * from Sales.SalesOrderHeader");            
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
