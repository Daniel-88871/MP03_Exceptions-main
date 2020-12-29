package Excepcions.ActivitatExceptions.Control;

import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;
import Excepcions.ActivitatExceptions.Exceptions.ClientAccountException;
import Excepcions.ActivitatExceptions.Exceptions.ExceptionMessage;
import Excepcions.ActivitatExceptions.Model.Client;
import Excepcions.ActivitatExceptions.Model.CompteEstalvi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperacionsBanc {

    List<CompteEstalvi> llistaComptes = new ArrayList<>();
    Menus menus = new Menus();
    Scanner scanner = new Scanner(System.in);

    public static boolean verifyDNI(String dni) throws ClientAccountException {
        final String WRONG_DNI = "El DNI no es correcte: ";
        boolean correcte = false;
        Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher matcher = pattern.matcher(dni);

        if (matcher.matches()) {

            String lletra = matcher.group(2);
            String lletres = "TRWAGMYFPDXBNJZSQVHLCKE";
            int index = Integer.parseInt(matcher.group(1));
            index = index % 23;
            String reference = lletres.substring(index, index + 1);

            if (reference.equalsIgnoreCase(lletra)) {
                correcte = true;
            } else {
                correcte = false;
                throw new ClientAccountException(WRONG_DNI + dni);
            }
        }
        return correcte;
    }

    public void crearCompte() {

        menus.MenuCrearCompte1();
        Scanner scanner = new Scanner(System.in);

        String ClientNom = scanner.nextLine();
        String ClientCognom = scanner.nextLine();
        String DNI = scanner.nextLine();

        Client client = new Client(ClientNom, ClientCognom, DNI);
        List<Client> llistaUsuaris1 = Arrays.asList(client);
        menus.MenuCrearCompte2();
        String numCompte = scanner.nextLine();
        double saldo = scanner.nextDouble();

        llistaComptes.add(new CompteEstalvi(numCompte, saldo, llistaUsuaris1));
        System.out.println("Vol crear una altra compte? Premi 1 si desitja crear un altre compte, premi qualsevol altre numero per acabar");

        int option = scanner.nextInt();
        if (option == 1) {
            crearCompte();
        } else {
            System.out.println(" ");

            System.out.println("Tornant al menú principal...");

            System.out.println(" ");
        }
    }

    public void VeureComptes() {

        for (int i = 0; i < llistaComptes.size(); i++) {
            System.out.println(i + "." + "Numero de compte: " + llistaComptes.get(i).getNumCompte() + "Saldo: " + llistaComptes.get(i).getSaldo() + " Llista de usuaris: " + llistaComptes.get(i).getLlista_usuaris());
        }
    }

    public void Transferencies() throws BankAccountException {

        double transferencia = scanner.nextDouble();
        menus.MenusTransferencia2();
        int num1 = scanner.nextInt();
        double saldoEmissor = llistaComptes.get(num1).getSaldo();
        saldoEmissor = saldoEmissor - transferencia;

        if (saldoEmissor > 0) {
            llistaComptes.get(num1).setSaldo(saldoEmissor);
            menus.MenusTransferencia3();
            int num2 = scanner.nextInt();
            double saldoReceptor = llistaComptes.get(num2).getSaldo();
            saldoReceptor = saldoReceptor + transferencia;
            llistaComptes.get(num2).setSaldo(saldoReceptor);
        } else {
            throw new BankAccountException(ExceptionMessage.TRANSFER_ERROR);
        }
    }

    public void GestionsCompteIngresar() {
        VeureComptes();
        int num = scanner.nextInt();
        double ingres = scanner.nextDouble();
        llistaComptes.get(num).ingressar(ingres);
    }

    public void GestionsCompteTreure() {
        VeureComptes();
        int num = scanner.nextInt();
        double quantitat = scanner.nextDouble();
        try {
            llistaComptes.get(num).treure(quantitat);
        } catch (BankAccountException m) {
            m.printStackTrace();
        }
    }

    public void GestionsCompteEsborrarUsuari() throws BankAccountException {
        VeureComptes();
        int num = scanner.nextInt();
        String DNI = scanner.nextLine();
        try {
            llistaComptes.get(num).removeUser(DNI);
        } catch (BankAccountException k) {
            k.printStackTrace();
        }
    }

    public void BuscarComptePerNumeroDeCompte() throws BankAccountException {
        String numCompte = scanner.nextLine();
        for (int i = 0; i < llistaComptes.size(); i++) {
            if (numCompte.equals(llistaComptes.get(i).getNumCompte())) {
                System.out.println("Compte existent");
            } else {
                throw new BankAccountException(ExceptionMessage.ACCOUNT_NOT_FOUND);
            }
        }
    }

    public void verificarDNI() {
        menus.MenusDNI();
        String DNI = scanner.nextLine();

        try {
            verifyDNI(DNI);
            System.out.println("Correcto");
        } catch (ClientAccountException e) {
            System.out.println(e);
        }
    }
}