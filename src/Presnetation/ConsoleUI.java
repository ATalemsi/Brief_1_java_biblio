package Presnetation;

import métier.Bibliotheque;
import métier.Document;
import métier.Livre;
import métier.Magazine;
import utilitaire.DateUtils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI {
    private Bibliotheque bibliotheque;
    private Scanner scanner;


    public ConsoleUI() {
        bibliotheque = new Bibliotheque();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        int option;
        do {
            System.out.println("\n== Bibliotheque =====");
            System.out.println("1. Crée Document");
            System.out.println("2. Emprunter Document");
            System.out.println("3. Retourner Document");
            System.out.println("4. Afficher Document");
            System.out.println("5. Rechercher Document");
            System.out.println("6. Quitter");
            System.out.println("Enter ton option(1-6): ");
            option = scanner.nextInt();


            switch (option) {
                case 1:
                    ajouteDocument();
                    break;
                case 2:
                    emprunterDocument();
                    break;
                case 3:
                    retournerDocument();
                    break;
                case 4:
                    afficherDocument();
                    break;
                case 5:
                    rechercherDocument();
                    break;
                case 6:
                    System.out.println("Good by");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez reessayer.");
            }
        } while (option != 6);
    }


    private void ajouteDocument() {
        int type;
        do {
            System.out.println("Veuiller saisir le type de document (1-Livre, 2-Magazine) :");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrée invalide. Veuillez saisir 1 pour Livre ou 2 pour Magazine :");
                scanner.next(); // Consommer l'entrée incorrecte
            }
            type = scanner.nextInt();
            scanner.nextLine();
        } while (type != 1 && type != 2);

        int id;
        do {
            System.out.println("Veuiller saisir le ID :");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrée invalide. Veuillez saisir un numéro valide pour l'ID :");
                scanner.next(); // Consommer l'entrée incorrecte
            }
            id = scanner.nextInt();
            scanner.nextLine();
        } while (id <= 0);

        System.out.println("Veuiller saisir le titre :");
        String title;
        do {
            title = scanner.nextLine();
            if (title.trim().isEmpty()) {
                System.out.println("Le titre ne peut pas être vide. Veuillez saisir un titre valide :");
            }
        } while (title.trim().isEmpty());

        System.out.println("Veuiller saisir l'auteur :");
        String author;
        do {
            author = scanner.nextLine();
            if (author.trim().isEmpty()) {
                System.out.println("L'auteur ne peut pas être vide. Veuillez saisir un nom d'auteur valide :");
            }
        } while (author.trim().isEmpty());

        LocalDate date_publication = null;
        do {
            System.out.println("Veuiller saisir la date de publication (au format dd-MM-yyyy) :");
            String date = scanner.nextLine();
            try {
                date_publication = DateUtils.date(date);
            } catch (DateTimeException e) {
                System.out.println("Format de date invalide. Veuillez entrer une date valide au format dd-MM-yyyy." + e.getMessage());
            }
        } while (date_publication == null);

        String nombre_Pages;
        do {
            System.out.println("Entrer le nombre de pages :");
            nombre_Pages = scanner.nextLine();
            if (nombre_Pages.trim().isEmpty() || !nombre_Pages.matches("\\d+")) {
                System.out.println("Veuillez saisir un nombre valide pour les pages.");
            }
        } while (nombre_Pages.trim().isEmpty() || !nombre_Pages.matches("\\d+"));

        if (type == 1) {
            int isbn;
            do {
                System.out.println("Veuiller saisir le ISBN :");
                while (!scanner.hasNextInt()) {
                    System.out.println("Entrée invalide. Veuillez saisir un numéro valide pour l'ISBN :");
                    scanner.next(); // Consommer l'entrée incorrecte
                }
                isbn = scanner.nextInt();
                scanner.nextLine();
            } while (isbn <= 0);

            Livre livre = new Livre(isbn, id, author, date_publication, title, nombre_Pages);
            bibliotheque.ajouter(livre);
            System.out.println("Le livre a été créé avec succès.");
        } else if (type == 2) {
            int numero;
            do {
                System.out.println("Veuiller saisir le numéro de magazine :");
                while (!scanner.hasNextInt()) {
                    System.out.println("Entrée invalide. Veuillez saisir un numéro valide pour le magazine :");
                    scanner.next(); // Consommer l'entrée incorrecte
                }
                numero = scanner.nextInt();
                scanner.nextLine();
            } while (numero <= 0);

            Magazine magazine = new Magazine(numero, id, author, date_publication, title, nombre_Pages);
            bibliotheque.ajouter(magazine);
            System.out.println("Le magazine a été créé avec succès.");
        }
    }

    private void emprunterDocument() {
        System.out.println("Enter le id de document que tu veux le emprunter :");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean succes = bibliotheque.emprunter(id);
        if (succes) {
            System.out.println(" Document emprunter avec succes");
        } else {
            System.out.println("Echec de emprunter");
        }
    }

    private void retournerDocument() {
        System.out.println("Enter le id de document que tu veux le retourner :");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean succes = bibliotheque.returner(id);
        if (succes) {
            System.out.println(" Document retourner avec succes");
        } else {
            System.out.println("Echec de retourner");
        }
    }

    private void afficherDocument() {
        bibliotheque.afficherTousLesDocuments();
    }

    private void rechercherDocument() {
        System.out.print("Entrez le titre du document a rechercher : ");
        String titre = scanner.nextLine();
        Document document = bibliotheque.rechercher(titre);
        if (document != null) {
            document.afficher_Details();
        } else {
            System.out.println("Document non trouve.");
        }
    }


}