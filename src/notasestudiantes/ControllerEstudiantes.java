/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notasestudiantes;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



/**
 * FXML Controller class
 *
 * @author allva
 */
public class ControllerEstudiantes implements Initializable {

    
    @FXML
    private TableView<Estudiantes> tableView;
    @FXML
    private TableColumn<Estudiantes, String> carné;
    @FXML
    private TableColumn<Estudiantes, String> nombreApellidos;
    @FXML
    private TableColumn<Estudiantes, String> correo;
    @FXML
    private TableColumn<Estudiantes, String> teléfono;
    @FXML
    private TableColumn<Estudiantes, String> nickname;
    @FXML
    private TableColumn<Estudiantes, String> tipoEstudiante;
    @FXML
    private TableColumn<Estudiantes, Number> promExámenes;
    @FXML
    private TableColumn<Estudiantes, Number> promQuices;
    @FXML
    private TableColumn<Estudiantes, Number> promTareas;
    @FXML
    private TableColumn<Estudiantes, Number> proyecto1;
    @FXML
    private TableColumn<Estudiantes, Number> proyecto2;
    @FXML
    private TableColumn<Estudiantes, Number> proyecto3;
    @FXML
    private TableColumn<Estudiantes,Number> promedioA;
    @FXML
    private TableColumn<Estudiantes,Number> promedioB;
    @FXML
    private TableColumn<Estudiantes,Number> notaFinal;
    /**
     * Initializes the controller class.

     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        carné.setCellValueFactory(e -> e.getValue().Carné());
        nombreApellidos.setCellValueFactory(e -> e.getValue().NombreApellidos());
        correo.setCellValueFactory(e -> e.getValue().Correo());
        teléfono.setCellValueFactory(e -> e.getValue().Telefono());
        nickname.setCellValueFactory(e -> e.getValue().Nickname());
        tipoEstudiante.setCellValueFactory(e -> e.getValue().TipoEstudiante());
        promExámenes.setCellValueFactory(e -> e.getValue().PromedioExámenes());
        promQuices.setCellValueFactory(e-> e.getValue().PromedioQuices());
        promTareas.setCellValueFactory(e-> e.getValue().PromedioTareas());
        proyecto1.setCellValueFactory(e-> e.getValue().Proyecto1());
        proyecto2.setCellValueFactory(e-> e.getValue().Proyecto2());
        proyecto3.setCellValueFactory(e-> e.getValue().Proyecto3());
        promedioA.setCellValueFactory(e -> e.getValue().PromedioA());
        promedioB.setCellValueFactory(e -> e.getValue().PromedioB());
        notaFinal.setCellValueFactory(e -> e.getValue().NotaFinal());
        System.out.println(promedioB);
       tableView.setItems(estudiantes); 
    }   
    
    public void PasarObjetos(List<Estudiantes> list){
        estudiantes.setAll(list);
    }
    
    private ObservableList<Estudiantes> estudiantes = FXCollections.observableArrayList( );                                                
    
}

