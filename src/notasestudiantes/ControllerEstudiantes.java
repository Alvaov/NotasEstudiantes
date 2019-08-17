/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notasestudiantes;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static notasestudiantes.NotasEstudiantes.getStage;



/**
 * FXML Controller class
 *
 * @author allva
 * Clase controladora, toma los datos del fxml y conecta
 * con los datos de la clase Estudiante
 * Código base del controlador y fxml tomado de https://docs.oracle.com/javafx/2/fxml_get_started/fxml_tutorial_intermediate.htm
 * https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
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
    @FXML
    private Button button;
    /**
     * Initializa la clase controladora.
     * @param url
     * @param rb
     * Asigna los valores de cada columna de la tabla
     * Código base tomado de https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#syntax
     * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableColumn.html
     * https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
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
        //

       tableView.setItems(estudiantes); 
    }   
    
    /**
     *
     * @param list
     * Toma la lista de objetos Estudiante
     * Asigna todos los valores de la lista entrante a la ObservableList definida para 
     * cargar los archivos en la tabla.
     * Código base tomado de https://docs.oracle.com/javafx/2/fxml_get_started/fxml_tutorial_intermediate.htm
     */
    public void PasarObjetos(List<Estudiantes> list){

        estudiantes.setAll(list);
    }
    @FXML
    public void AbrirArchivo(){
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    fileChooser.getExtensionFilters().addAll(
    new FileChooser.ExtensionFilter("Text Files", "*.csv")
    );

    File selectedFile = fileChooser.showOpenDialog(NotasEstudiantes.getStage());
    if (selectedFile != null) {
        ruta = selectedFile.getAbsolutePath();
        ArchivoCSV ArchivoEstudiantes = new ArchivoCSV(ruta);
        listaEstudiantes2 = ArchivoEstudiantes.ObtenerDatos();

        }
        List listaObjetos = NotasEstudiantes.ListaObjetos(listaEstudiantes2);
        PasarObjetos(listaObjetos);
    }
    
    private List<List<String>> listaEstudiantes2;
    private String ruta;
    private ObservableList<Estudiantes> estudiantes = FXCollections.observableArrayList( );                                                
    
}

