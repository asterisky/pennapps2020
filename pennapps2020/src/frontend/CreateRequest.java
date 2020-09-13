package frontend;

import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;

public class CreateRequest extends Application implements EventHandler{
	
	Stage window;
	Scene selCourse, userInfo, selTimes;

	
	@Override
	public void start(Stage primaryStage) throws Exception{
		//set up the window and pane (grid for objects)
		window = primaryStage;
		primaryStage.setTitle("STuINDER");
		
		//create scenes
		setCourseSel();
		setUserInfo();
		setSelTimes();
		
		//add the pane to the scene
		primaryStage.setScene(selTimes);
		primaryStage.show();
	}

	protected void setCourseSel() {
		/*
		 * SECTION: select course page
		 */
		//root is select course page
		GridPane root = new GridPane();
		root.setMinSize(500, 500);
		root.setPadding(new Insets(25,25,25,25));
		root.setVgap(10);
		root.setHgap(10);
		
		//create labels and buttons
		Label selCorLabel = new Label("Select a course:");
		selCorLabel.setFont(Font.font("Arial", 30));
		selCorLabel.setTextFill(Color.BLUE);
		
		//event handler for button click
		EventHandler<ActionEvent> buttonClick = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
					window.setScene(userInfo);
				
			}
		};
		
		Button c591 = new Button("591");
		c591.setMinSize(65,50);
		c591.setFont(Font.font("Arial", 22));
		c591.setOnAction(buttonClick);
		
		Button c592 = new Button("592");
		c592.setMinSize(65,50);
		c592.setFont(Font.font("Arial", 22));
		c592.setOnAction(buttonClick);
		
		Button c593 = new Button("593 <3");
		c593.setMinSize(65,50);
		c593.setFont(Font.font("Arial", 22));
		c593.setOnAction(buttonClick);
		
		Button c594 = new Button("594");
		c594.setMinSize(65,50);
		c594.setFont(Font.font("Arial", 22));
		c594.setOnAction(buttonClick);
		
		Button c595 = new Button("595");
		c595.setMinSize(65,50);
		c595.setFont(Font.font("Arial", 22));
		c595.setOnAction(buttonClick);
		
		Button c596 = new Button("596");
		c596.setMinSize(65,50);
		c596.setFont(Font.font("Arial", 22));
		c596.setOnAction(buttonClick);
			
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
		
		selCourse = new Scene(root);
	}
	
	protected void setUserInfo() {
		//page to request user info
		//set up pane
		GridPane uInfo = new GridPane();
		uInfo.setMinSize(500, 500);
		uInfo.setPadding(new Insets(25,25,25,25));
		uInfo.setVgap(10);
		uInfo.setHgap(10);
		
		//set buttons and labels
		Label getInfo = new Label("  We need some information " + "\n" + "to help find you a study group.");
		getInfo.setFont(Font.font("Arial", 25));
		getInfo.setTextFill(Color.BLUE);
		getInfo.setAlignment(Pos.CENTER);
		
		Label nameLabel = new Label("Name:  ");
		nameLabel.setFont(Font.font("Arial", 16));
		TextField nameField = new TextField();
		nameField.setMaxWidth(350.00);
		
		Label emailLabel = new Label("Email: ");
		emailLabel.setFont(Font.font("Arial", 16));
		TextField emailField = new TextField();
		emailField.setMaxWidth(350.00);
		
		Label dropLabel = new Label("Time: ");
		dropLabel.setFont(Font.font("Arial", 16));
		ObservableList<String> timezones = FXCollections.observableArrayList(
			"Timezone1",
			"Timezone2",
			"Timezone3"
		);
		ComboBox timeDropdown = new ComboBox(timezones);
		
		//event handler for button click
		EventHandler<ActionEvent> buttonClick = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
					window.setScene(selCourse);
				
			}
		};
		Button submitInfo = new Button("next");
		submitInfo.setMinSize(65,50);
		submitInfo.setFont(Font.font("Arial", 22));
		submitInfo.setOnAction(buttonClick);
		
		//add elements to layout
		uInfo.add(getInfo, 1, 0);
		uInfo.add(nameLabel, 0, 2);
		uInfo.add(nameField, 1, 2);
		uInfo.add(emailLabel, 0, 3);
		uInfo.add(emailField, 1, 3);
		uInfo.add(dropLabel, 0, 4);
		uInfo.add(timeDropdown, 1, 4);
		uInfo.add(submitInfo, 1, 6);
		
		
		
		userInfo = new Scene(uInfo);

	}
	
	protected void setSelTimes() {
		//page to request user info
		//set up pane
		
		GridPane calendar = new GridPane();
		calendar.setMinSize(500, 500);
		calendar.setVgap(10);
		calendar.setHgap(10);
		
//		//set buttons and labels
//		Text getInfo = new Text("Please indicate your availability for the next week:");
//		getInfo.setFont(Font.font("Arial", 25));
//		getInfo.setFill(Color.BLUE);
//		Pane heading = new Pane(getInfo);
//		StackPane rootPane = new StackPane();
//		selTimes = new Scene(rootPane);
//		rootPane.getChildren().add(heading);

		
		//calendar.add(getInfo, 1, 0);
		for(int i = 0; i < 24; i++) {
			Label calHour;
			if(i < 12) {
			String hour = Integer.toString(i + 1);
			calHour = new Label(hour + "am");
			}
			else {
			String hour = Integer.toString(i - 11);
			calHour = new Label(hour + "pm");
			}
			calendar.add(calHour, i+1, 1);
		}
		char[] daysOfWeek = new char[] {'S','M','T','W','T','F','S'};
		for(int i = 0; i < 7; i++) {
			String dayLabel = Character.toString(daysOfWeek[i]);
			Text day = new Text(dayLabel);
			calendar.add(day, 0, i + 2);
			for(int j = 1; j < 25; j++) {
				CheckBox checkBox = new CheckBox();
				
				checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {


					@Override
					public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
							Boolean newValue) {
						if(newValue) {
							System.out.println("ok");
						}
						if(!newValue) {
							System.out.println("ko");
						}
					}
				});
				
				
				calendar.add(checkBox, j, i +2);
			}
		}
		
		
		selTimes = new Scene(calendar);
				
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		
	}

}
