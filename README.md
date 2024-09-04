# Système de Gestion de Bibliothèque

## Contexte du Projet

Une bibliothèque municipale souhaite automatiser ses tâches via un système de gestion informatisé. Ce projet vise à développer une application console en Java 8 pour gérer efficacement l'inventaire des livres et magazines, ainsi que les emprunts et retours.

## Architecture de l'Application

L'application est conçue selon une architecture en couches :

1. **Couche de Présentation** :
   - `ConsoleUI` : Gère l'interface utilisateur via la console.

2. **Couche Métier** :
   - `Document` (Classe Abstraite) : Contient les attributs et méthodes abstraites pour les documents.
   - `Livre` (Hérite de `Document`) : Représente un livre avec un attribut supplémentaire `isbn`.
   - `Magazine` (Hérite de `Document`) : Représente un magazine avec un attribut supplémentaire `numero`.
   - `Bibliotheque` : Gère les documents de la bibliothèque.

3. **Couche Utilitaire** :
   - `DateUtils` : Utilitaire pour la manipulation des dates.

## Fonctionnalités Principales

### Ajouter un Document

- **Méthode** : `ajouterDocument(Document doc)`
- **Description** : Permet d'ajouter un document à la bibliothèque. Le type du document peut être `Livre` ou `Magazine`.
- **Détails** :
  - Crée un nouvel objet `Livre` ou `Magazine`.
  - Ajoute le document à la liste des documents stockés dans `Bibliotheque`.

### Emprunter un Document

- **Méthode** : `emprunterDocument(String id)`
- **Description** : Permet à un utilisateur d'emprunter un document en spécifiant son ID.
- **Détails** :
  - Recherche le document par ID dans la bibliothèque.
  - Met à jour le statut du document pour indiquer qu'il est emprunté.
  - Utilise la méthode `emprunter()` de la classe `Document` pour effectuer l'action.

### Retourner un Document

- **Méthode** : `retournerDocument(String id)`
- **Description** : Permet à un utilisateur de retourner un document emprunté en spécifiant son ID.
- **Détails** :
  - Recherche le document par ID dans la bibliothèque.
  - Met à jour le statut du document pour indiquer qu'il est retourné.
  - Utilise la méthode `retourner()` de la classe `Document` pour effectuer l'action.

### Afficher Tous les Documents

- **Méthode** : `afficherTousLesDocuments()`
- **Description** : Affiche la liste de tous les documents présents dans la bibliothèque.
- **Détails** :
  - Parcourt la liste des documents stockés.
  - Utilise la méthode `afficherDetails()` de la classe `Document` pour afficher les détails de chaque document.

### Rechercher un Document

- **Méthode** : `rechercherDocument(String critere)`
- **Description** : Permet de rechercher un document en fonction d'un critère (par exemple, titre, auteur, ISBN, numéro).
- **Détails** :
  - Utilise un `HashMap` pour une recherche rapide basée sur les critères spécifiés.
  - Retourne les documents correspondants au critère de recherche.

## Détails des Classes

### Classe Abstraite Document

- **Attributs** :
  - `id` : Identifiant unique du document.
  - `titre` : Titre du document.
  - `auteur` : Auteur du document.
  - `datePublication` : Date de publication du document.
  - `nombreDePages` : Nombre de pages du document.
- **Méthodes Abstraites** :
  - `emprunter()` : Méthode pour marquer le document comme emprunté.
  - `retourner()` : Méthode pour marquer le document comme retourné.
  - `afficherDetails()` : Méthode pour afficher les détails du document.

### Classe Livre (Hérite de Document)

- **Attribut Supplémentaire** :
  - `isbn` : Numéro ISBN du livre.
- **Méthodes** :
  - Implémente les méthodes abstraites de `Document`.

### Classe Magazine (Hérite de Document)

- **Attribut Supplémentaire** :
  - `numero` : Numéro du magazine.
- **Méthodes** :
  - Implémente les méthodes abstraites de `Document`.

### Classe Bibliotheque

- **Attributs** :
  - `documents` : Liste des documents de la bibliothèque (`ArrayList<Document>`).
  - `documentMap` : Map pour la recherche rapide des documents (`HashMap<String, Document>`).
- **Méthodes** :
  - Gestion des documents (ajout, emprunt, retour, affichage, recherche).

### Classe DateUtils

- **Méthodes Utilitaires** :
  - `formatDate(LocalDate date)` : Formate une date en chaîne de caractères.
  - `parseDate(String dateStr)` : Parse une chaîne de caractères en `LocalDate`.

## Instructions pour l'Exécution

1. Cloner le dépôt Git :

   ```bash
   git clone https://github.com/ATalemsi/Brief_1_java_biblio
