package Demos;
import Conex.ConexionI2SS;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.*;

import DAO.SODDAO;
import DAO.sod;
import ImpDAO.ImpNuevaOrden;
import ImpDAO.ImplSOrderDetail;
import java.util.Scanner;
import DAO.SOHDAO;
import DAO.soh;
import ImpDAO.ImplSOrderHeader;

public class DemoNuevaOrden extends ConexionI2SS {

    public static void iniciar_nuorden() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Iniciando nueva orden \n");
        System.out.println("Ingrese ID del producto: ");
        int prodid = sc.nextInt();
        System.out.println("Ingrese cantidad: ");
        int prodcant = sc.nextInt();       
        System.out.println("Validacion inventario \n");
        valinv();
        System.out.println("Validacion Ofertas \n");
        valofer();
        System.out.println("Insert en SOH \n");
        inssoh();
        System.out.println("Insert en SOD \n");
        inssod();
        
    }
    
    public static void valinv() throws Exception{        
        String connectionUrl = "jdbc:sqlserver://localhost:1433;instanceName=IDEAPAD-GAMING-\\MSSQL2;databaseName=AdventureWorks2019;user=sa;password=cacas;encrypt=true;trustServerCertificate=true";
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            CallableStatement cs = con.prepareCall("{CALL Inventario_Check_SP(?)}");            
            cs.registerOutParameter(1, java.sql.Types.VARCHAR);
            String res =cs.getString(1);
            System.out.println(res);
        }
        // Handler para errores.
        catch (SQLException e) {
            e.printStackTrace();        
    }
    }
    
    public static void valofer() throws Exception{        
        String connectionUrl = "jdbc:sqlserver://localhost:1433;instanceName=IDEAPAD-GAMING-\\MSSQL2;databaseName=AdventureWorks2019;user=sa;password=cacas;encrypt=true;trustServerCertificate=true";
        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            CallableStatement cs = con.prepareCall("{CALL Oferta_Check_SP(?)}");            
            cs.registerOutParameter(1, java.sql.Types.VARCHAR);
            String res =cs.getString(1);
            System.out.println(res);
        }
        // Handler para errores.
        catch (SQLException e) {
            e.printStackTrace();        
    }
    }

    public static void inssoh(){
        try{

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void inssod(){
        Scanner scd = new Scanner(System.in);
        sod sorderdetail = new sod();
        sorderdetail.setSalesOrderDetailID(75123);
        sorderdetail.setCarrierTrackingNumber("NULL");
        sorderdetail.setOrderQty(1);
        sorderdetail.setProductID(9891);
        sorderdetail.setSpecialOfferID(1);
        sorderdetail.setUnitPrice("69420");
        sorderdetail.setUnitPriceDiscount("0");
        try{
            SODDAO dao = new ImplSOrderDetail();
            dao.registrar(sorderdetail);
        }catch(Exception e){
            e.printStackTrace();
        }        
    }
}
