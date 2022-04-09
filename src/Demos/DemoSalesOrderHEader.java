package Demos;

import java.util.Scanner;
import DAO.SOHDAO;
import DAO.soh;
import ImpDAO.ImplSOrderHeader;

public class DemoSalesOrderHEader {
    public static void delcus(){
        Scanner sc= new Scanner(System.in);
        soh sorderheader = new soh();
        System.out.println("Introduzca el ID a eliminar: ");
        int sodid = sc.nextInt();
        sorderheader.setSalesOrderID(sodid);
        try{   
            SOHDAO dao = new ImplSOrderHeader();
            dao.eliminar(sorderheader);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
