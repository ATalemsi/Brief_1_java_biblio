package métier;

public abstract class Document {
    protected int id;
    protected String auteur;
    protected String datePublication;
    protected String titre;
    protected String nombre_pages;


    public Document(int id, String auteur, String datePublication, String titre, String nombre_pages) {
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
    public String getDatePublication() {
        return datePublication;
    }
    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
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
    // fin geter and seters

    public abstract void emprunter();
    public abstract void afficher_details();
    public abstract void retourner();


}
