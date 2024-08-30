package métier;

public class Livre extends Document{
    private int isbn ;

    public Livre(int isbn ,int id , String auteur,String datePublication, String titre ,String nombre_pages ){
        super(id, auteur, datePublication, titre, nombre_pages);
        this.isbn = isbn;
    }

    @Override
    public void emprunter() {

    }

    @Override
    public void afficher_details() {

    }

    @Override
    public void retourner() {

    }
}
