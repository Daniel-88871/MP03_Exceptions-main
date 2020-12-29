package Excepcions.ActivitatExceptions.Control;

public class Menus {
public void MenuInicial(){
    System.out.println("-------Banc de Catalunya-------");
    System.out.println("Introdueix un dels numeros que i apareixen a la pantalla:");
    System.out.println("1.Crear un nou compte");
    System.out.println("2.Realitzar tranferencia");
    System.out.println("3.Verificar DNI");
    System.out.println("4.Gestions de compte");
}

    public void MenuCrearCompte1(){
        System.out.println("-------Banc de Catalunya-------");
        System.out.println("Introdueix el nom, el cognom i el DNI");
    }

    public void MenuCrearCompte2(){
        System.out.println("-------Banc de Catalunya-------");
        System.out.println("Introdueix el numero de compte i el saldo");
    }

    public void MenusTransferencia1(){
        System.out.println("-------Banc de Catalunya-------");
        System.out.println("Introdueix la quantitat de la transferencia:");
    }

    public void MenusTransferencia2(){
        System.out.println("-------Banc de Catalunya-------");
        System.out.println("Selecciona el compte des del qual vol enviar els diners:");
    }

    public void MenusTransferencia3(){
        System.out.println("-------Banc de Catalunya-------");
        System.out.println("Selecciona el compte des del qual vol rebre els diners:");
    }

    public void MenusDNI(){
        System.out.println("-------Banc de Catalunya-------");
        System.out.println("Introdueix el DNI a verificar");
    }

    public void MenusGestions(){
        System.out.println("-------Banc de Catalunya-------");
        System.out.println("Introdueix un dels numeros que i apareixen a la pantalla:");
        System.out.println("1.Ingressar diners");
        System.out.println("2.Treure diners");
        System.out.println("3.Esborrar usuari");
        System.out.println("4.Buscar compte");
        System.out.println("5.Sortir");
    }

    public void MenusIngresar(){
        System.out.println("-------Banc de Catalunya-------");
        System.out.println("Introdueix el compte i la quantitat a ingressar: ");
    }

    public void MenusTreure(){
        System.out.println("-------Banc de Catalunya-------");
        System.out.println("Introdueix el compte i la quantitat a treure: ");
    }

    public void MenusEliminarUsuari(){
        System.out.println("-------Banc de Catalunya-------");
        System.out.println("Introdueix el compte iel dni de la persona a donar de baixa: ");
    }

    public void MenusBuscarCompte(){
        System.out.println("-------Banc de Catalunya-------");
        System.out.println("Introdueix el numero de compte que vols buscar  ");
    }
}