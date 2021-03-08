package it.polito.tdp.lab0;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXMLController {

	private int tentativi = 3;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNome;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label txtTentativi;

    @FXML
    private Label txtRisultato;

    @FXML
    private Button btmClear;

    @FXML
    private Button btmAccedi;
    
    

    @FXML
    void doAccesso(ActionEvent event) {
    	
    	boolean verificato = true;
    	
    	txtRisultato.setText("");
    	
    	System.out.println("E' stato premuto il tasto 'Accedi'");
    	
    	String nome = txtNome.getText();
    	String password = txtPassword.getText();
    	
    	if((password.contains("!") || password.contains("?") || password.contains("@") || password.contains("#")) == false) {
    		txtRisultato.setText("ERRORE: inserire almeno un carattere speciale nella pw");
    		verificato = false;
    	}

    	if(password.toLowerCase().equals(password)) {
    		txtRisultato.setText("ERRORE: inserire almeno un carattere MAIUSCOLO nella pw");
    		verificato = false;
    	}

    	if( ( password.contains("0") || password.contains("1") || password.contains("2") || password.contains("3") || password.contains("4") || password.contains("5")
    			|| password.contains("6") || password.contains("7") || password.contains("8") || password.contains("9") ) == false ) {
    		txtRisultato.setText("ERRORE: inserire anche caratteri numerici nella pw");
    		verificato = false;
    	}

    	if(password.length() < 7) {
    		txtRisultato.setText("ERRORE: necessari almeno 7 caratteriper la password");
    		verificato = false;
    	}

    	if(nome.isEmpty()) {
    		txtRisultato.setText("ERRORE: inserire il nome utente");
    		txtPassword.setText("");
    		return;
    	}
    	else {
    		txtNome.setDisable(true);
    	}
    	
    	if(password.isEmpty()) {
    		txtRisultato.setText("ERRORE: inserire la password");
    		return;
    	}
    	
    	
    	
    	if(verificato) {
    		txtRisultato.setText("LOGIN EFFETTUATO ");
    	}
    	else {
    		
    		txtPassword.setText("");
    		tentativi = tentativi-1;
    		txtTentativi.setText("Tentativi rimanenti: "+tentativi);
    		
    		if(tentativi == 0) {
        		
        		btmClear.setDisable(false);
        		btmClear.setVisible(true);
        		
        		btmAccedi.setDisable(true);
        		
        		txtPassword.setDisable(true);
        	}
    		
    		return;
    	}
    	
    	
    }


    @FXML
    void doClear(ActionEvent event) {
    	
    	tentativi = 3;
    	
    	txtNome.setDisable(false);
    	txtPassword.setDisable(false);
    	
    	btmAccedi.setDisable(false);
    	btmClear.setDisable(true);
    	btmClear.setVisible(false);
    	
    	txtNome.setText("");
    	txtPassword.setText("");
    	txtTentativi.setText("");
    	txtRisultato.setText("");
    }

    @FXML
    void initialize() {
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmClear != null : "fx:id=\"btmClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmAccedi != null : "fx:id=\"btmAccedi\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
