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
            PreparedStatement st= this.cone.prepareStatement("");
            st.setInt(1, soproduct.getSpecialOfferID());
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
            PreparedStatement st= this.cone.prepareStatement("");
            st.setInt(1, soproduct.getSpecialOfferID());
            st.executeUpdate();

        }catch (Exception e){
            throw e;
        } finally {
            this.cerrar();
        }

        
    }
    
}
