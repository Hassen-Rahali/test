/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop;

import interfaces.Ipersonne;
import model.Personne;
import services.PersonneService;
import util.MaConnexion;

/**
 *
 * @author Elife-Kef-139
 */
public class Workshop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Personne p = new Personne("Khaled2", "Guedria", "12345678", 25);
        Ipersonne ip = new PersonneService();
        //ip.ajouterPersonne2(p);
        System.out.println(ip.afficherPersonne());
    }
    
}
