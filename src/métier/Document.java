package métier;

import utilitaire.DateUtils;

import java.time.LocalDate;

public abstract class Document {
    protected int id;
    protected String auteur;
    protected LocalDate datePublication;
    protected String titre;
    protected String nombre_pages;
    protected boolean estEmprunte = false;

    public Document(int id, String auteur, LocalDate datePublication, String titre, String nombre_pages) {
        this.id = id;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.titre = titre;
        this.nombre_pages = nombre_pages;
    }


    //geter and seters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }


    public String getFormattedDatePublication() {
        return DateUtils.date2(datePublication);
    }
    public LocalDate getDatePublication() {
        return datePublication;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getNombre_pages() {
        return nombre_pages;
    }
    public void setNombre_pages(String nombre_pages) {
        this.nombre_pages = nombre_pages;
    }
    public boolean GetEstEmprunte() {
        return estEmprunte;
    }
    public void setEstEmprunte(boolean estEmprunte) {
        this.estEmprunte = estEmprunte;
    }
    // fin geter and seters

    public abstract void emprunter();
    public abstract void retourner();
    public  abstract  void afficher_Details();


}
