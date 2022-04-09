package Demos;

import java.util.Scanner;

import DAO.SOPDAO;
import DAO.sop;
import ImpDAO.ImplSOffer;

public class DemoSpecialOffer {
    public static void demogenerica(){
        System.out.println("Seleccione una opcion: \n");
        System.out.println("1. R");
        System.out.println("2. U");
        Scanner mdg = new Scanner(System.in);
        int op = mdg.nextInt();
        switch(op){
            case 1:
                listsop();
            break;
            case 2: 
                actsop();
            break;
        }
    }    

    public static void listsop(){
        sop SpecialOProduct = new sop();
        SpecialOProduct.setSpecialOfferID(1);
        try{
            SOPDAO dao = new ImplSOffer();
            dao.listar(SpecialOProduct);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void actsop(){

    }

}
