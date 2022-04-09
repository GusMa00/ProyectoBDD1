package Demos;
import java.util.Scanner;

import DAO.CUSDAO;
import DAO.cus;
import ImpDAO.ImplCustomer;

public class DemoCustomer {
    public static void delcus(){
        Scanner sc= new Scanner(System.in);
        cus customer = new cus();
        System.out.println("Introduzca el ID a eliminar: ");
        int cusid = sc.nextInt();
        customer.setCustomerID(cusid);
        try{   
            CUSDAO dao = new ImplCustomer();
            dao.eliminar(customer);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
