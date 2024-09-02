package métier;


public class Livre extends Document {
    private int isbn;
    private boolean estEmprunte;  // Indique si le livre est emprunté


    public Livre(int isbn, int id, String auteur, String datePublication, String titre, String nombre_pages) {
        super(id, auteur, datePublication, titre, nombre_pages);
        this.isbn = isbn;
        this.estEmprunte = false;

    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }


    @Override
    public boolean emprunter() {
        if (!this.estEmprunte) {
            this.estEmprunte = true;
            System.out.println("Le Livre '" + getTitre() + "' a été emprunté.");
            return true;
        } else {
            System.out.println("Le Livre '" + getTitre() + "' a été déja emprunté.");
            return false;
        }


    }


    @Override
    public boolean retourner() {
        if (this.estEmprunte) {
            this.estEmprunte = false;
            System.out.println("Le Livre '" + getTitre() + "' a été retourné.");
            return true;
        }else {
            System.out.println("Le Livre '" + getTitre() + "' n'est pas emprunté.");
            return false;
        }

    }


    @Override
    public void afficher() {

    }
}
