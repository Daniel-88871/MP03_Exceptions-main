package Excepcions.ActivitatExceptions;

import Excepcions.ActivitatExceptions.Control.Menus;
import Excepcions.ActivitatExceptions.Control.OperacionsBanc;
import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;
import java.util.Scanner;

public class MainExceptions {
    public static void main(String[] args) throws BankAccountException {

        Menus menus = new Menus();
        int opcio1;
        int opcio2;
        boolean w = false;
        Scanner scanner = new Scanner(System.in);

        OperacionsBanc operacionsBanc = new OperacionsBanc();
        while (!w) {
            menus.MenuInicial();
            opcio1 = scanner.nextInt();
            switch (opcio1) {
                case 1:
                    operacionsBanc.crearCompte();
                    break;
                case 2:
                   operacionsBanc.VeureComptes();
                   menus.MenusTransferencia1();
                   operacionsBanc.Transferencies();
                    break;
                case 3:
                   operacionsBanc.verificarDNI();
                    break;
                case 4:
                    menus.MenusGestions();
                    opcio2 = scanner.nextInt();

                        switch (opcio2) {
                    case 1:
                        menus.MenusIngresar();
                        operacionsBanc.GestionsCompteIngresar();
                        break;
                    case 2:
                        menus.MenusTreure();
                        operacionsBanc.GestionsCompteTreure();
                        break;
                    case 3:
                        menus.MenusEliminarUsuari();
                        operacionsBanc.GestionsCompteEsborrarUsuari();
                        break;
                    case 4:
                        menus.MenusBuscarCompte();
                        operacionsBanc.BuscarComptePerNumeroDeCompte();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                }
                    break;
            }
        }
    }
}