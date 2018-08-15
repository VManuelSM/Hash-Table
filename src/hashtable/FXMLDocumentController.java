/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import java.io.BufferedReader;
import java.io.File;
import javafx.collections.FXCollections;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import util.Dictionary;
import util.Word;

/**
 *
 * @author victo
 */
public class FXMLDocumentController implements Initializable {
    private Dictionary dictionary;
     private File lineCounter; File lineManager;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnSal"
    private JFXButton btnSal; // Value injected by FXMLLoader

    @FXML // fx:id="txtPal"
    private JFXTextField txtPal; // Value injected by FXMLLoader

    @FXML // fx:id="txtDefPal"
    private JFXListView<String> txtDefPal; // Value injected by FXMLLoader

    @FXML // fx:id="btnSelTxt"
    private AnchorPane btnSelTxt; // Value injected by FXMLLoader

    ObservableList<String> list = FXCollections.observableArrayList();

    public FXMLDocumentController() {
        
    }
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnSal != null : "fx:id=\"btnSal\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert txtPal != null : "fx:id=\"txtPal\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert txtDefPal != null : "fx:id=\"txtDefPal\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert btnSelTxt != null : "fx:id=\"btnSelTxt\" was not injected: check your FXML file 'FXMLDocument.fxml'.";

    }
    @FXML
    void close(){
        System.exit(0);
    }
    /**
     *  Search the word typed in the JFXTextField
     */
    @FXML
    void searchWord(){
        list.clear();
        BufferedReader input, output;
        Word found = this.dictionary.getDictionaryIndexes().findWord(this.txtPal.getText());
        if(found != null){
            
            list.add(found.toString());
            for(Word word : found){
                if(word != null)
                list.add(word.toString());
                System.out.print(word.getConcept()+"\n");
            }
        }else {
        list.add("Esta palabra no se encuentra\n");
        }
        this.txtDefPal.setItems(list);
        this.txtDefPal.setStyle("-fx-background-color: #673AB7;");
    }
    /**
     * Initlalize the proccess of choosing a txt File to add the words
     */
    @FXML
    void init(){
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new FileNameExtensionFilter("Text File","txt"));
            if(jFileChooser.showDialog(null,"Ejila un fichero por favor")==JFileChooser.APPROVE_OPTION){
                try {
                    lineCounter = new File(jFileChooser.getSelectedFile().getPath());
                    lineManager = new File(jFileChooser.getSelectedFile().getPath());
                    initDictionary(lineCounter, lineManager);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);

                } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
        txtPal.setVisible(true);
        txtDefPal.setVisible(true);
    }
    /**
     * Intilialize the dictionary object
     * Reuires
     * @param lineCounter txt File that contains all words
     * @param lineManager txt File that contains all words
     * @throws IOException if the file is null
     */
    private void initDictionary(File lineCounter,File lineManager) throws IOException{
        int size = 0;
        String line = null;
        BufferedReader counter = null, manager = null;
        counter =new BufferedReader(new InputStreamReader(new FileInputStream(lineCounter), "ISO-8859-1"));
        manager = new BufferedReader(new InputStreamReader(new FileInputStream(lineManager), "ISO-8859-1"));
        while((line = counter.readLine())!=null) size++;
        dictionary = new Dictionary(size);
        dictionary.initDictionary(manager);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
