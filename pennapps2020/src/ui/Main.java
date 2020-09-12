package ui;//package ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    //creating a Group object
    BorderPane root = new BorderPane();

    HBox buttonBox = new HBox();


    //create button
    Button Bt591 = new Button();
    Bt591.setText("591");

    // Create Exit Application button
    Button ExitBtn = new Button();
    ExitBtn.setText("Exit Application");
    // Define Action for Button
    ExitBtn.setOnAction(e -> Platform.exit());

    // Centrally align buttons
    buttonBox.setAlignment(Pos.CENTER);

    // Add Buttons to hbox node
    buttonBox.getChildren().addAll(Bt591,ExitBtn);

    root.setCenter(buttonBox);



    //Creating a Scene by passing the group object, height and width
    Scene scene = new Scene(root ,600, 300);

    //setting color to the scene
    scene.setFill(Color.BROWN);

    //Setting the title to Stage.
    primaryStage.setTitle("Sample Application");

    //Adding the scene to Stage
    primaryStage.setScene(scene);

    //Displaying the contents of the stage
    primaryStage.show();
  }
  public static void main(String args[]){
    launch(args);
  }
}