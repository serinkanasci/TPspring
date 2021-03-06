package com.example.demo;
import java.sql.*;


import java.io.Serializable;
import java.util.ArrayList;

public class Coach implements Serializable {
    // Generated by VSCODE
    private static final long serialVersionUID = 5257120107096513127L;

    private String nom;
    private String prenom;
    private int codePostal;
    private ArrayList<Cours> mesCours = new ArrayList<Cours>();

    Coach() {

    }

    Coach(String myNom, String myPrenom, int myCodePostal) {
        this.nom = myNom;
        this.prenom = myPrenom;
        this.codePostal = myCodePostal;
    }
    public String getNom(){
        return this.nom;
    }    
    public String getPrenom(){
        return this.prenom;
    }    
    public int getCodePostal(){
        return this.codePostal;
    }

    public ArrayList<Cours> getMesCours(){
        return this.mesCours;
    }

    public String coursToString(ArrayList<Cours> _Cours){
        String lesCours = "";
        for (int i = 0; i < _Cours.size(); i++) {
            lesCours += _Cours.get(i).getLibelle() + "; ";
        }
        return lesCours;
    }

    public void addCours(Cours monCours){
        this.mesCours.add(monCours);
    }

    public void setNom(String newNom){
        this.nom = newNom;
    }
    public void setPrenom(String newPrenom){
        this.prenom = newPrenom;
    }
    public void setCodePostal(int newCodePostal){
        this.codePostal = newCodePostal;
    }

    public void enregistre() throws SQLException {

        String url = "jdbc:postgresql://localhost:57558/tp_spring";
        String user = "postgres";
        String password = "root";
    
        Connection conn = null;
        System.out.println("HERE WE ARE");
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("HERE WE ARE 2");

        String SQL = "INSERT INTO Coachs(nom, prenom, codePostal) VALUES (?,?,?)";
        System.out.println("HERE WE ARE 3");
        try(PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) 
        {
            pstmt.setString(1, this.nom);
            pstmt.setString(2, this.prenom);
            pstmt.setInt(3, this.codePostal);

            pstmt.executeUpdate(); 
            pstmt.close();
        } 

        conn.close();
    }
    public void afficher() {
        System.out.println("Nom : " + this.nom + ", Prenom : " + this.prenom + ", Code postal : " + this.codePostal + ", propose les cours : " + coursToString(this.mesCours));
    }
}


// Vous allez donc faire un clic sur le projet New > Java Class dont le nom sera Cours.java
// Un cours possède comme attribut, un int qui s'appelera id et sera l'identifiant du cours, ainsi qu'une String pour le libellé.
// Il nous faudra respecter pour cette classe, le modèle d'un bean. 
// Les conventions à respecter sont les suivantes : 
// •	la classe doit être « Serializable » pour pouvoir sauvegarder et restaurer l'état d'instances de cette classe ;
// •	la classe doit posséder un constructeur sans paramètre (constructeur par défaut) ;
// •	les attributs privés de la classe (variables d'instances) doivent être accessibles publiquement via des méthodes accesseurs construit avec get ou set suivi du nom de l'attribut avec la première lettre capitalisée. Le couple d’accesseurs est appelé Propriété ;
// •	la classe ne doit pas être déclarée final.

// Vous créerez ainsi cette classe Cours en respectant toutes ces conventions et ajouter également une méthode void afficher() qui affiche une représentation d'un objet Cours.
//  Placez ensuite cette classe dans le package com.esgi;
