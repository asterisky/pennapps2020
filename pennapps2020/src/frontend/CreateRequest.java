package frontend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import data.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;

public class CreateRequest extends Application implements EventHandler{

	Stage window;
	Scene home, selCourse, userInfo, selTimes, submitted;
	String course;
	String name;
	String event;
	String email;
	int[][] timetable;

	@Override
	public void start(Stage primaryStage) throws Exception{
		//set up the window and pane (grid for objects)
		window = primaryStage;
		primaryStage.setTitle("STuINDER");

		//create scenes
		setHome();
		setCourseSel();
		setUserInfo();
		setSelTimes();
		setSubmitted();

		//add the pane to the scene
		primaryStage.setScene(home);
		primaryStage.show();
	}

	protected void setHome() throws FileNotFoundException {
		//page to request user info
		//set up pane
		GridPane splash = new GridPane();
		splash.setMinSize(500, 500);
		splash.setPadding(new Insets(25,25,25,25));
		splash.setVgap(10);
		splash.setHgap(10);


		//set buttons and labels
//		FileInputStream picStream = new FileInputStream("/pennapps2020/pennapps2020/src/logo.png");
//		Image image = new Image(picStream);
//		ImageView banner = new ImageView(image);

//		Group root = new Group(banner);
//		root.getChildren().add(splash);

		Label greeting = new Label("An app for finding and organizing a study group.");
		greeting.setFont(Font.font("Arial", 25));
		greeting.setTextFill(Color.BLUE);
		greeting.setAlignment(Pos.CENTER);


		//event handler for button click
		EventHandler<ActionEvent> buttonClick = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				window.setScene(selCourse);

			}
		};
		Button start = new Button("find a study group");
		start.setMinSize(65,50);
		start.setFont(Font.font("Arial", 22));
		start.setOnAction(buttonClick);

		//add elements to layout
		splash.add(greeting, 1, 0);
		splash.add(start, 1, 1);



		home = new Scene(splash);

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


		Button c591 = new Button("591");
		Button c592 = new Button("592");
		Button c593 = new Button("593");
		Button c594 = new Button("594");
		Button c595 = new Button("595");
		Button c596 = new Button("596");


		//event handler for button click
		EventHandler<ActionEvent> buttonClick = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String origin = "";
				Button source = (Button) e.getSource();
				origin=source.getText();
				//System.out.println(origin);
				course = origin; //set value
				window.setScene(userInfo);

			}
		};


		c591.setMinSize(65,50);
		c591.setFont(Font.font("Arial", 22));
		c591.setOnAction(buttonClick);


		c592.setMinSize(65,50);
		c592.setFont(Font.font("Arial", 22));
		c592.setOnAction(buttonClick);


		c593.setMinSize(65,50);
		c593.setFont(Font.font("Arial", 22));
		c593.setOnAction(buttonClick);


		c594.setMinSize(65,50);
		c594.setFont(Font.font("Arial", 22));
		c594.setOnAction(buttonClick);


		c595.setMinSize(65,50);
		c595.setFont(Font.font("Arial", 22));
		c595.setOnAction(buttonClick);


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

//		Label dropLabel = new Label("Time: ");
//		dropLabel.setFont(Font.font("Arial", 16));
//		ObservableList<String> timezones = FXCollections.observableArrayList(
//				"Timezone1",
//				"Timezone2",
//				"Timezone3"
//		);
//		ComboBox timeDropdown = new ComboBox(timezones);

		//event handler for button click
		EventHandler<ActionEvent> buttonClick = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
//				if(nameField.getText() != null && emailField.getText() != null && !nameField.getText().isEmpty() && !emailField.getText().isEmpty()) {
//					User newUser = new User(nameField.getText(), emailField.getText());
//					System.out.println("Collected new user " + newUser.getName() + " - email: " + newUser.getEmail());
//				}
				email = emailField.getText();
				name = nameField.getText();

				window.setScene(selTimes);

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
//		uInfo.add(dropLabel, 0, 4);
//		uInfo.add(timeDropdown, 1, 4);
		uInfo.add(submitInfo, 1, 6);



		userInfo = new Scene(uInfo);

	}

	protected void setSelTimes() {
		//page to request user info
		//set up pane

		GridPane calendar = new GridPane();
//		calendar.setMinSize(500, 500);
//		calendar.setVgap(10);
//		calendar.setHgap(10);
//
////		//set buttons and labels
////		Text getInfo = new Text("Please indicate your availability for the next week:");
////		getInfo.setFont(Font.font("Arial", 25));
////		getInfo.setFill(Color.BLUE);
////		Pane heading = new Pane(getInfo);
////		StackPane rootPane = new StackPane();
////		selTimes = new Scene(rootPane);
////		rootPane.getChildren().add(heading);
//
//
//		//calendar.add(getInfo, 1, 0);
//		for(int i = 0; i < 24; i++) {
//			Label calHour;
//			if(i < 12) {
//				String hour = Integer.toString(i + 1);
//				if(i == 11) {
//					calHour = new Label(hour + "pm");
//				}
//				else calHour = new Label(hour + "am");
//			}
//			else {
//				String hour = Integer.toString(i - 11);
//				if(i == 23) {
//					calHour = new Label(hour + "am");
//				}
//				else calHour = new Label(hour + "pm");
//			}
//			calendar.add(calHour, i+1, 1);
//		}
//		//adds each row
//		char[] daysOfWeek = new char[] {'S','M','T','W','T','F','S'};
//		for(int i = 0; i < 7; i++) {
//			String dayLabel = Character.toString(daysOfWeek[i]);
//			Text day = new Text(dayLabel);
//			calendar.add(day, 0, i + 2);
//			for(int j = 1; j < 25; j++) {
//				CheckBox checkBox = new CheckBox();
//
//				checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
//
//
//					@Override
//					public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
//							Boolean newValue) {
//						if(newValue) {
//							System.out.println("ok");
//						}
//						if(!newValue) {
//							System.out.println("ko");
//						}
//					}
//				});
//
//
//				calendar.add(checkBox, j, i +2);
//			}
//		}
//
//		//event handler for button click
//		EventHandler<ActionEvent> buttonClick = new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent e) {
//				window.setScene(submitted);
//
//			}
//		};
//		Button submitInfo = new Button("submit");
//		submitInfo.setMinSize(65,50);
//		submitInfo.setFont(Font.font("Arial", 22));
//		submitInfo.setOnAction(buttonClick);
//		calendar.add(submitInfo, 12, 26);
		// Weekdays

		ObservableList<Integer> items = FXCollections.observableArrayList(
				0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23);

		Label monday = new Label("Monday");
		ListView<Integer> listMon = new ListView<>(items);
	//	ListView<Integer> selectedMon = new ListView<>();
		// Create the Season VBox
		VBox mondaySelection = new VBox();
		// Set Spacing to 10 pixels
		mondaySelection.setSpacing(10);
		// Add the Label and the List to the VBox
		mondaySelection.getChildren().addAll(monday,listMon);
		//set this to SINGLE to allow selecting just one item
		listMon.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//		listMon.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->{
//			selectedMon.setItems(listMon.getSelectionModel().getSelectedItems());
//		});

		Label tuesday = new Label("Tuesday");
		ListView<Integer> listTue = new ListView<>(items);
//		ListView<Integer> selectedTue = new ListView<>();
		VBox tuesdaySelection = new VBox();
		// Set Spacing to 10 pixels
		tuesdaySelection.setSpacing(10);
		// Add the Label and the List to the VBox
		tuesdaySelection.getChildren().addAll(tuesday,listTue);
		listTue.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//		listTue.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->{
//			selectedTue.setItems(listTue.getSelectionModel().getSelectedItems());
//		});

		Label wednesday = new Label("Wednesday");
		ListView<Integer> listWed = new ListView<>(items);
		ListView<Integer> selectedWed = new ListView<>();
		VBox wednesdaySelection = new VBox();
		// Set Spacing to 10 pixels
		wednesdaySelection.setSpacing(10);
		// Add the Label and the List to the VBox
		wednesdaySelection.getChildren().addAll(wednesday,listWed);
		listWed.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//		listWed.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->{
//			selectedWed.setItems(listWed.getSelectionModel().getSelectedItems());
//		});

		Label thursday = new Label("Thursday");
		ListView<Integer> listThu = new ListView<>(items);
	//	ListView<Integer> selectedThu = new ListView<>();
		VBox thursdaySelection = new VBox();
		// Set Spacing to 10 pixels
		thursdaySelection.setSpacing(10);
		// Add the Label and the List to the VBox
		thursdaySelection.getChildren().addAll(thursday,listThu);
		listThu.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//		listThu.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->{
//			selectedThu.setItems(listThu.getSelectionModel().getSelectedItems());
//		});

		Label friday = new Label("Friday");
		ListView<Integer> listFri = new ListView<>(items);
		ListView<Integer> selectedFri = new ListView<>();
		VBox fridaySelection = new VBox();
		// Set Spacing to 10 pixels
		fridaySelection.setSpacing(10);
		// Add the Label and the List to the VBox
		fridaySelection.getChildren().addAll(friday,listFri);
		listFri.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//		listFri.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->{
//			selectedFri.setItems(listFri.getSelectionModel().getSelectedItems());
//		});



		Label saturday = new Label("Saturday");
		ListView<Integer> listSat = new ListView<>(items);
	//	ListView<Integer> selectedSat = new ListView<>();
		VBox saturdaySelection = new VBox();
		// Set Spacing to 10 pixels
		saturdaySelection.setSpacing(10);
		// Add the Label and the List to the VBox
		saturdaySelection.getChildren().addAll(saturday,listSat);
		listSat.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//		listSat.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->{
//			selectedSat.setItems(listSat.getSelectionModel().getSelectedItems());
//		});

		Label sunday = new Label("Saturday");
		ListView<Integer> listSun = new ListView<>(items);
		//ListView<Integer> selectedSun = new ListView<>();
		VBox sundaySelection = new VBox();
		// Set Spacing to 10 pixels
		sundaySelection.setSpacing(10);
		// Add the Label and the List to the VBox
		sundaySelection.getChildren().addAll(sunday,listSun);
		listSun.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//		listSun.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->{
//			selectedSun.setItems(listSun.getSelectionModel().getSelectedItems());
//		});

		listMon.setMaxWidth(75);
		listMon.setPrefHeight(580);
		listTue.setMaxWidth(75);
		listTue.setPrefHeight(580);
		listWed.setMaxWidth(75);
		listWed.setPrefHeight(580);
		listThu.setMaxWidth(75);
		listThu.setPrefHeight(580);
		listFri.setMaxWidth(75);
		listFri.setPrefHeight(580);
		listSat.setMaxWidth(75);
		listSat.setPrefHeight(580);
		listSun.setMaxWidth(75);
		listSun.setPrefHeight(580);


		//event handler for button click
		EventHandler<ActionEvent> buttonClick = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				timetable = new int[7][24];
				HashMap<String,List<Integer>> hm = new HashMap<>();
				hm.put("mon",listMon.getSelectionModel().getSelectedItems());
				hm.put("tue",listTue.getSelectionModel().getSelectedItems());
				hm.put("wed",listWed.getSelectionModel().getSelectedItems());
				hm.put("thu",listThu.getSelectionModel().getSelectedItems());
				hm.put("fri",listFri.getSelectionModel().getSelectedItems());
				hm.put("sat",listSat.getSelectionModel().getSelectedItems());
				hm.put("sun",listSun.getSelectionModel().getSelectedItems());

				int rowIdx = 0;
				for(String key : hm.keySet()){
					for(Integer j: hm.get(key)){
						timetable[rowIdx][j] = 1;
					}
					rowIdx++;
				}

				window.setScene(submitted);

			}
		};

		Button submitInfo = new Button("submit");
		submitInfo.setMinSize(65,50);
		submitInfo.setFont(Font.font("Arial", 22));
		submitInfo.setOnAction(buttonClick);

		HBox root = new HBox(mondaySelection, tuesdaySelection, wednesdaySelection, thursdaySelection
				, fridaySelection, saturdaySelection, sundaySelection);

		Text getInfo = new Text("Please indicate available times:");
	  getInfo.setFont(Font.font("Arial", 25));
    getInfo.setFill(Color.BLUE);

		BorderPane pane = new BorderPane();
		pane.setTop(getInfo);
		pane.setCenter(root);
		pane.setBottom(submitInfo);
		pane.setAlignment(submitInfo,Pos.CENTER);

		selTimes = new Scene(pane);

	}

	protected void setSubmitted(){
		//page to request user info
		//set up pane
		GridPane splash = new GridPane();
		splash.setMinSize(500, 500);
		splash.setPadding(new Insets(25,25,25,25));
		splash.setVgap(10);
		splash.setHgap(10);

		Label msg = new Label("Your request has been accepted!");
		msg.setFont(Font.font("Arial", 25));
		msg.setTextFill(Color.BLUE);
		msg.setAlignment(Pos.CENTER);
		splash.add(msg, 2, 0);

		//event handler for button click
		EventHandler<ActionEvent> buttonClick = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				window.setScene(home);

			}
		};

		Text text = new Text("Your study group request is being processed.  You'll get an email and suggested meeting time when a group is found." + "\n" + "Meanwhile, you can relax and freshen up before you study group & chill.");
		text.setFont(Font.font("Arial", 16));

		splash.add(text, 2, 1);
		Button end = new Button("awesome!");
		end.setMinSize(65,50);
		end.setFont(Font.font("Arial", 22));
		end.setOnAction(buttonClick);

		//add elements to layout

		splash.add(end, 2, 2);


		submitted = new Scene(splash);

	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub

	}

}
