/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Personne;

/**
 *
 * @author Elife-Kef-139
 */
public interface Ipersonne {
    
    //insert
    public void ajouterPersonne(Personne p);
    public void ajouterPersonne2(Personne p);
    
    //select
    public List<Personne> afficherPersonne();
    
    //delete
    public void supprimerPersonne(Personne p);
}
