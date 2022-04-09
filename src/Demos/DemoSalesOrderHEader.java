package Demos;

import java.util.Scanner;
import DAO.SOHDAO;
import DAO.soh;
import ImpDAO.ImplSOrderHeader;

public class DemoSalesOrderHEader {

    public static void demogenerica(){
        System.out.println("Seleccione una opcion: \n");
        System.out.println("1. C");
        System.out.println("2. R");
        System.out.println("3. U");
        System.out.println("4. D");
        Scanner mdg = new Scanner(System.in);
        int op = mdg.nextInt();
        switch(op){
            case 1:
            break;
            case 2: 
            break;
            case 3:
            break;
            case 4: 
            break;
        }
    }
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
