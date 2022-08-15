/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import interfaces.Ipersonne;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import model.Personne;
import services.PersonneService;

/**
 * FXML Controller class
 *
 * @author Elife-Kef-139
 */
public class FirstFXMLController implements Initializable {

    @FXML
    private Button resetBtn;
    @FXML
    private Button subBtn;
    @FXML
    private TextField nomTF;
    @FXML
    private TextField prenomTF;
    @FXML
    private TextField cinTF;
    @FXML
    private TextField ageTF;
    @FXML
    private Button showBtn;
    @FXML
    private Label showLabel;
    @FXML
    private ComboBox<Personne> comboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init();
    }

    @FXML
    private void reset(ActionEvent event) {
        nomTF.clear();
        prenomTF.clear();
        cinTF.clear();
        ageTF.clear();
    }

    @FXML
    private void save(ActionEvent event) {
        Ipersonne ip = new PersonneService();
        Personne p = new Personne(nomTF.getText(), prenomTF.getText(), cinTF.getText(), Integer.parseInt(ageTF.getText()));
        ip.ajouterPersonne2(p);
        init();
    }

    @FXML
    private void show(ActionEvent event) {
        Ipersonne ip = new PersonneService();
        showLabel.setText(ip.afficherPersonne().toString());
    }

    @FXML
    private void Delete(ActionEvent event) {
        SingleSelectionModel<Personne> sp = comboBox.getSelectionModel();
        int index = sp.getSelectedIndex();
        Ipersonne ip = new PersonneService();
        List<Personne> personnes = ip.afficherPersonne();
        Personne p = personnes.get(index);
        ip.supprimerPersonne(p);
        init();

    }

    //init
    public void init() {
        Ipersonne ip = new PersonneService();
        ObservableList<Personne> mList = FXCollections.observableArrayList(ip.afficherPersonne());
        comboBox.setItems(mList);
    }

    @FXML
    private void Edit(ActionEvent event) {
        SingleSelectionModel<Personne> sp = comboBox.getSelectionModel();
        int index = sp.getSelectedIndex();
        Ipersonne ip = new PersonneService();
        List<Personne> personnes = ip.afficherPersonne();
        Personne p = personnes.get(index);
        //load textfields
        nomTF.setText(p.getNom());
        prenomTF.setText(p.getPrenom());
        cinTF.setText(p.getCin());
        ageTF.setText(String.valueOf(p.getAge()));
    
    }
}
