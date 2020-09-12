package frontend;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class CreateRequest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("STuINDER");
		AnchorPane root = new AnchorPane();
		
		Label selCorLabel = new Label("Select a course:");
		Button c591 = new Button("591");
		
		HBox header = new HBox(selCorLabel);
		header.setMinSize(500, 100);
		header.setAlignment(Pos.CENTER);
		root.getChildren().add(header);
		HBox options = new HBox(c591);
		options.setAlignment(Pos.CENTER);
		options.setMinSize(500, 200);
		root.getChildren().add(options);
		
		AnchorPane.setTopAnchor(header, 5.0);
		AnchorPane.setBottomAnchor(options, 5.0);
		
		
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
		System.out.println("Hello");
	}

}
