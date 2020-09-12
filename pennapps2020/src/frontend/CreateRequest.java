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
		GridPane root = new GridPane();
		root.setMinSize(500, 500);
		root.setPadding(new Insets(25,25,25,25));
		root.setVgap(10);
		root.setHgap(10);
		
		//create labels and buttons
		Label selCorLabel = new Label("Select a course:");
		selCorLabel.setFont(Font.font("Arial", 30));
		selCorLabel.setTextFill(Color.BLUE);
		
		Button c591 = new Button("591");
		c591.setMinSize(65,50);
		c591.setFont(Font.font("Arial", 22));
		
		Button c592 = new Button("592");
		c592.setMinSize(65,50);
		c592.setFont(Font.font("Arial", 22));
		
		Button c593 = new Button("593 <3");
		c593.setMinSize(65,50);
		c593.setFont(Font.font("Arial", 22));
		
		Button c594 = new Button("594");
		c594.setMinSize(65,50);
		c594.setFont(Font.font("Arial", 22));
		
		Button c595 = new Button("595");
		c595.setMinSize(65,50);
		c595.setFont(Font.font("Arial", 22));
		
		Button c596 = new Button("596");
		c596.setMinSize(65,50);
		c596.setFont(Font.font("Arial", 22));
		
		
		//set properties of labels and buttons
		HBox header = new HBox(selCorLabel);
		header.setMinSize(500, 100);
		header.setAlignment(Pos.CENTER);
		root.add(header, 1, 0);
		
		HBox optionsTopRow = new HBox(c591);
		optionsTopRow.getChildren().add(c592);
		optionsTopRow.getChildren().add(c593);
		optionsTopRow.setAlignment(Pos.CENTER);
		optionsTopRow.setMinSize(500, 100);
		optionsTopRow.setSpacing(25);
		
		HBox optionsBotRow = new HBox(c594);
		optionsBotRow.getChildren().add(c595);
		optionsBotRow.getChildren().add(c596);
		optionsBotRow.setAlignment(Pos.CENTER);
		optionsBotRow.setMinSize(500, 100);
		optionsBotRow.setSpacing(25);
		
		root.add(optionsTopRow, 1, 1);
		root.add(optionsBotRow, 1, 2);
		
		//place labels and buttons in the pane
		root.setAlignment(Pos.CENTER);

		
		//add the pane to the scene
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
		System.out.println("Hello");
	}

}
