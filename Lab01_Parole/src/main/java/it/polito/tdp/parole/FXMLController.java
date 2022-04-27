package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	int h; 
	long start, end; 

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader

    @FXML // fx:id="txtTime"
    private TextArea txtTime; // Value injected by FXMLLoader

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) 
    {
    	start=System.nanoTime();
    	elenco.addParola(txtParola.getText());
    	txtResult.setText(elenco.getElenco().toString());
    	txtParola.setText(null);
    	btnReset.setDisable(false);
    	end=System.nanoTime();
    	txtTime.setText("Tempo Inserimento= "+ (end-start)); 
    }

    @FXML
    void doReset(ActionEvent event) {
    	start=System.nanoTime();
    	elenco.reset();
    	txtResult.setText(null);
    	txtParola.setText(null);
    	txtTime.setText(null);
    	btnReset.setDisable(true);
    	end=System.nanoTime();
    	txtTime.setText("Tempo Reset= "+ (end-start));
    }
    

    @FXML
    void doCancella(ActionEvent event) {
    	start=System.nanoTime();
    	for (h=0; h<elenco.getElenco().size(); h++) {
    		if (elenco.getElenco().get(h).compareTo(txtParola.getText())==0) {
    			elenco.getElenco().remove(h); 
    			h=-1; 
    		}
 
    	}
    	txtResult.setText(elenco.getElenco().toString());
    	end=System.nanoTime();
    	txtTime.setText("Tempo Cancella= "+ (end-start));
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
    }
}
