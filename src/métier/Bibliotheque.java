package métier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Bibliotheque {
    ArrayList<Document> documents;
    HashMap<String,Document> searchDocs;

    public Bibliotheque(Document document, HashMap<String,Document> searchDocs) {
        this.documents = new ArrayList<>();
        this.searchDocs = new HashMap<>();
    }

    public void ajouterDocument(Document document) {
        this.documents.add(document);
        this.searchDocs.put(document.getTitre(), document);
    }

    public boolean emprunter(int id) {

    }

    public void returner(int id) {
        Document doc = this.searchDocs.get(id);
        if (doc.GetEstEmprunte()){
            doc.setEstEmprunte(false);
        }else{

        }
    }

}
