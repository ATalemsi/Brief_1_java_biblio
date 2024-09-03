package métier;

import java.util.*;

public class Bibliotheque {
    private List<Document> documents;
    private Map<String, Document> searchDocs;
    private static int currentId = 1;

    public Bibliotheque() {
        this.documents = new ArrayList<>();
        this.searchDocs = new HashMap<>();

    }

    public void ajouter(Document document) {
        document.setId(currentId++);
        this.documents.add(document);
        this.searchDocs.put(document.getTitre().trim().toLowerCase(), document);
        System.out.println("Document added with title: " + document.getTitre().trim().toLowerCase());
    }

    public Document rechercher(String titre) {
        return searchDocs.get(titre.trim().toLowerCase());
    }


    public void afficherTousLesDocuments() {
        if (documents.isEmpty()) {
            System.out.println("La bibliotheque ne contient aucun document.");
        } else {
            // Use lambda and stream to iterate over documents and display details
            documents.forEach(Document::afficher_Details);
        }
    }


    public boolean emprunter(int id) {
        Optional<Document> documentOpt = documents.stream()
                .filter(doc -> doc.getId() == id)
                .findFirst();

        return documentOpt.map(doc -> {
            if (!doc.GetEstEmprunte()) {
                doc.setEstEmprunte(true);
                System.out.println("Le document '" + doc.getTitre() + "' a été emprunté.");
                return true;
            } else {
                System.out.println("Le document est déjà emprunté.");
                return false;
            }
        }).orElseGet(() -> {
            System.out.println("Document non trouvé.");
            return false;
        });
    }

    public boolean returner(int id) {
        for (Document doc : documents) {
            if (doc.getId() == id) {
                if (doc.GetEstEmprunte()) {
                    doc.setEstEmprunte(false);
                    System.out.println("Le document '" + doc.getTitre() + "' a été retourné.");
                    return true;
                } else {
                    System.out.println("Le document n'était pas emprunté.");
                    return false;
                }
            }
        }
        System.out.println("Document non trouvé.");
        return false;
    }

}
