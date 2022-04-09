package ImpDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
    public List<sod> listar() throws Exception {
        List<sod> lista = null;
        try{
            this.conectar();
            PreparedStatement st= this.cone.prepareStatement("select * from SalesOrderDetail");
            lista= new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                sod sodetail = new sod();
                //sod.setSalesOrderID(rs.getInt("SalesOrderID"));
                //sod.setSalesOrderDetailID(rs.getInt("SalesOrderDetailID"));
                //sod.setCarrierTrackingNumber(rs.getString("CarrierTrackingNumber"));
                //sod.setSpecialOfferID(rs.getInt("SpecialOrderID"));
                //sod.setUnitPrice(rs.getString("UnitPrice"));
                //sod.setUnitPriceDiscount(rs.getString("UnitPriceDiscount"));
                //sod.setLineTotal(rs.getString("LineTotal"));
                //sod.setRowguid(rs.getString("rowguid"));
                //sod.setModifiedDate(rs.getString("ModifiedDate"));
                //lista.add(sodetail);
            }
            rs.close();
            st.close();


        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();
        }

        return lista;
    }
    
    
}