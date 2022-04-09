package ImpDAO;

import java.sql.PreparedStatement;

import Conex.ConexionI2SS;
import DAO.SOPDAO;
import DAO.sop;

public class ImplSOffer extends ConexionI2SS implements SOPDAO{

    @Override
    public void modificar(sop soproduct) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("update SpecialOfferProduct  SET ProductID = ?, Rowguid = ?, ModifiedDate = ? WHERE SpecialOfferID = ?");
            st.setInt(1, soproduct.getProductID());
            st.setString(2, soproduct.getRowguid());
            st.setString(3, soproduct.getModifiedDate());
            st.setInt(4, soproduct.getSpecialOfferID());
            st.executeUpdate();

        }catch (Exception e){
            throw e;
        } finally{
            this.cerrar();
        }
        
    }

    @Override
    public void eliminar(sop soproduct) throws Exception {        
        try{
            this.conectar();
            PreparedStatement st= this.conexion.prepareStatement("delete from SpecialOfferProduct where SpecialOfferID = ?");
            st.setInt(1, soproduct.getSpecialOfferID());
            st.executeUpdate();

        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }

        
    }
    
}
