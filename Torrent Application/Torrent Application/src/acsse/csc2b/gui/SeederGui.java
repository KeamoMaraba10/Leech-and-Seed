/**
 * 
 */
package acsse.csc2b.gui;

import java.io.File;
import java.util.ArrayList;

import acsse.csc2b.network.Seeder;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 */
public class SeederGui extends GridPane {
	
	Button sendListBtn = null;
	Button addToListBtn = null;
	FileChooser fc = null;
	Button addBtn = null;
	TextArea fileListTxt = null;
	private ArrayList<File> filesToShare;
	private ArrayList<String> listOfFile;
	//private ListView<String> fileListView;
	private TextArea fileListView = null;
	private Seeder seed;
	
	
	public SeederGui(Stage primaryStage) {
		
		filesToShare = new ArrayList<>();
		//fileListView = new ListView<>();
		fileListView = new TextArea();
		listOfFile = new ArrayList<>();
		
		addToListBtn = new Button("Send a file");
		sendListBtn = new Button("Send a list of files");
		addBtn = new Button("Add a file");
		//seed = new Seeder(2323);
		
		
		this.add(addBtn, 0, 0);
		
		
		this.add(fileListView, 0, 1);//change this back to fileListTxt if problems occure
		
		addBtn.setOnAction( e ->{
			
			//Set on action for fcBtn
			fc = new FileChooser();
			
			fc.setTitle("Upload");
			
			fc.setInitialDirectory(new File("data"));
			
			File file = fc.showOpenDialog(primaryStage);
			if(file != null) {
				
				listOfFile.add(file.getName());
				//seed.addFile(file);//add the file to the list
				
				
				
			
				//fileListView.appendText(seed.getFileList().indexOf(file)+" "+file.getName()+"\n");// show the name of the file and it's index
				
				//System.out.print(listOfFile.indexOf(file));
				fileListView.appendText(listOfFile.indexOf(file.getName())+" "+file.getName()+"\n");

				
				
				
			
			}
			
		});
		
		//this needs to send the whole list available to the leecher
		sendListBtn.setOnAction( e ->{
			
			
			//seed.showList();
			byte[] sendData = fileListView.getText().getBytes();
			
			//seed.sendData(sendData);//send the actual list of files in bytes
			
			
		});
		
		
		
		
	}
	
	public String getFiles() {
		
		StringBuilder fileList = new StringBuilder();
		for(int i = 0; i < filesToShare.size(); i++) {
			fileList.append(i + 1).append(". ").append(filesToShare.get(i).getName()).append("\n");
		}
		
		return fileList.toString();
	}

}
