package Demos;

import java.util.Scanner;

import DAO.SODDAO;
import DAO.sod;
import ImpDAO.ImplSOrderDetail;

public class DemoSalesOrderDetail {
    public static void delsod(){
        Scanner sc= new Scanner(System.in);
        sod sorderdetail = new sod();
        System.out.println("Introduzca el ID a eliminar: ");
        int sodid = sc.nextInt();
        sorderdetail.setSalesOrderDetailID(sodid);
        try{   
            SODDAO dao = new ImplSOrderDetail();
            dao.eliminar(sorderdetail);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
