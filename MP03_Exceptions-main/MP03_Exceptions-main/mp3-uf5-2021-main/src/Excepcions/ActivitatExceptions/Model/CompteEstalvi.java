package Excepcions.ActivitatExceptions.Model;

import Excepcions.ActivitatExceptions.Exceptions.BankAccountException;

import java.util.List;

public class CompteEstalvi {
    public String numCompte;
    public double saldo;
    public List<Client> llista_usuaris;


   public static final String ACCOUNT_NOT_FOUND = "Compte inexistent";
    public static final String ACCOUNT_OVERDRAFT = "Compte al descobert";
    public static final String ACCOUNT_ZERO_USER = "Compte sense usuari";


    public CompteEstalvi(String numCompte) {
        this.numCompte = numCompte;
        saldo = 0;
    }

    public CompteEstalvi(String numCompte, double saldo, List<Client> llista_usuaris) {
        this.numCompte = numCompte;
        this.saldo = saldo;
        this.llista_usuaris = llista_usuaris;
    }

    public CompteEstalvi() {
    }

    /*public void BuscarCompte(String numCompte) throws BankAccountException{

            if (numCompte.equals(getNumCompte())){
                System.out.println("Cuenta existente");
            }else{
                throw new BankAccountException(ACCOUNT_NOT_FOUND);
            }
        }
*/

    /**
        Afegeix un usuari d'aquest compte
        @param client
        @return quantitat d'usuaris que té el compte

     **/
    public int addUser(Client client) {
        llista_usuaris.add(client);
        return llista_usuaris.size();
    }

    /**
     Elimina un usuari d'aquest compte,
     Com que no pot quedar un compte sense usuari, si és l'ùltim és llança una excepció
     @param dni
     @return quantitat d'usuaris que té el compte
     @throws BankAccountException
     **/
    public int removeUser(String dni)  throws BankAccountException{

             if(llista_usuaris.size()>1) {
                 llista_usuaris.removeIf(u -> dni.equals(u.getDNI()));
                 return llista_usuaris.size();
             }else {
                 throw new BankAccountException(ACCOUNT_ZERO_USER);
             }
    }

    /**
     * Afegeix m diners al saldo
     * @param m
     */
    public void ingressar(double m) {
        saldo += m;
    }

    /**
     * Treu m diners del compte si n'hi han suficient sinó es llança l'excepció
     * @param m
     * @throws BankAccountException
     */

    public void treure(double m) throws BankAccountException{
      if (m<saldo){
          saldo -= m;
      }else{
          throw new BankAccountException(ACCOUNT_OVERDRAFT);
      }
    }

    public String getNumCompte() {
        return numCompte;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Client> getLlista_usuaris() {
        return llista_usuaris;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}