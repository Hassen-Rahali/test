/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Elife-Kef-139
 */
public class Personne {
    
    //var
    private int id;
    private String nom;
    private String prenom;
    private String cin;
    private int age;
    
    //const
    public Personne() {
    }

    public Personne(int id, String nom, String prenom, String cin, int age) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.age = age;
    }
    
    public Personne(String nom, String prenom, String cin, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.age = age;
    }
    
    //getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    //show
    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", age=" + age + '}';
    }
    
}
