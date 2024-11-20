import java.io.File;
import java.util.ArrayList;

import acsse.csc2b.gui.LeecherGui;
import acsse.csc2b.gui.SeederGui;
import acsse.csc2b.network.Leecher;
import acsse.csc2b.network.Seeder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main  extends Application{
	
	
	LeecherGui leecher = new LeecherGui();
	
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
		
		//select mode
		//make mode 
	}

	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		SeederGui seeder = new SeederGui(arg0);
		 // Create a ToggleButton (acts as a switch)
        ToggleButton toggleButton = new ToggleButton("START");
        
        // Create a label to display the toggle state
        Label label = new Label();
        
        
        VBox layout = new VBox(10,label, toggleButton );
        
        //layout.getChildren().add(seeder);
        // Set up an event handler for the toggle button
        toggleButton.setOnAction(event -> {
            if (toggleButton.isSelected()) {
            	//We are in seeder mode
            	
            	
            	
            	
            	
                toggleButton.setText("Switch to leecher");
                label.setText("You are in Seeder mode");
                
                layout.getChildren().remove(leecher);
                if(!layout.getChildren().contains(seeder)) {
                	layout.getChildren().add(seeder);

                    //#ec7c32 - orange
                    //#6eac49 - green
                	layout.setStyle("-fx-background-color : #6eac49;");
                	
                	
                	
                }
                
             
            } else {
            	
            	//LeecherGui leecher = new LeecherGui();
                toggleButton.setText("Switch to seeder");
                label.setText("You are in Leecher mode");
                
                layout.getChildren().remove(seeder);
                if(!layout.getChildren().contains(leecher)) {
                	layout.getChildren().add(leecher);
                	layout.setStyle("-fx-background-color : #ec7c32;");
                	
                }
                
                
            
            
            }
        });
        
        // main layout
        
        
        
        // Set up the scene and stage
        //Add the gridpane you need when button is clicked
        
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        Scene scene = new Scene(layout, 600, 700);
        arg0.setScene(scene);
    
        arg0.setTitle("Torrent Application");
        arg0.show();
	}

}
