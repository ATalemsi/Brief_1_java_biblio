package métier;

import java.time.LocalDate;

public class Magazine extends Document {
    private int numero;
    private boolean estEmprunte ;

    public Magazine(int numero , int id , String auteur, LocalDate datePublication, String titre , String nombre_pages ) {
        super(id, auteur,datePublication, titre, nombre_pages);
         this.numero = numero;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }


    @Override
    public void emprunter() {
        System.out.println(" le magazine a été emprunter");
    }


    @Override
    public void retourner() {
        System.out.println(" le magazine a été retourner");
    }

    @Override
    public void afficher_Details() {
        System.out.println("Magazine:");
        System.out.println("ID: " + getId());
        System.out.println("Titre: " + getTitre());
        System.out.println("Auteur: " + getAuteur());
        System.out.println("Date de Publication: " + getDatePublication());
        System.out.println("Nombre de Pages: " + getNombre_pages());
        System.out.println("ISBN: " + getNumero());
        System.out.println("-> : " + (estEmprunte ? "Emprunté" : "Disponible"));
    }

}



