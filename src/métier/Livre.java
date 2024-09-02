package métier;


import java.time.LocalDate;

public class Livre extends Document {
    private int isbn;
     // Indique si le livre est emprunté


    public Livre(int isbn, int id, String auteur, LocalDate datePublication, String titre, String nombre_pages) {
        super(id, auteur,datePublication, titre, nombre_pages);
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }


    @Override
    public void emprunter() {
        System.out.println(" le livre a été emprunter");
    }


    @Override
    public void retourner() {
        System.out.println(" le livre a été retourner");
    }


    @Override
    public void afficher_Details() {
        System.out.println("Livre:");
        System.out.println("ID: " + getId());
        System.out.println("Titre: " + getTitre());
        System.out.println("Auteur: " + getAuteur());
        System.out.println("Date de Publication: " + getDatePublication());
        System.out.println("Nombre de Pages: " + getNombre_pages());
        System.out.println("ISBN: " + getIsbn());
        System.out.println("->: " + (estEmprunte ? "Emprunté" : "Disponible"));

    }
}
