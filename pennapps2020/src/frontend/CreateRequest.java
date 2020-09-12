package frontend;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.*;

public class CreateRequest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception{
		//set up the window and pane (grid for objects)
		primaryStage.setTitle("STuINDER");
		AnchorPane root = new AnchorPane();
		
		//create labels and buttons
		Label selCorLabel = new Label("Select a course:");
		selCorLabel.setFont(Font.font("Arial", 30));
		selCorLabel.setTextFill(Color.BLUE);
		
		Button c591 = new Button("591");
		c591.setMinSize(25,20);
		c591.setFont(Font.font("Arial", 16));
		
		Button c592 = new Button("592");
		c592.setMinSize(25,20);
		c592.setFont(Font.font("Arial", 16));
		
		
		//set properties of labels and buttons
		HBox header = new HBox(selCorLabel);
		header.setMinSize(500, 100);
		header.setAlignment(Pos.CENTER);
		root.getChildren().add(header);
		
		HBox options = new HBox(c591);
		options.getChildren().add(c592);
		options.setAlignment(Pos.CENTER);
		options.setMinSize(500, 200);
		root.getChildren().add(options);
		
		//place labels and buttons in the pane
		AnchorPane.setTopAnchor(header, 5.0);
		AnchorPane.setBottomAnchor(options, 100.0);;
		
		//add the pane to the scene
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
		System.out.println("Hello");
	}

}
