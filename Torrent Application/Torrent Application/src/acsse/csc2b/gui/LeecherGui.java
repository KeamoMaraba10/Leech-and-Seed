/**
 * 
 */
package acsse.csc2b.gui;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

import acsse.csc2b.network.Leecher;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * 
 */
public class LeecherGui extends GridPane {
	
	TextField hostTxt = null;
	TextField portTxt = null;
	Button connectBtn = null;
	Button retrieveBtn = null;
	Alert alert = null;
	
	//private ListView<String> fileListView;
	
	
	Button saveBtn = null;
	Label hostLbl = null;
	Label portLbl = null;
	String response = null;
	Alert responseAlt = null;
	Button requestBtn = null;
	TextArea listOfFiles = null;
	TextField txtIndexOfFile = null;
	ArrayList<String> fileList = null;
	ArrayList<File> filesAsList = null;
	
	Leecher leecher;
	public LeecherGui() {
		
		hostTxt = new TextField();
		portTxt = new TextField();
		connectBtn = new Button("Connect");
		requestBtn = new Button("Request list of files");
		listOfFiles = new TextArea();
		txtIndexOfFile = new TextField();
		
		connectBtn.setOnAction(e -> {
			
	
			//leecher =new Leecher(hostTxt.getText(), Integer.parseInt(portTxt.getText()));
			
				//create the leecher
				leecher = new Leecher(hostTxt.getText(),Integer.parseInt(portTxt.getText()));
				
				if(leecher != null) {
					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Success!");
					alert.setContentText("We have successfully connected");
					alert.showAndWait();
				}
				
				
			
			
		});
		
		requestBtn.setOnAction(e -> {
			
			//fileList = leecher.requestListOfFiles();
			
			filesAsList = leecher.requestListOfFiles();
			
				for(int i = 0; i < filesAsList.size();i++) {
					listOfFiles.appendText(filesAsList.get(i).getName());
				}
		});
		
		
		
		retrieveBtn = new Button("Retrieve by index");
		saveBtn = new Button("Save");
		hostLbl = new Label("Host");
		portLbl = new Label("Port");
		
		
		
		//Connection details line
		this.add(hostLbl,0, 0);
		this.add(hostTxt, 1, 0);
		
		this.add(portLbl, 0,1);
		this.add(portTxt,1,1);
		
		
		this.add(connectBtn, 0, 2);
		
		
		//save and retrieve actions
		this.add(requestBtn ,0,3);
		this.add(listOfFiles, 1, 3);
		this.add(retrieveBtn, 0, 4);
		this.add(txtIndexOfFile, 1, 4);
		this.add(saveBtn, 0, 5);
		
		
		

		
		
		
		
	}

	

}
