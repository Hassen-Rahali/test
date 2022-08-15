/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ipersonne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Personne;
import util.MaConnexion;

/**
 *
 * @author Elife-Kef-139
 */
public class PersonneService implements Ipersonne {

    //var
    Connection cnx = MaConnexion.getInstance().getCnx();
    
    @Override
    public void ajouterPersonne(Personne p) {
        String req = "INSERT INTO `personne`(`nom`, `prenom`, `cin`, `age`) VALUES ('"
                + p.getNom() + "','"
                + p.getPrenom() + "','"
                + p.getCin() + "',"
                + p.getAge() + ")";
        
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("ST : Personne ajoutée avec succés!");
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void ajouterPersonne2(Personne p) {
        
        String req = "INSERT INTO `personne`(`nom`, `prenom`, `cin`, `age`) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setString(3, p.getCin());
            ps.setInt(4, p.getAge());
            ps.executeUpdate();
            System.out.println("PS : Personne ajoutée avec succés!");
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Personne> afficherPersonne() {
        List<Personne> personnes = new ArrayList<>();
        String req = "SELECT * FROM personne";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Personne p = new Personne();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString(2));
                p.setPrenom(rs.getString("prenom"));
                p.setCin(rs.getString(4));
                p.setAge(rs.getInt("age"));
                personnes.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personnes
;    }

    @Override
    public void supprimerPersonne(Personne p) {

        try {
            String req = "DELETE FROM personne WHERE cin = '"+ p.getCin() +"'";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Personne supprimer avec succés!");
        } catch (SQLException ex) {
            Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
