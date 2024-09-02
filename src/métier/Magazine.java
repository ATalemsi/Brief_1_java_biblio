package métier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Magazine extends Document {
    private int numero;
    private boolean estEmprunte = false;  // Indique si le livre est emprunté
    private LocalDate dateEmprunt;
    public static ArrayList<Magazine> magazines = new ArrayList<Magazine>();

    public Magazine(int numero ,int id , String auteur,String datePublication, String titre ,String nombre_pages ) {
        super(id, auteur, datePublication, titre, nombre_pages);
         this.numero = numero;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstEmprunte() {
        return estEmprunte;
    }
    @Override
    public boolean emprunter() {


    }


    @Override
    public boolean retourner() {

    }


    @Override
    public void afficher() {
        for (Magazine magazine : magazines) {
            magazine.afficher_details();
            System.out.println("------------------");
        }
    }
}
