/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managequiz;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author paulo
 */
public class ManageQuiz extends Application {
    
    Stage thestage;
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
        
        thestage = primaryStage;
        
        Scene manageScene = manageQuizScene();
        
        primaryStage.setTitle("Quiz Management");
        primaryStage.setScene(manageScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void ButtonClicked0(ActionEvent e) throws IOException {
        Scene firstScene = firstTopicScene();
        thestage.setScene(firstScene);
        
        Alert informationAlert = new Alert(AlertType.INFORMATION);
        informationAlert.setTitle("Quiz Management");
        informationAlert.setHeaderText("Quiz Management instructions");
        informationAlert.setContentText("Please include the correct answer to each question in the green text boxes.");

        informationAlert.showAndWait();
    }
    
    public void ButtonClicked1(ActionEvent e) throws IOException {
        Scene secondScene = secondTopicScene();
        thestage.setScene(secondScene);
        
        Alert informationAlert = new Alert(AlertType.INFORMATION);
        informationAlert.setTitle("Quiz Management");
        informationAlert.setHeaderText("Quiz Management instructions");
        informationAlert.setContentText("Please include the correct answer to each question in the green text boxes.");

        informationAlert.showAndWait();
    }
    
    public void ButtonClicked2(ActionEvent e) throws IOException {
        Scene thirdScene = thirdTopicScene();
        thestage.setScene(thirdScene);
        
        Alert informationAlert = new Alert(AlertType.INFORMATION);
        informationAlert.setTitle("Quiz Management");
        informationAlert.setHeaderText("Quiz Management instructions");
        informationAlert.setContentText("Please include the correct answer to each question in the green text boxes.");

        informationAlert.showAndWait();
    }
    
    public void ButtonClicked3(ActionEvent e) throws IOException {
        Scene fourthScene = fourthTopicScene();
        thestage.setScene(fourthScene);
        
        Alert informationAlert = new Alert(AlertType.INFORMATION);
        informationAlert.setTitle("Quiz Management");
        informationAlert.setHeaderText("Quiz Management instructions");
        informationAlert.setContentText("Please include the correct answer to each question in the green text boxes.");

        informationAlert.showAndWait();
    }
    
    public void ButtonClicked4(ActionEvent e) throws IOException {
        Scene fifthScene = fifthTopicScene();
        thestage.setScene(fifthScene);
        
        Alert informationAlert = new Alert(AlertType.INFORMATION);
        informationAlert.setTitle("Quiz Management");
        informationAlert.setHeaderText("Quiz Management instructions");
        informationAlert.setContentText("Please include the correct answer to each question in the green text boxes.");

        informationAlert.showAndWait();
    }
    
    public void goBackButtonClicked(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void closeButtonClicked(ActionEvent e) {
        System.exit(0);
    }
    
    
    
    public ArrayList<Topic> getTopics(Topic topic0, Topic topic1, Topic topic2, Topic topic3, Topic topic4) throws FileNotFoundException, IOException{
        //create topic objects

        
        //create array for topics
        ArrayList<Topic> topics = new ArrayList<Topic>();
        
        //add topic objects to array
        topics.add(topic0);
        topics.add(topic1);
        topics.add(topic2);
        topics.add(topic3);
        topics.add(topic4);
        
        
        //iterate through files
        for (int i = 0; i < 5; i++){
            String file = "topic" + i + ".csv";
            
            CSVReader reader = new CSVReader(new FileReader(file));
            String [] name = reader.readNext();
            topics.get(i).name = name[0];
            
            String [] nextLine;
            while ((nextLine = reader.readNext()) != null) {
            //populate topic array with question objects
                topics.get(i).add(new Question(
                    nextLine[0],
                    nextLine[1],
                    nextLine[2],
                    nextLine[3],
                    nextLine[4]
                ));
            }
        }
        return topics;
    }
    
    public Scene manageQuizScene() throws IOException{
        Topic topic0 = new Topic();
        Topic topic1 = new Topic(); 
        Topic topic2 = new Topic();
        Topic topic3 = new Topic();
        Topic topic4 = new Topic();
        
        ArrayList<Topic> topics = getTopics(topic0, topic1, topic2, topic3, topic4);
        
        //create  main display 
        BorderPane root = new BorderPane();
        
        VBox vbox = new VBox(15);
        HBox hbox = new HBox(5);
        
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Text titleText = new Text();
        titleText.setEffect(ds);
        titleText.setCache(true);
        titleText.setX(10.0f);
        titleText.setY(270.0f);
        titleText.setFill(Color.BLACK);
        titleText.setText("Quiz Management");
        titleText.setFont(Font.font(null, FontWeight.BOLD, 38));
        
        Text topicsText = new Text();
        topicsText.setEffect(ds);
        topicsText.setCache(true);
        topicsText.setX(10.0f);
        topicsText.setY(270.0f);
        topicsText.setFill(Color.BLACK);
        topicsText.setText("Topics");
        topicsText.setFont(Font.font(null, FontWeight.BOLD, 24));
        
        Button buttonTopic0 = new Button(topic0.name);
        Button buttonTopic1 = new Button(topic1.name);
        Button buttonTopic2 = new Button(topic2.name);
        Button buttonTopic3 = new Button(topic3.name);
        Button buttonTopic4 = new Button(topic4.name);
        
        Button goBackButton = new Button("Main Menu");
        Button closeButton = new Button("Close");
        
        buttonTopic0.setOnAction(e-> {
            try {
                ButtonClicked0(e);
            } catch (IOException ex) {
                Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        buttonTopic1.setOnAction(e-> {
            try {
                ButtonClicked1(e);
            } catch (IOException ex) {
                Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        buttonTopic2.setOnAction(e-> {
            try {
                ButtonClicked2(e);
            } catch (IOException ex) {
                Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        buttonTopic3.setOnAction(e-> {
            try {
                ButtonClicked3(e);
            } catch (IOException ex) {
                Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        buttonTopic4.setOnAction(e-> {
            try {
                ButtonClicked4(e);
            } catch (IOException ex) {
                Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        goBackButton.setOnAction(e-> {
            // go back to main menu code here.
            goBackButtonClicked(e);
        });
        
        closeButton.setOnAction(e-> {
            // go back to main menu code here.
            closeButtonClicked(e);
        });

        
        buttonTopic0.setPrefWidth(200);
        buttonTopic1.setPrefWidth(200);
        buttonTopic2.setPrefWidth(200);
        buttonTopic3.setPrefWidth(200);
        buttonTopic4.setPrefWidth(200);
        
        goBackButton.setPrefWidth(100);
        closeButton.setPrefWidth(100);
        
        vbox.getChildren().addAll(
                titleText,
                topicsText,
                buttonTopic0,
                buttonTopic1,
                buttonTopic2,
                buttonTopic3,
                buttonTopic4
        );
        
        VBox.setMargin(titleText, new Insets(70));
        VBox.setMargin(topicsText, new Insets(10, 10, 30, 10));
        
        hbox.getChildren().addAll(
                goBackButton,
                closeButton
        );
        
        root.setBottom(hbox);
        HBox.setMargin(goBackButton, new Insets(10, 5, 50, 10));
        HBox.setMargin(closeButton, new Insets(10, 50, 50, 10));
        hbox.setAlignment(Pos.BOTTOM_RIGHT);

        root.setCenter(vbox);
        vbox.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(vbox, Pos.CENTER);
        
        
        Image img = new Image("background.jpg");
        BackgroundImage bgImg = new BackgroundImage(img, 
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.DEFAULT, 
        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        root.setBackground(new Background(bgImg));
        
        return new Scene(root, 1200, 800);
    }
    
    
    public Scene firstTopicScene() throws IOException{
        Topic topic0 = new Topic();
        Topic topic1 = new Topic(); 
        Topic topic2 = new Topic();
        Topic topic3 = new Topic();
        Topic topic4 = new Topic();
        
        ArrayList<Topic> topics = getTopics(topic0, topic1, topic2, topic3, topic4);
        
        //create second scene
        ScrollPane root0 = new ScrollPane();
        
        GridPane gridpane = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(25);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(25);
        gridpane.getColumnConstraints().addAll(column1, column2, column3, column4);
        
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(15);
        gridpane.setVgap(5);
        
        
        TextField topicTitle = new TextField(topic0.name);
        Label topicLabel = new Label("Topic Title:");
        topicLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(topicLabel, HPos.RIGHT);
        gridpane.add(topicLabel, 0, 0, 1, 1);
        
        Label label0 = new Label("Question 1:");
        label0.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label0, HPos.RIGHT);
        gridpane.add(label0, 0, 2, 1, 1);
        
        TextField question0 = new TextField(topic0.questions.get(0).question);
        TextField answer0 = new TextField(topic0.questions.get(0).answer);
        TextField incorrect1_0 = new TextField(topic0.questions.get(0).incorrect1);
        TextField incorrect2_0 = new TextField(topic0.questions.get(0).incorrect2);
        TextField incorrect3_0 = new TextField(topic0.questions.get(0).incorrect3);
        
        answer0.setStyle("-fx-border-color: green;");
        
        gridpane.add(topicTitle, 1, 0, 2, 1);
        gridpane.add(question0, 1, 2, 2, 1);
        gridpane.add(answer0, 0, 3, 1, 1);
        gridpane.add(incorrect1_0, 1, 3, 1, 1);
        gridpane.add(incorrect2_0, 2, 3, 1, 1);
        gridpane.add(incorrect3_0, 3, 3, 1, 1);
        
        Label label1 = new Label("Question 2:");
        label1.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label1, HPos.RIGHT);
        gridpane.add(label1, 0, 5, 1, 1);
        
        TextField question1 = new TextField(topic0.questions.get(1).question);
        TextField answer1 = new TextField(topic0.questions.get(1).answer);
        TextField incorrect1_1 = new TextField(topic0.questions.get(1).incorrect1);
        TextField incorrect2_1 = new TextField(topic0.questions.get(1).incorrect2);
        TextField incorrect3_1 = new TextField(topic0.questions.get(1).incorrect3);
        
        answer1.setStyle("-fx-border-color: green;");
        
        gridpane.add(question1, 1, 5, 2, 1);
        gridpane.add(answer1, 0, 6, 1, 1);
        gridpane.add(incorrect1_1, 1, 6, 1, 1);
        gridpane.add(incorrect2_1, 2, 6, 1, 1);
        gridpane.add(incorrect3_1, 3, 6, 1, 1);
        
        Label label2 = new Label("Question 3:");
        GridPane.setHalignment(label2, HPos.RIGHT);
        label2.setStyle("-fx-font-weight: bold;");
        gridpane.add(label2, 0, 8, 1, 1);
        
        TextField question2 = new TextField(topic0.questions.get(2).question);
        TextField answer2 = new TextField(topic0.questions.get(2).answer);
        TextField incorrect1_2 = new TextField(topic0.questions.get(2).incorrect1);
        TextField incorrect2_2 = new TextField(topic0.questions.get(2).incorrect2);
        TextField incorrect3_2 = new TextField(topic0.questions.get(2).incorrect3);
        
        answer2.setStyle("-fx-border-color: green;");
        
        gridpane.add(question2, 1, 8, 2, 1);
        gridpane.add(answer2, 0, 9, 1, 1);
        gridpane.add(incorrect1_2, 1, 9, 1, 1);
        gridpane.add(incorrect2_2, 2, 9, 1, 1);
        gridpane.add(incorrect3_2, 3, 9, 1, 1);
        
        Label label3 = new Label("Question 4:");
        label3.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label3, HPos.RIGHT);
        gridpane.add(label3, 0, 11, 1, 1);
        
        TextField question3 = new TextField(topic0.questions.get(3).question);
        TextField answer3 = new TextField(topic0.questions.get(3).answer);
        TextField incorrect1_3 = new TextField(topic0.questions.get(3).incorrect1);
        TextField incorrect2_3 = new TextField(topic0.questions.get(3).incorrect2);
        TextField incorrect3_3 = new TextField(topic0.questions.get(3).incorrect3);
        
        answer3.setStyle("-fx-border-color: green;");
        
        gridpane.add(question3, 1, 11, 2, 1);
        gridpane.add(answer3, 0, 12, 1, 1);
        gridpane.add(incorrect1_3, 1, 12, 1, 1);
        gridpane.add(incorrect2_3, 2, 12, 1, 1);
        gridpane.add(incorrect3_3, 3, 12, 1, 1);
        
        Label label4 = new Label("Question 5:");
        label4.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label4, HPos.RIGHT);
        gridpane.add(label4, 0, 14, 1, 1);
        
        TextField question4 = new TextField(topic0.questions.get(4).question);
        TextField answer4 = new TextField(topic0.questions.get(4).answer);
        TextField incorrect1_4 = new TextField(topic0.questions.get(4).incorrect1);
        TextField incorrect2_4 = new TextField(topic0.questions.get(4).incorrect2);
        TextField incorrect3_4 = new TextField(topic0.questions.get(4).incorrect3);
        
        answer4.setStyle("-fx-border-color: green;");
        
        gridpane.add(question4, 1, 14, 2, 1);
        gridpane.add(answer4, 0, 15, 1, 1);
        gridpane.add(incorrect1_4, 1, 15, 1, 1);
        gridpane.add(incorrect2_4, 2, 15, 1, 1);
        gridpane.add(incorrect3_4, 3, 15, 1, 1);
        
        Label label5 = new Label("Question 6:");
        label5.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label5, HPos.RIGHT);
        gridpane.add(label5, 0, 17, 1, 1);
        
        TextField question5 = new TextField(topic0.questions.get(5).question);
        TextField answer5 = new TextField(topic0.questions.get(5).answer);
        TextField incorrect1_5 = new TextField(topic0.questions.get(5).incorrect1);
        TextField incorrect2_5 = new TextField(topic0.questions.get(5).incorrect2);
        TextField incorrect3_5 = new TextField(topic0.questions.get(5).incorrect3);
        
        answer5.setStyle("-fx-border-color: green;");
        
        gridpane.add(question5, 1, 17, 2, 1);
        gridpane.add(answer5, 0, 18, 1, 1);
        gridpane.add(incorrect1_5, 1, 18, 1, 1);
        gridpane.add(incorrect2_5, 2, 18, 1, 1);
        gridpane.add(incorrect3_5, 3, 18, 1, 1);
        
        Label label6 = new Label("Question 7:");
        label6.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label6, HPos.RIGHT);
        gridpane.add(label6, 0, 20, 1, 1);
        
        TextField question6 = new TextField(topic0.questions.get(6).question);
        TextField answer6 = new TextField(topic0.questions.get(6).answer);
        TextField incorrect1_6 = new TextField(topic0.questions.get(6).incorrect1);
        TextField incorrect2_6 = new TextField(topic0.questions.get(6).incorrect2);
        TextField incorrect3_6 = new TextField(topic0.questions.get(6).incorrect3);
        
        answer6.setStyle("-fx-border-color: green;");
        
        gridpane.add(question6, 1, 20, 2, 1);
        gridpane.add(answer6, 0, 21, 1, 1);
        gridpane.add(incorrect1_6, 1, 21, 1, 1);
        gridpane.add(incorrect2_6, 2, 21, 1, 1);
        gridpane.add(incorrect3_6, 3, 21, 1, 1);
        
        Label label7 = new Label("Question 8:");
        label7.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label7, HPos.RIGHT);
        gridpane.add(label7, 0, 23, 1, 1);
        
        TextField question7 = new TextField(topic0.questions.get(7).question);
        TextField answer7 = new TextField(topic0.questions.get(7).answer);
        TextField incorrect1_7 = new TextField(topic0.questions.get(7).incorrect1);
        TextField incorrect2_7 = new TextField(topic0.questions.get(7).incorrect2);
        TextField incorrect3_7 = new TextField(topic0.questions.get(7).incorrect3);
        
        answer7.setStyle("-fx-border-color: green;");
        
        gridpane.add(question7, 1, 23, 2, 1);
        gridpane.add(answer7, 0, 24, 1, 1);
        gridpane.add(incorrect1_7, 1, 24, 1, 1);
        gridpane.add(incorrect2_7, 2, 24, 1, 1);
        gridpane.add(incorrect3_7, 3, 24, 1, 1);
        
        Label label8 = new Label("Question 9:");
        label8.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label8, HPos.RIGHT);
        gridpane.add(label8, 0, 26, 1, 1);
        
        TextField question8 = new TextField(topic0.questions.get(8).question);
        TextField answer8 = new TextField(topic0.questions.get(8).answer);
        TextField incorrect1_8 = new TextField(topic0.questions.get(8).incorrect1);
        TextField incorrect2_8 = new TextField(topic0.questions.get(8).incorrect2);
        TextField incorrect3_8 = new TextField(topic0.questions.get(8).incorrect3);
        
        answer8.setStyle("-fx-border-color: green;");
        
        gridpane.add(question8, 1, 26, 2, 1);
        gridpane.add(answer8, 0, 27, 1, 1);
        gridpane.add(incorrect1_8, 1, 27, 1, 1);
        gridpane.add(incorrect2_8, 2, 27, 1, 1);
        gridpane.add(incorrect3_8, 3, 27, 1, 1);
        
        Label label9 = new Label("Question 10:");
        label9.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label9, HPos.RIGHT);
        gridpane.add(label9, 0, 29, 1, 1);
        
        TextField question9 = new TextField(topic0.questions.get(9).question);
        TextField answer9 = new TextField(topic0.questions.get(9).answer);
        TextField incorrect1_9 = new TextField(topic0.questions.get(9).incorrect1);
        TextField incorrect2_9 = new TextField(topic0.questions.get(9).incorrect2);
        TextField incorrect3_9 = new TextField(topic0.questions.get(9).incorrect3);
        
        answer9.setStyle("-fx-border-color: green;");
        
        gridpane.add(question9, 1, 29, 2, 1);
        gridpane.add(answer9, 0, 30, 1, 1);
        gridpane.add(incorrect1_9, 1, 30, 1, 1);
        gridpane.add(incorrect2_9, 2, 30, 1, 1);
        gridpane.add(incorrect3_9, 3, 30, 1, 1);
        
        //add save and cancel buttons
        Button cancelButton = new Button("Cancel Changes");
        Button saveButton = new Button("Save Changes");
        
        cancelButton.setOnAction((ActionEvent e) -> {
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Quiz Management");
            confirmationAlert.setContentText("Discard changes?");
            
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.get() == ButtonType.OK){
                try {
                    Scene quizScene = manageQuizScene();
                    thestage.setScene(quizScene);
                } catch (IOException ex) {
                    Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        saveButton.setOnAction((ActionEvent e) -> {
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Quiz Management");
            confirmationAlert.setContentText("Save changes?");
            
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.get() == ButtonType.OK){
                try {
                    CSVWriter writer = new CSVWriter(new FileWriter("topic0.csv", false));
                    
                    String topicTitleValue[] = new String[] {topicTitle.getText()};
                
                    String q0Array[] = new String[] {
                        question0.getText(),
                        answer0.getText(),
                        incorrect1_0.getText(),
                        incorrect2_0.getText(),
                        incorrect3_0.getText()
                    };

                    String q1Array[] = new String[] {
                        question1.getText(),
                        answer1.getText(),
                        incorrect1_1.getText(),
                        incorrect2_1.getText(),
                        incorrect3_1.getText()
                    };
                    
                    String q2Array[] = new String[] {
                        question2.getText(),
                        answer2.getText(),
                        incorrect1_2.getText(),
                        incorrect2_2.getText(),
                        incorrect3_2.getText()
                    };

                    String q3Array[] = new String[] {
                        question3.getText(),
                        answer3.getText(),
                        incorrect1_3.getText(),
                        incorrect2_3.getText(),
                        incorrect3_3.getText()
                    };

                    String q4Array[] = new String[] {
                        question4.getText(),
                        answer4.getText(),
                        incorrect1_4.getText(),
                        incorrect2_4.getText(),
                        incorrect3_4.getText()
                    };

                    String q5Array[] = new String[] {
                        question5.getText(),
                        answer5.getText(),
                        incorrect1_5.getText(),
                        incorrect2_5.getText(),
                        incorrect3_5.getText()
                    };

                    String q6Array[] = new String[] {
                        question6.getText(),
                        answer6.getText(),
                        incorrect1_6.getText(),
                        incorrect2_6.getText(),
                        incorrect3_6.getText()
                    };

                    String q7Array[] = new String[] {
                        question7.getText(),
                        answer7.getText(),
                        incorrect1_7.getText(),
                        incorrect2_7.getText(),
                        incorrect3_7.getText()
                    };

                    String q8Array[] = new String[] {
                        question8.getText(),
                        answer8.getText(),
                        incorrect1_8.getText(),
                        incorrect2_8.getText(),
                        incorrect3_8.getText()
                    };

                    String q9Array[] = new String[] {
                        question9.getText(),
                        answer9.getText(),
                        incorrect1_9.getText(),
                        incorrect2_9.getText(),
                        incorrect3_9.getText()
                    };

                    writer.writeNext(topicTitleValue);
                    writer.writeNext(q0Array);
                    writer.writeNext(q1Array);
                    writer.writeNext(q2Array);
                    writer.writeNext(q3Array);
                    writer.writeNext(q4Array);
                    writer.writeNext(q5Array);
                    writer.writeNext(q6Array);
                    writer.writeNext(q7Array);
                    writer.writeNext(q8Array);
                    writer.writeNext(q9Array);
                    writer.close();
                    
                    Scene quizScene = manageQuizScene();
                    thestage.setScene(quizScene);
                    
                } catch (IOException ex) {
                    Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
                }

        }});
        
        cancelButton.setPrefWidth(200);
        saveButton.setPrefWidth(200);
        
        GridPane.setHalignment(cancelButton, HPos.RIGHT);
        
        gridpane.add(cancelButton, 2, 32, 1, 1);
        gridpane.add(saveButton, 3, 32, 1, 1);
        
        for (int i = 0; i <= 32; i++) {
            RowConstraints rowC = new RowConstraints();
            rowC.setPrefHeight(30);
            gridpane.getRowConstraints().add(rowC);
        }
        
        root0.setPrefSize(1200, 800);
        root0.setFitToWidth(true);
        root0.setContent(gridpane);
        
        return new Scene(root0, 1200, 800);
    }
    
    public Scene secondTopicScene() throws IOException{
        Topic topic0 = new Topic();
        Topic topic1 = new Topic(); 
        Topic topic2 = new Topic();
        Topic topic3 = new Topic();
        Topic topic4 = new Topic();
        
        ArrayList<Topic> topics = getTopics(topic0, topic1, topic2, topic3, topic4);
        
        //create second scene
        ScrollPane root0 = new ScrollPane();
        
        GridPane gridpane = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(25);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(25);
        gridpane.getColumnConstraints().addAll(column1, column2, column3, column4);
        
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(15);
        gridpane.setVgap(5);
        

        
        TextField topicTitle = new TextField(topic1.name);
        Label topicLabel = new Label("Topic Title:");
        topicLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(topicLabel, HPos.RIGHT);
        gridpane.add(topicLabel, 0, 0, 1, 1);
        
        Label label0 = new Label("Question 1:");
        label0.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label0, HPos.RIGHT);
        gridpane.add(label0, 0, 2, 1, 1);
        
        TextField question0 = new TextField(topic1.questions.get(0).question);
        TextField answer0 = new TextField(topic1.questions.get(0).answer);
        TextField incorrect1_0 = new TextField(topic1.questions.get(0).incorrect1);
        TextField incorrect2_0 = new TextField(topic1.questions.get(0).incorrect2);
        TextField incorrect3_0 = new TextField(topic1.questions.get(0).incorrect3);
        
        answer0.setStyle("-fx-border-color: green;");
        
        gridpane.add(topicTitle, 1, 0, 2, 1);
        gridpane.add(question0, 1, 2, 2, 1);
        gridpane.add(answer0, 0, 3, 1, 1);
        gridpane.add(incorrect1_0, 1, 3, 1, 1);
        gridpane.add(incorrect2_0, 2, 3, 1, 1);
        gridpane.add(incorrect3_0, 3, 3, 1, 1);
        
        Label label1 = new Label("Question 2:");
        label1.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label1, HPos.RIGHT);
        gridpane.add(label1, 0, 5, 1, 1);
        
        TextField question1 = new TextField(topic1.questions.get(1).question);
        TextField answer1 = new TextField(topic1.questions.get(1).answer);
        TextField incorrect1_1 = new TextField(topic1.questions.get(1).incorrect1);
        TextField incorrect2_1 = new TextField(topic1.questions.get(1).incorrect2);
        TextField incorrect3_1 = new TextField(topic1.questions.get(1).incorrect3);
        
        answer1.setStyle("-fx-border-color: green;");
        
        gridpane.add(question1, 1, 5, 2, 1);
        gridpane.add(answer1, 0, 6, 1, 1);
        gridpane.add(incorrect1_1, 1, 6, 1, 1);
        gridpane.add(incorrect2_1, 2, 6, 1, 1);
        gridpane.add(incorrect3_1, 3, 6, 1, 1);
        
        Label label2 = new Label("Question 3:");
        GridPane.setHalignment(label2, HPos.RIGHT);
        label2.setStyle("-fx-font-weight: bold;");
        gridpane.add(label2, 0, 8, 1, 1);
        
        TextField question2 = new TextField(topic1.questions.get(2).question);
        TextField answer2 = new TextField(topic1.questions.get(2).answer);
        TextField incorrect1_2 = new TextField(topic1.questions.get(2).incorrect1);
        TextField incorrect2_2 = new TextField(topic1.questions.get(2).incorrect2);
        TextField incorrect3_2 = new TextField(topic1.questions.get(2).incorrect3);
        
        answer2.setStyle("-fx-border-color: green;");
        
        gridpane.add(question2, 1, 8, 2, 1);
        gridpane.add(answer2, 0, 9, 1, 1);
        gridpane.add(incorrect1_2, 1, 9, 1, 1);
        gridpane.add(incorrect2_2, 2, 9, 1, 1);
        gridpane.add(incorrect3_2, 3, 9, 1, 1);
        
        Label label3 = new Label("Question 4:");
        label3.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label3, HPos.RIGHT);
        gridpane.add(label3, 0, 11, 1, 1);
        
        TextField question3 = new TextField(topic1.questions.get(3).question);
        TextField answer3 = new TextField(topic1.questions.get(3).answer);
        TextField incorrect1_3 = new TextField(topic1.questions.get(3).incorrect1);
        TextField incorrect2_3 = new TextField(topic1.questions.get(3).incorrect2);
        TextField incorrect3_3 = new TextField(topic1.questions.get(3).incorrect3);
        
        answer3.setStyle("-fx-border-color: green;");
        
        gridpane.add(question3, 1, 11, 2, 1);
        gridpane.add(answer3, 0, 12, 1, 1);
        gridpane.add(incorrect1_3, 1, 12, 1, 1);
        gridpane.add(incorrect2_3, 2, 12, 1, 1);
        gridpane.add(incorrect3_3, 3, 12, 1, 1);
        
        Label label4 = new Label("Question 5:");
        label4.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label4, HPos.RIGHT);
        gridpane.add(label4, 0, 14, 1, 1);
        
        TextField question4 = new TextField(topic1.questions.get(4).question);
        TextField answer4 = new TextField(topic1.questions.get(4).answer);
        TextField incorrect1_4 = new TextField(topic1.questions.get(4).incorrect1);
        TextField incorrect2_4 = new TextField(topic1.questions.get(4).incorrect2);
        TextField incorrect3_4 = new TextField(topic1.questions.get(4).incorrect3);
        
        answer4.setStyle("-fx-border-color: green;");
        
        gridpane.add(question4, 1, 14, 2, 1);
        gridpane.add(answer4, 0, 15, 1, 1);
        gridpane.add(incorrect1_4, 1, 15, 1, 1);
        gridpane.add(incorrect2_4, 2, 15, 1, 1);
        gridpane.add(incorrect3_4, 3, 15, 1, 1);
        
        Label label5 = new Label("Question 6:");
        label5.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label5, HPos.RIGHT);
        gridpane.add(label5, 0, 17, 1, 1);
        
        TextField question5 = new TextField(topic1.questions.get(5).question);
        TextField answer5 = new TextField(topic1.questions.get(5).answer);
        TextField incorrect1_5 = new TextField(topic1.questions.get(5).incorrect1);
        TextField incorrect2_5 = new TextField(topic1.questions.get(5).incorrect2);
        TextField incorrect3_5 = new TextField(topic1.questions.get(5).incorrect3);
        
        answer5.setStyle("-fx-border-color: green;");
        
        gridpane.add(question5, 1, 17, 2, 1);
        gridpane.add(answer5, 0, 18, 1, 1);
        gridpane.add(incorrect1_5, 1, 18, 1, 1);
        gridpane.add(incorrect2_5, 2, 18, 1, 1);
        gridpane.add(incorrect3_5, 3, 18, 1, 1);
        
        Label label6 = new Label("Question 7:");
        label6.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label6, HPos.RIGHT);
        gridpane.add(label6, 0, 20, 1, 1);
        
        TextField question6 = new TextField(topic1.questions.get(6).question);
        TextField answer6 = new TextField(topic1.questions.get(6).answer);
        TextField incorrect1_6 = new TextField(topic1.questions.get(6).incorrect1);
        TextField incorrect2_6 = new TextField(topic1.questions.get(6).incorrect2);
        TextField incorrect3_6 = new TextField(topic1.questions.get(6).incorrect3);
        
        answer6.setStyle("-fx-border-color: green;");
        
        gridpane.add(question6, 1, 20, 2, 1);
        gridpane.add(answer6, 0, 21, 1, 1);
        gridpane.add(incorrect1_6, 1, 21, 1, 1);
        gridpane.add(incorrect2_6, 2, 21, 1, 1);
        gridpane.add(incorrect3_6, 3, 21, 1, 1);
        
        Label label7 = new Label("Question 8:");
        label7.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label7, HPos.RIGHT);
        gridpane.add(label7, 0, 23, 1, 1);
        
        TextField question7 = new TextField(topic1.questions.get(7).question);
        TextField answer7 = new TextField(topic1.questions.get(7).answer);
        TextField incorrect1_7 = new TextField(topic1.questions.get(7).incorrect1);
        TextField incorrect2_7 = new TextField(topic1.questions.get(7).incorrect2);
        TextField incorrect3_7 = new TextField(topic1.questions.get(7).incorrect3);
        
        answer7.setStyle("-fx-border-color: green;");
        
        gridpane.add(question7, 1, 23, 2, 1);
        gridpane.add(answer7, 0, 24, 1, 1);
        gridpane.add(incorrect1_7, 1, 24, 1, 1);
        gridpane.add(incorrect2_7, 2, 24, 1, 1);
        gridpane.add(incorrect3_7, 3, 24, 1, 1);
        
        Label label8 = new Label("Question 9:");
        label8.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label8, HPos.RIGHT);
        gridpane.add(label8, 0, 26, 1, 1);
        
        TextField question8 = new TextField(topic1.questions.get(8).question);
        TextField answer8 = new TextField(topic1.questions.get(8).answer);
        TextField incorrect1_8 = new TextField(topic1.questions.get(8).incorrect1);
        TextField incorrect2_8 = new TextField(topic1.questions.get(8).incorrect2);
        TextField incorrect3_8 = new TextField(topic1.questions.get(8).incorrect3);
        
        answer8.setStyle("-fx-border-color: green;");
        
        gridpane.add(question8, 1, 26, 2, 1);
        gridpane.add(answer8, 0, 27, 1, 1);
        gridpane.add(incorrect1_8, 1, 27, 1, 1);
        gridpane.add(incorrect2_8, 2, 27, 1, 1);
        gridpane.add(incorrect3_8, 3, 27, 1, 1);
        
        Label label9 = new Label("Question 10:");
        label9.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label9, HPos.RIGHT);
        gridpane.add(label9, 0, 29, 1, 1);
        
        TextField question9 = new TextField(topic1.questions.get(9).question);
        TextField answer9 = new TextField(topic1.questions.get(9).answer);
        TextField incorrect1_9 = new TextField(topic1.questions.get(9).incorrect1);
        TextField incorrect2_9 = new TextField(topic1.questions.get(9).incorrect2);
        TextField incorrect3_9 = new TextField(topic1.questions.get(9).incorrect3);
        
        answer9.setStyle("-fx-border-color: green;");
        
        gridpane.add(question9, 1, 29, 2, 1);
        gridpane.add(answer9, 0, 30, 1, 1);
        gridpane.add(incorrect1_9, 1, 30, 1, 1);
        gridpane.add(incorrect2_9, 2, 30, 1, 1);
        gridpane.add(incorrect3_9, 3, 30, 1, 1);
        
        //add save and cancel buttons
        Button cancelButton = new Button("Cancel Changes");
        Button saveButton = new Button("Save Changes");
        
        cancelButton.setOnAction((ActionEvent e) -> {
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Quiz Management");
            confirmationAlert.setContentText("Discard changes?");
            
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.get() == ButtonType.OK){
                try {
                    Scene quizScene = manageQuizScene();
                    thestage.setScene(quizScene);
                } catch (IOException ex) {
                    Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        saveButton.setOnAction((ActionEvent e) -> {
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Quiz Management");
            confirmationAlert.setContentText("Save changes?");
            
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.get() == ButtonType.OK){
                try {
                    CSVWriter writer = new CSVWriter(new FileWriter("topic1.csv", false));
                    
                    String topicTitleValue[] = new String[] {topicTitle.getText()};
                
                    String q0Array[] = new String[] {
                        question0.getText(),
                        answer0.getText(),
                        incorrect1_0.getText(),
                        incorrect2_0.getText(),
                        incorrect3_0.getText()
                    };

                    String q1Array[] = new String[] {
                        question1.getText(),
                        answer1.getText(),
                        incorrect1_1.getText(),
                        incorrect2_1.getText(),
                        incorrect3_1.getText()
                    };
                    
                    String q2Array[] = new String[] {
                        question2.getText(),
                        answer2.getText(),
                        incorrect1_2.getText(),
                        incorrect2_2.getText(),
                        incorrect3_2.getText()
                    };

                    String q3Array[] = new String[] {
                        question3.getText(),
                        answer3.getText(),
                        incorrect1_3.getText(),
                        incorrect2_3.getText(),
                        incorrect3_3.getText()
                    };

                    String q4Array[] = new String[] {
                        question4.getText(),
                        answer4.getText(),
                        incorrect1_4.getText(),
                        incorrect2_4.getText(),
                        incorrect3_4.getText()
                    };

                    String q5Array[] = new String[] {
                        question5.getText(),
                        answer5.getText(),
                        incorrect1_5.getText(),
                        incorrect2_5.getText(),
                        incorrect3_5.getText()
                    };

                    String q6Array[] = new String[] {
                        question6.getText(),
                        answer6.getText(),
                        incorrect1_6.getText(),
                        incorrect2_6.getText(),
                        incorrect3_6.getText()
                    };

                    String q7Array[] = new String[] {
                        question7.getText(),
                        answer7.getText(),
                        incorrect1_7.getText(),
                        incorrect2_7.getText(),
                        incorrect3_7.getText()
                    };

                    String q8Array[] = new String[] {
                        question8.getText(),
                        answer8.getText(),
                        incorrect1_8.getText(),
                        incorrect2_8.getText(),
                        incorrect3_8.getText()
                    };

                    String q9Array[] = new String[] {
                        question9.getText(),
                        answer9.getText(),
                        incorrect1_9.getText(),
                        incorrect2_9.getText(),
                        incorrect3_9.getText()
                    };

                    writer.writeNext(topicTitleValue);
                    writer.writeNext(q0Array);
                    writer.writeNext(q1Array);
                    writer.writeNext(q2Array);
                    writer.writeNext(q3Array);
                    writer.writeNext(q4Array);
                    writer.writeNext(q5Array);
                    writer.writeNext(q6Array);
                    writer.writeNext(q7Array);
                    writer.writeNext(q8Array);
                    writer.writeNext(q9Array);
                    writer.close();
                    
                    Scene quizScene = manageQuizScene();
                    thestage.setScene(quizScene);
                    
                } catch (IOException ex) {
                    Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
                }

        }});
        
        cancelButton.setPrefWidth(200);
        saveButton.setPrefWidth(200);
        
        GridPane.setHalignment(cancelButton, HPos.RIGHT);
        
        gridpane.add(cancelButton, 2, 32, 1, 1);
        gridpane.add(saveButton, 3, 32, 1, 1);
        
        for (int i = 0; i <= 32; i++) {
            RowConstraints rowC = new RowConstraints();
            rowC.setPrefHeight(30);
            gridpane.getRowConstraints().add(rowC);
        }
        
        root0.setPrefSize(1200, 800);
        root0.setFitToWidth(true);
        root0.setContent(gridpane);
        
        return new Scene(root0, 1200, 800);
    }
    
    public Scene thirdTopicScene() throws IOException{
        Topic topic0 = new Topic();
        Topic topic1 = new Topic(); 
        Topic topic2 = new Topic();
        Topic topic3 = new Topic();
        Topic topic4 = new Topic();
        
        ArrayList<Topic> topics = getTopics(topic0, topic1, topic2, topic3, topic4);
        
        //create third scene
        ScrollPane root0 = new ScrollPane();
        
        GridPane gridpane = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(25);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(25);
        gridpane.getColumnConstraints().addAll(column1, column2, column3, column4);
        
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(15);
        gridpane.setVgap(5);
        

        
        TextField topicTitle = new TextField(topic2.name);
        Label topicLabel = new Label("Topic Title:");
        topicLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(topicLabel, HPos.RIGHT);
        gridpane.add(topicLabel, 0, 0, 1, 1);
        
        Label label0 = new Label("Question 1:");
        label0.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label0, HPos.RIGHT);
        gridpane.add(label0, 0, 2, 1, 1);
        
        TextField question0 = new TextField(topic2.questions.get(0).question);
        TextField answer0 = new TextField(topic2.questions.get(0).answer);
        TextField incorrect1_0 = new TextField(topic2.questions.get(0).incorrect1);
        TextField incorrect2_0 = new TextField(topic2.questions.get(0).incorrect2);
        TextField incorrect3_0 = new TextField(topic2.questions.get(0).incorrect3);
        
        answer0.setStyle("-fx-border-color: green;");
        
        gridpane.add(topicTitle, 1, 0, 2, 1);
        gridpane.add(question0, 1, 2, 2, 1);
        gridpane.add(answer0, 0, 3, 1, 1);
        gridpane.add(incorrect1_0, 1, 3, 1, 1);
        gridpane.add(incorrect2_0, 2, 3, 1, 1);
        gridpane.add(incorrect3_0, 3, 3, 1, 1);
        
        Label label1 = new Label("Question 2:");
        label1.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label1, HPos.RIGHT);
        gridpane.add(label1, 0, 5, 1, 1);
        
        TextField question1 = new TextField(topic2.questions.get(1).question);
        TextField answer1 = new TextField(topic2.questions.get(1).answer);
        TextField incorrect1_1 = new TextField(topic2.questions.get(1).incorrect1);
        TextField incorrect2_1 = new TextField(topic2.questions.get(1).incorrect2);
        TextField incorrect3_1 = new TextField(topic2.questions.get(1).incorrect3);
        
        answer1.setStyle("-fx-border-color: green;");
        
        gridpane.add(question1, 1, 5, 2, 1);
        gridpane.add(answer1, 0, 6, 1, 1);
        gridpane.add(incorrect1_1, 1, 6, 1, 1);
        gridpane.add(incorrect2_1, 2, 6, 1, 1);
        gridpane.add(incorrect3_1, 3, 6, 1, 1);
        
        Label label2 = new Label("Question 3:");
        GridPane.setHalignment(label2, HPos.RIGHT);
        label2.setStyle("-fx-font-weight: bold;");
        gridpane.add(label2, 0, 8, 1, 1);
        
        TextField question2 = new TextField(topic2.questions.get(2).question);
        TextField answer2 = new TextField(topic2.questions.get(2).answer);
        TextField incorrect1_2 = new TextField(topic2.questions.get(2).incorrect1);
        TextField incorrect2_2 = new TextField(topic2.questions.get(2).incorrect2);
        TextField incorrect3_2 = new TextField(topic2.questions.get(2).incorrect3);
        
        answer2.setStyle("-fx-border-color: green;");
        
        gridpane.add(question2, 1, 8, 2, 1);
        gridpane.add(answer2, 0, 9, 1, 1);
        gridpane.add(incorrect1_2, 1, 9, 1, 1);
        gridpane.add(incorrect2_2, 2, 9, 1, 1);
        gridpane.add(incorrect3_2, 3, 9, 1, 1);
        
        Label label3 = new Label("Question 4:");
        label3.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label3, HPos.RIGHT);
        gridpane.add(label3, 0, 11, 1, 1);
        
        TextField question3 = new TextField(topic2.questions.get(3).question);
        TextField answer3 = new TextField(topic2.questions.get(3).answer);
        TextField incorrect1_3 = new TextField(topic2.questions.get(3).incorrect1);
        TextField incorrect2_3 = new TextField(topic2.questions.get(3).incorrect2);
        TextField incorrect3_3 = new TextField(topic2.questions.get(3).incorrect3);
        
        answer3.setStyle("-fx-border-color: green;");
        
        gridpane.add(question3, 1, 11, 2, 1);
        gridpane.add(answer3, 0, 12, 1, 1);
        gridpane.add(incorrect1_3, 1, 12, 1, 1);
        gridpane.add(incorrect2_3, 2, 12, 1, 1);
        gridpane.add(incorrect3_3, 3, 12, 1, 1);
        
        Label label4 = new Label("Question 5:");
        label4.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label4, HPos.RIGHT);
        gridpane.add(label4, 0, 14, 1, 1);
        
        TextField question4 = new TextField(topic2.questions.get(4).question);
        TextField answer4 = new TextField(topic2.questions.get(4).answer);
        TextField incorrect1_4 = new TextField(topic2.questions.get(4).incorrect1);
        TextField incorrect2_4 = new TextField(topic2.questions.get(4).incorrect2);
        TextField incorrect3_4 = new TextField(topic2.questions.get(4).incorrect3);
        
        answer4.setStyle("-fx-border-color: green;");
        
        gridpane.add(question4, 1, 14, 2, 1);
        gridpane.add(answer4, 0, 15, 1, 1);
        gridpane.add(incorrect1_4, 1, 15, 1, 1);
        gridpane.add(incorrect2_4, 2, 15, 1, 1);
        gridpane.add(incorrect3_4, 3, 15, 1, 1);
        
        Label label5 = new Label("Question 6:");
        label5.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label5, HPos.RIGHT);
        gridpane.add(label5, 0, 17, 1, 1);
        
        TextField question5 = new TextField(topic2.questions.get(5).question);
        TextField answer5 = new TextField(topic2.questions.get(5).answer);
        TextField incorrect1_5 = new TextField(topic2.questions.get(5).incorrect1);
        TextField incorrect2_5 = new TextField(topic2.questions.get(5).incorrect2);
        TextField incorrect3_5 = new TextField(topic2.questions.get(5).incorrect3);
        
        answer5.setStyle("-fx-border-color: green;");
        
        gridpane.add(question5, 1, 17, 2, 1);
        gridpane.add(answer5, 0, 18, 1, 1);
        gridpane.add(incorrect1_5, 1, 18, 1, 1);
        gridpane.add(incorrect2_5, 2, 18, 1, 1);
        gridpane.add(incorrect3_5, 3, 18, 1, 1);
        
        Label label6 = new Label("Question 7:");
        label6.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label6, HPos.RIGHT);
        gridpane.add(label6, 0, 20, 1, 1);
        
        TextField question6 = new TextField(topic2.questions.get(6).question);
        TextField answer6 = new TextField(topic2.questions.get(6).answer);
        TextField incorrect1_6 = new TextField(topic2.questions.get(6).incorrect1);
        TextField incorrect2_6 = new TextField(topic2.questions.get(6).incorrect2);
        TextField incorrect3_6 = new TextField(topic2.questions.get(6).incorrect3);
        
        answer6.setStyle("-fx-border-color: green;");
        
        gridpane.add(question6, 1, 20, 2, 1);
        gridpane.add(answer6, 0, 21, 1, 1);
        gridpane.add(incorrect1_6, 1, 21, 1, 1);
        gridpane.add(incorrect2_6, 2, 21, 1, 1);
        gridpane.add(incorrect3_6, 3, 21, 1, 1);
        
        Label label7 = new Label("Question 8:");
        label7.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label7, HPos.RIGHT);
        gridpane.add(label7, 0, 23, 1, 1);
        
        TextField question7 = new TextField(topic2.questions.get(7).question);
        TextField answer7 = new TextField(topic2.questions.get(7).answer);
        TextField incorrect1_7 = new TextField(topic2.questions.get(7).incorrect1);
        TextField incorrect2_7 = new TextField(topic2.questions.get(7).incorrect2);
        TextField incorrect3_7 = new TextField(topic2.questions.get(7).incorrect3);
        
        answer7.setStyle("-fx-border-color: green;");
        
        gridpane.add(question7, 1, 23, 2, 1);
        gridpane.add(answer7, 0, 24, 1, 1);
        gridpane.add(incorrect1_7, 1, 24, 1, 1);
        gridpane.add(incorrect2_7, 2, 24, 1, 1);
        gridpane.add(incorrect3_7, 3, 24, 1, 1);
        
        Label label8 = new Label("Question 9:");
        label8.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label8, HPos.RIGHT);
        gridpane.add(label8, 0, 26, 1, 1);
        
        TextField question8 = new TextField(topic2.questions.get(8).question);
        TextField answer8 = new TextField(topic2.questions.get(8).answer);
        TextField incorrect1_8 = new TextField(topic2.questions.get(8).incorrect1);
        TextField incorrect2_8 = new TextField(topic2.questions.get(8).incorrect2);
        TextField incorrect3_8 = new TextField(topic2.questions.get(8).incorrect3);
        
        answer8.setStyle("-fx-border-color: green;");
        
        gridpane.add(question8, 1, 26, 2, 1);
        gridpane.add(answer8, 0, 27, 1, 1);
        gridpane.add(incorrect1_8, 1, 27, 1, 1);
        gridpane.add(incorrect2_8, 2, 27, 1, 1);
        gridpane.add(incorrect3_8, 3, 27, 1, 1);
        
        Label label9 = new Label("Question 10:");
        label9.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label9, HPos.RIGHT);
        gridpane.add(label9, 0, 29, 1, 1);
        
        TextField question9 = new TextField(topic2.questions.get(9).question);
        TextField answer9 = new TextField(topic2.questions.get(9).answer);
        TextField incorrect1_9 = new TextField(topic2.questions.get(9).incorrect1);
        TextField incorrect2_9 = new TextField(topic2.questions.get(9).incorrect2);
        TextField incorrect3_9 = new TextField(topic2.questions.get(9).incorrect3);
        
        answer9.setStyle("-fx-border-color: green;");
        
        gridpane.add(question9, 1, 29, 2, 1);
        gridpane.add(answer9, 0, 30, 1, 1);
        gridpane.add(incorrect1_9, 1, 30, 1, 1);
        gridpane.add(incorrect2_9, 2, 30, 1, 1);
        gridpane.add(incorrect3_9, 3, 30, 1, 1);
        
        //add save and cancel buttons
        Button cancelButton = new Button("Cancel Changes");
        Button saveButton = new Button("Save Changes");
        
        cancelButton.setOnAction((ActionEvent e) -> {
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Quiz Management");
            confirmationAlert.setContentText("Discard changes?");
            
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.get() == ButtonType.OK){
                try {
                    Scene quizScene = manageQuizScene();
                    thestage.setScene(quizScene);
                } catch (IOException ex) {
                    Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        saveButton.setOnAction((ActionEvent e) -> {
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Quiz Management");
            confirmationAlert.setContentText("Save changes?");
            
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.get() == ButtonType.OK){
                try {
                    CSVWriter writer = new CSVWriter(new FileWriter("topic2.csv", false));
                    
                    String topicTitleValue[] = new String[] {topicTitle.getText()};
                
                    String q0Array[] = new String[] {
                        question0.getText(),
                        answer0.getText(),
                        incorrect1_0.getText(),
                        incorrect2_0.getText(),
                        incorrect3_0.getText()
                    };

                    String q1Array[] = new String[] {
                        question1.getText(),
                        answer1.getText(),
                        incorrect1_1.getText(),
                        incorrect2_1.getText(),
                        incorrect3_1.getText()
                    };
                    
                    String q2Array[] = new String[] {
                        question2.getText(),
                        answer2.getText(),
                        incorrect1_2.getText(),
                        incorrect2_2.getText(),
                        incorrect3_2.getText()
                    };

                    String q3Array[] = new String[] {
                        question3.getText(),
                        answer3.getText(),
                        incorrect1_3.getText(),
                        incorrect2_3.getText(),
                        incorrect3_3.getText()
                    };

                    String q4Array[] = new String[] {
                        question4.getText(),
                        answer4.getText(),
                        incorrect1_4.getText(),
                        incorrect2_4.getText(),
                        incorrect3_4.getText()
                    };

                    String q5Array[] = new String[] {
                        question5.getText(),
                        answer5.getText(),
                        incorrect1_5.getText(),
                        incorrect2_5.getText(),
                        incorrect3_5.getText()
                    };

                    String q6Array[] = new String[] {
                        question6.getText(),
                        answer6.getText(),
                        incorrect1_6.getText(),
                        incorrect2_6.getText(),
                        incorrect3_6.getText()
                    };

                    String q7Array[] = new String[] {
                        question7.getText(),
                        answer7.getText(),
                        incorrect1_7.getText(),
                        incorrect2_7.getText(),
                        incorrect3_7.getText()
                    };

                    String q8Array[] = new String[] {
                        question8.getText(),
                        answer8.getText(),
                        incorrect1_8.getText(),
                        incorrect2_8.getText(),
                        incorrect3_8.getText()
                    };

                    String q9Array[] = new String[] {
                        question9.getText(),
                        answer9.getText(),
                        incorrect1_9.getText(),
                        incorrect2_9.getText(),
                        incorrect3_9.getText()
                    };

                    writer.writeNext(topicTitleValue);
                    writer.writeNext(q0Array);
                    writer.writeNext(q1Array);
                    writer.writeNext(q2Array);
                    writer.writeNext(q3Array);
                    writer.writeNext(q4Array);
                    writer.writeNext(q5Array);
                    writer.writeNext(q6Array);
                    writer.writeNext(q7Array);
                    writer.writeNext(q8Array);
                    writer.writeNext(q9Array);
                    writer.close();
                    
                    Scene quizScene = manageQuizScene();
                    thestage.setScene(quizScene);
                    
                } catch (IOException ex) {
                    Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
                }

        }});
        
        cancelButton.setPrefWidth(200);
        saveButton.setPrefWidth(200);
        
        GridPane.setHalignment(cancelButton, HPos.RIGHT);
        
        gridpane.add(cancelButton, 2, 32, 1, 1);
        gridpane.add(saveButton, 3, 32, 1, 1);
        
        for (int i = 0; i <= 32; i++) {
            RowConstraints rowC = new RowConstraints();
            rowC.setPrefHeight(30);
            gridpane.getRowConstraints().add(rowC);
        }
        
        root0.setPrefSize(1200, 800);
        root0.setFitToWidth(true);
        root0.setContent(gridpane);
        
        return new Scene(root0, 1200, 8000);
    }
    
    
    public Scene fourthTopicScene() throws IOException{
        Topic topic0 = new Topic();
        Topic topic1 = new Topic(); 
        Topic topic2 = new Topic();
        Topic topic3 = new Topic();
        Topic topic4 = new Topic();
        
        ArrayList<Topic> topics = getTopics(topic0, topic1, topic2, topic3, topic4);
        
        //create fourth scene
        ScrollPane root0 = new ScrollPane();
        
        GridPane gridpane = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(25);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(25);
        gridpane.getColumnConstraints().addAll(column1, column2, column3, column4);
        
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(15);
        gridpane.setVgap(5);
        

        
        TextField topicTitle = new TextField(topic3.name);
        Label topicLabel = new Label("Topic Title:");
        topicLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(topicLabel, HPos.RIGHT);
        gridpane.add(topicLabel, 0, 0, 1, 1);
        
        Label label0 = new Label("Question 1:");
        label0.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label0, HPos.RIGHT);
        gridpane.add(label0, 0, 2, 1, 1);
        
        TextField question0 = new TextField(topic3.questions.get(0).question);
        TextField answer0 = new TextField(topic3.questions.get(0).answer);
        TextField incorrect1_0 = new TextField(topic3.questions.get(0).incorrect1);
        TextField incorrect2_0 = new TextField(topic3.questions.get(0).incorrect2);
        TextField incorrect3_0 = new TextField(topic3.questions.get(0).incorrect3);
        
        answer0.setStyle("-fx-border-color: green;");
        
        gridpane.add(topicTitle, 1, 0, 2, 1);
        gridpane.add(question0, 1, 2, 2, 1);
        gridpane.add(answer0, 0, 3, 1, 1);
        gridpane.add(incorrect1_0, 1, 3, 1, 1);
        gridpane.add(incorrect2_0, 2, 3, 1, 1);
        gridpane.add(incorrect3_0, 3, 3, 1, 1);
        
        Label label1 = new Label("Question 2:");
        label1.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label1, HPos.RIGHT);
        gridpane.add(label1, 0, 5, 1, 1);
        
        TextField question1 = new TextField(topic3.questions.get(1).question);
        TextField answer1 = new TextField(topic3.questions.get(1).answer);
        TextField incorrect1_1 = new TextField(topic3.questions.get(1).incorrect1);
        TextField incorrect2_1 = new TextField(topic3.questions.get(1).incorrect2);
        TextField incorrect3_1 = new TextField(topic3.questions.get(1).incorrect3);
        
        answer1.setStyle("-fx-border-color: green;");
        
        gridpane.add(question1, 1, 5, 2, 1);
        gridpane.add(answer1, 0, 6, 1, 1);
        gridpane.add(incorrect1_1, 1, 6, 1, 1);
        gridpane.add(incorrect2_1, 2, 6, 1, 1);
        gridpane.add(incorrect3_1, 3, 6, 1, 1);
        
        Label label2 = new Label("Question 3:");
        GridPane.setHalignment(label2, HPos.RIGHT);
        label2.setStyle("-fx-font-weight: bold;");
        gridpane.add(label2, 0, 8, 1, 1);
        
        TextField question2 = new TextField(topic3.questions.get(2).question);
        TextField answer2 = new TextField(topic3.questions.get(2).answer);
        TextField incorrect1_2 = new TextField(topic3.questions.get(2).incorrect1);
        TextField incorrect2_2 = new TextField(topic3.questions.get(2).incorrect2);
        TextField incorrect3_2 = new TextField(topic3.questions.get(2).incorrect3);
        
        answer2.setStyle("-fx-border-color: green;");
        
        gridpane.add(question2, 1, 8, 2, 1);
        gridpane.add(answer2, 0, 9, 1, 1);
        gridpane.add(incorrect1_2, 1, 9, 1, 1);
        gridpane.add(incorrect2_2, 2, 9, 1, 1);
        gridpane.add(incorrect3_2, 3, 9, 1, 1);
        
        Label label3 = new Label("Question 4:");
        label3.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label3, HPos.RIGHT);
        gridpane.add(label3, 0, 11, 1, 1);
        
        TextField question3 = new TextField(topic3.questions.get(3).question);
        TextField answer3 = new TextField(topic3.questions.get(3).answer);
        TextField incorrect1_3 = new TextField(topic3.questions.get(3).incorrect1);
        TextField incorrect2_3 = new TextField(topic3.questions.get(3).incorrect2);
        TextField incorrect3_3 = new TextField(topic3.questions.get(3).incorrect3);
        
        answer3.setStyle("-fx-border-color: green;");
        
        gridpane.add(question3, 1, 11, 2, 1);
        gridpane.add(answer3, 0, 12, 1, 1);
        gridpane.add(incorrect1_3, 1, 12, 1, 1);
        gridpane.add(incorrect2_3, 2, 12, 1, 1);
        gridpane.add(incorrect3_3, 3, 12, 1, 1);
        
        Label label4 = new Label("Question 5:");
        label4.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label4, HPos.RIGHT);
        gridpane.add(label4, 0, 14, 1, 1);
        
        TextField question4 = new TextField(topic3.questions.get(4).question);
        TextField answer4 = new TextField(topic3.questions.get(4).answer);
        TextField incorrect1_4 = new TextField(topic3.questions.get(4).incorrect1);
        TextField incorrect2_4 = new TextField(topic3.questions.get(4).incorrect2);
        TextField incorrect3_4 = new TextField(topic3.questions.get(4).incorrect3);
        
        answer4.setStyle("-fx-border-color: green;");
        
        gridpane.add(question4, 1, 14, 2, 1);
        gridpane.add(answer4, 0, 15, 1, 1);
        gridpane.add(incorrect1_4, 1, 15, 1, 1);
        gridpane.add(incorrect2_4, 2, 15, 1, 1);
        gridpane.add(incorrect3_4, 3, 15, 1, 1);
        
        Label label5 = new Label("Question 6:");
        label5.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label5, HPos.RIGHT);
        gridpane.add(label5, 0, 17, 1, 1);
        
        TextField question5 = new TextField(topic3.questions.get(5).question);
        TextField answer5 = new TextField(topic3.questions.get(5).answer);
        TextField incorrect1_5 = new TextField(topic3.questions.get(5).incorrect1);
        TextField incorrect2_5 = new TextField(topic3.questions.get(5).incorrect2);
        TextField incorrect3_5 = new TextField(topic3.questions.get(5).incorrect3);
        
        answer5.setStyle("-fx-border-color: green;");
        
        gridpane.add(question5, 1, 17, 2, 1);
        gridpane.add(answer5, 0, 18, 1, 1);
        gridpane.add(incorrect1_5, 1, 18, 1, 1);
        gridpane.add(incorrect2_5, 2, 18, 1, 1);
        gridpane.add(incorrect3_5, 3, 18, 1, 1);
        
        Label label6 = new Label("Question 7:");
        label6.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label6, HPos.RIGHT);
        gridpane.add(label6, 0, 20, 1, 1);
        
        TextField question6 = new TextField(topic3.questions.get(6).question);
        TextField answer6 = new TextField(topic3.questions.get(6).answer);
        TextField incorrect1_6 = new TextField(topic3.questions.get(6).incorrect1);
        TextField incorrect2_6 = new TextField(topic3.questions.get(6).incorrect2);
        TextField incorrect3_6 = new TextField(topic3.questions.get(6).incorrect3);
        
        answer6.setStyle("-fx-border-color: green;");
        
        gridpane.add(question6, 1, 20, 2, 1);
        gridpane.add(answer6, 0, 21, 1, 1);
        gridpane.add(incorrect1_6, 1, 21, 1, 1);
        gridpane.add(incorrect2_6, 2, 21, 1, 1);
        gridpane.add(incorrect3_6, 3, 21, 1, 1);
        
        Label label7 = new Label("Question 8:");
        label7.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label7, HPos.RIGHT);
        gridpane.add(label7, 0, 23, 1, 1);
        
        TextField question7 = new TextField(topic3.questions.get(7).question);
        TextField answer7 = new TextField(topic3.questions.get(7).answer);
        TextField incorrect1_7 = new TextField(topic3.questions.get(7).incorrect1);
        TextField incorrect2_7 = new TextField(topic3.questions.get(7).incorrect2);
        TextField incorrect3_7 = new TextField(topic3.questions.get(7).incorrect3);
        
        answer7.setStyle("-fx-border-color: green;");
        
        gridpane.add(question7, 1, 23, 2, 1);
        gridpane.add(answer7, 0, 24, 1, 1);
        gridpane.add(incorrect1_7, 1, 24, 1, 1);
        gridpane.add(incorrect2_7, 2, 24, 1, 1);
        gridpane.add(incorrect3_7, 3, 24, 1, 1);
        
        Label label8 = new Label("Question 9:");
        label8.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label8, HPos.RIGHT);
        gridpane.add(label8, 0, 26, 1, 1);
        
        TextField question8 = new TextField(topic3.questions.get(8).question);
        TextField answer8 = new TextField(topic3.questions.get(8).answer);
        TextField incorrect1_8 = new TextField(topic3.questions.get(8).incorrect1);
        TextField incorrect2_8 = new TextField(topic3.questions.get(8).incorrect2);
        TextField incorrect3_8 = new TextField(topic3.questions.get(8).incorrect3);
        
        answer8.setStyle("-fx-border-color: green;");
        
        gridpane.add(question8, 1, 26, 2, 1);
        gridpane.add(answer8, 0, 27, 1, 1);
        gridpane.add(incorrect1_8, 1, 27, 1, 1);
        gridpane.add(incorrect2_8, 2, 27, 1, 1);
        gridpane.add(incorrect3_8, 3, 27, 1, 1);
        
        Label label9 = new Label("Question 10:");
        label9.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label9, HPos.RIGHT);
        gridpane.add(label9, 0, 29, 1, 1);
        
        TextField question9 = new TextField(topic3.questions.get(9).question);
        TextField answer9 = new TextField(topic3.questions.get(9).answer);
        TextField incorrect1_9 = new TextField(topic3.questions.get(9).incorrect1);
        TextField incorrect2_9 = new TextField(topic3.questions.get(9).incorrect2);
        TextField incorrect3_9 = new TextField(topic3.questions.get(9).incorrect3);
        
        answer9.setStyle("-fx-border-color: green;");
        
        gridpane.add(question9, 1, 29, 2, 1);
        gridpane.add(answer9, 0, 30, 1, 1);
        gridpane.add(incorrect1_9, 1, 30, 1, 1);
        gridpane.add(incorrect2_9, 2, 30, 1, 1);
        gridpane.add(incorrect3_9, 3, 30, 1, 1);
        
        //add save and cancel buttons
        Button cancelButton = new Button("Cancel Changes");
        Button saveButton = new Button("Save Changes");
        
        cancelButton.setOnAction((ActionEvent e) -> {
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Quiz Management");
            confirmationAlert.setContentText("Discard changes?");
            
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.get() == ButtonType.OK){
                try {
                    Scene quizScene = manageQuizScene();
                    thestage.setScene(quizScene);
                } catch (IOException ex) {
                    Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        saveButton.setOnAction((ActionEvent e) -> {
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Quiz Management");
            confirmationAlert.setContentText("Save changes?");
            
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.get() == ButtonType.OK){
                try {
                    CSVWriter writer = new CSVWriter(new FileWriter("topic3.csv", false));
                    
                    String topicTitleValue[] = new String[] {topicTitle.getText()};
                
                    String q0Array[] = new String[] {
                        question0.getText(),
                        answer0.getText(),
                        incorrect1_0.getText(),
                        incorrect2_0.getText(),
                        incorrect3_0.getText()
                    };

                    String q1Array[] = new String[] {
                        question1.getText(),
                        answer1.getText(),
                        incorrect1_1.getText(),
                        incorrect2_1.getText(),
                        incorrect3_1.getText()
                    };
                    
                    String q2Array[] = new String[] {
                        question2.getText(),
                        answer2.getText(),
                        incorrect1_2.getText(),
                        incorrect2_2.getText(),
                        incorrect3_2.getText()
                    };

                    String q3Array[] = new String[] {
                        question3.getText(),
                        answer3.getText(),
                        incorrect1_3.getText(),
                        incorrect2_3.getText(),
                        incorrect3_3.getText()
                    };

                    String q4Array[] = new String[] {
                        question4.getText(),
                        answer4.getText(),
                        incorrect1_4.getText(),
                        incorrect2_4.getText(),
                        incorrect3_4.getText()
                    };

                    String q5Array[] = new String[] {
                        question5.getText(),
                        answer5.getText(),
                        incorrect1_5.getText(),
                        incorrect2_5.getText(),
                        incorrect3_5.getText()
                    };

                    String q6Array[] = new String[] {
                        question6.getText(),
                        answer6.getText(),
                        incorrect1_6.getText(),
                        incorrect2_6.getText(),
                        incorrect3_6.getText()
                    };

                    String q7Array[] = new String[] {
                        question7.getText(),
                        answer7.getText(),
                        incorrect1_7.getText(),
                        incorrect2_7.getText(),
                        incorrect3_7.getText()
                    };

                    String q8Array[] = new String[] {
                        question8.getText(),
                        answer8.getText(),
                        incorrect1_8.getText(),
                        incorrect2_8.getText(),
                        incorrect3_8.getText()
                    };

                    String q9Array[] = new String[] {
                        question9.getText(),
                        answer9.getText(),
                        incorrect1_9.getText(),
                        incorrect2_9.getText(),
                        incorrect3_9.getText()
                    };

                    writer.writeNext(topicTitleValue);
                    writer.writeNext(q0Array);
                    writer.writeNext(q1Array);
                    writer.writeNext(q2Array);
                    writer.writeNext(q3Array);
                    writer.writeNext(q4Array);
                    writer.writeNext(q5Array);
                    writer.writeNext(q6Array);
                    writer.writeNext(q7Array);
                    writer.writeNext(q8Array);
                    writer.writeNext(q9Array);
                    writer.close();
                    
                    Scene quizScene = manageQuizScene();
                    thestage.setScene(quizScene);
                    
                } catch (IOException ex) {
                    Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
                }

        }});
        
        cancelButton.setPrefWidth(200);
        saveButton.setPrefWidth(200);
        
        GridPane.setHalignment(cancelButton, HPos.RIGHT);
        
        gridpane.add(cancelButton, 2, 32, 1, 1);
        gridpane.add(saveButton, 3, 32, 1, 1);
        
        for (int i = 0; i <= 32; i++) {
            RowConstraints rowC = new RowConstraints();
            rowC.setPrefHeight(30);
            gridpane.getRowConstraints().add(rowC);
        }
        
        root0.setPrefSize(1200, 800);
        root0.setFitToWidth(true);
        root0.setContent(gridpane);
        
        return new Scene(root0, 1200, 800);
    }
    
    public Scene fifthTopicScene() throws IOException{
        Topic topic0 = new Topic();
        Topic topic1 = new Topic(); 
        Topic topic2 = new Topic();
        Topic topic3 = new Topic();
        Topic topic4 = new Topic();
        
        ArrayList<Topic> topics = getTopics(topic0, topic1, topic2, topic3, topic4);
        
        //create fifth scene
        ScrollPane root0 = new ScrollPane();
        
        GridPane gridpane = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(25);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(25);
        gridpane.getColumnConstraints().addAll(column1, column2, column3, column4);
        
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.setHgap(15);
        gridpane.setVgap(5);
        

        
        TextField topicTitle = new TextField(topic4.name);
        Label topicLabel = new Label("Topic Title:");
        topicLabel.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(topicLabel, HPos.RIGHT);
        gridpane.add(topicLabel, 0, 0, 1, 1);
        
        Label label0 = new Label("Question 1:");
        label0.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label0, HPos.RIGHT);
        gridpane.add(label0, 0, 2, 1, 1);
        
        TextField question0 = new TextField(topic4.questions.get(0).question);
        TextField answer0 = new TextField(topic4.questions.get(0).answer);
        TextField incorrect1_0 = new TextField(topic4.questions.get(0).incorrect1);
        TextField incorrect2_0 = new TextField(topic4.questions.get(0).incorrect2);
        TextField incorrect3_0 = new TextField(topic4.questions.get(0).incorrect3);
        
        answer0.setStyle("-fx-border-color: green;");
        
        gridpane.add(topicTitle, 1, 0, 2, 1);
        gridpane.add(question0, 1, 2, 2, 1);
        gridpane.add(answer0, 0, 3, 1, 1);
        gridpane.add(incorrect1_0, 1, 3, 1, 1);
        gridpane.add(incorrect2_0, 2, 3, 1, 1);
        gridpane.add(incorrect3_0, 3, 3, 1, 1);
        
        Label label1 = new Label("Question 2:");
        label1.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label1, HPos.RIGHT);
        gridpane.add(label1, 0, 5, 1, 1);
        
        TextField question1 = new TextField(topic4.questions.get(1).question);
        TextField answer1 = new TextField(topic4.questions.get(1).answer);
        TextField incorrect1_1 = new TextField(topic4.questions.get(1).incorrect1);
        TextField incorrect2_1 = new TextField(topic4.questions.get(1).incorrect2);
        TextField incorrect3_1 = new TextField(topic4.questions.get(1).incorrect3);
        
        answer1.setStyle("-fx-border-color: green;");
        
        gridpane.add(question1, 1, 5, 2, 1);
        gridpane.add(answer1, 0, 6, 1, 1);
        gridpane.add(incorrect1_1, 1, 6, 1, 1);
        gridpane.add(incorrect2_1, 2, 6, 1, 1);
        gridpane.add(incorrect3_1, 3, 6, 1, 1);
        
        Label label2 = new Label("Question 3:");
        GridPane.setHalignment(label2, HPos.RIGHT);
        label2.setStyle("-fx-font-weight: bold;");
        gridpane.add(label2, 0, 8, 1, 1);
        
        TextField question2 = new TextField(topic4.questions.get(2).question);
        TextField answer2 = new TextField(topic4.questions.get(2).answer);
        TextField incorrect1_2 = new TextField(topic4.questions.get(2).incorrect1);
        TextField incorrect2_2 = new TextField(topic4.questions.get(2).incorrect2);
        TextField incorrect3_2 = new TextField(topic4.questions.get(2).incorrect3);
        
        answer2.setStyle("-fx-border-color: green;");
        
        gridpane.add(question2, 1, 8, 2, 1);
        gridpane.add(answer2, 0, 9, 1, 1);
        gridpane.add(incorrect1_2, 1, 9, 1, 1);
        gridpane.add(incorrect2_2, 2, 9, 1, 1);
        gridpane.add(incorrect3_2, 3, 9, 1, 1);
        
        Label label3 = new Label("Question 4:");
        label3.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label3, HPos.RIGHT);
        gridpane.add(label3, 0, 11, 1, 1);
        
        TextField question3 = new TextField(topic4.questions.get(3).question);
        TextField answer3 = new TextField(topic4.questions.get(3).answer);
        TextField incorrect1_3 = new TextField(topic4.questions.get(3).incorrect1);
        TextField incorrect2_3 = new TextField(topic4.questions.get(3).incorrect2);
        TextField incorrect3_3 = new TextField(topic4.questions.get(3).incorrect3);
        
        answer3.setStyle("-fx-border-color: green;");
        
        gridpane.add(question3, 1, 11, 2, 1);
        gridpane.add(answer3, 0, 12, 1, 1);
        gridpane.add(incorrect1_3, 1, 12, 1, 1);
        gridpane.add(incorrect2_3, 2, 12, 1, 1);
        gridpane.add(incorrect3_3, 3, 12, 1, 1);
        
        Label label4 = new Label("Question 5:");
        label4.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label4, HPos.RIGHT);
        gridpane.add(label4, 0, 14, 1, 1);
        
        TextField question4 = new TextField(topic4.questions.get(4).question);
        TextField answer4 = new TextField(topic4.questions.get(4).answer);
        TextField incorrect1_4 = new TextField(topic4.questions.get(4).incorrect1);
        TextField incorrect2_4 = new TextField(topic4.questions.get(4).incorrect2);
        TextField incorrect3_4 = new TextField(topic4.questions.get(4).incorrect3);
        
        answer4.setStyle("-fx-border-color: green;");
        
        gridpane.add(question4, 1, 14, 2, 1);
        gridpane.add(answer4, 0, 15, 1, 1);
        gridpane.add(incorrect1_4, 1, 15, 1, 1);
        gridpane.add(incorrect2_4, 2, 15, 1, 1);
        gridpane.add(incorrect3_4, 3, 15, 1, 1);
        
        Label label5 = new Label("Question 6:");
        label5.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label5, HPos.RIGHT);
        gridpane.add(label5, 0, 17, 1, 1);
        
        TextField question5 = new TextField(topic4.questions.get(5).question);
        TextField answer5 = new TextField(topic4.questions.get(5).answer);
        TextField incorrect1_5 = new TextField(topic4.questions.get(5).incorrect1);
        TextField incorrect2_5 = new TextField(topic4.questions.get(5).incorrect2);
        TextField incorrect3_5 = new TextField(topic4.questions.get(5).incorrect3);
        
        answer5.setStyle("-fx-border-color: green;");
        
        gridpane.add(question5, 1, 17, 2, 1);
        gridpane.add(answer5, 0, 18, 1, 1);
        gridpane.add(incorrect1_5, 1, 18, 1, 1);
        gridpane.add(incorrect2_5, 2, 18, 1, 1);
        gridpane.add(incorrect3_5, 3, 18, 1, 1);
        
        Label label6 = new Label("Question 7:");
        label6.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label6, HPos.RIGHT);
        gridpane.add(label6, 0, 20, 1, 1);
        
        TextField question6 = new TextField(topic4.questions.get(6).question);
        TextField answer6 = new TextField(topic4.questions.get(6).answer);
        TextField incorrect1_6 = new TextField(topic4.questions.get(6).incorrect1);
        TextField incorrect2_6 = new TextField(topic4.questions.get(6).incorrect2);
        TextField incorrect3_6 = new TextField(topic4.questions.get(6).incorrect3);
        
        answer6.setStyle("-fx-border-color: green;");
        
        gridpane.add(question6, 1, 20, 2, 1);
        gridpane.add(answer6, 0, 21, 1, 1);
        gridpane.add(incorrect1_6, 1, 21, 1, 1);
        gridpane.add(incorrect2_6, 2, 21, 1, 1);
        gridpane.add(incorrect3_6, 3, 21, 1, 1);
        
        Label label7 = new Label("Question 8:");
        label7.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label7, HPos.RIGHT);
        gridpane.add(label7, 0, 23, 1, 1);
        
        TextField question7 = new TextField(topic4.questions.get(7).question);
        TextField answer7 = new TextField(topic4.questions.get(7).answer);
        TextField incorrect1_7 = new TextField(topic4.questions.get(7).incorrect1);
        TextField incorrect2_7 = new TextField(topic4.questions.get(7).incorrect2);
        TextField incorrect3_7 = new TextField(topic4.questions.get(7).incorrect3);
        
        answer7.setStyle("-fx-border-color: green;");
        
        gridpane.add(question7, 1, 23, 2, 1);
        gridpane.add(answer7, 0, 24, 1, 1);
        gridpane.add(incorrect1_7, 1, 24, 1, 1);
        gridpane.add(incorrect2_7, 2, 24, 1, 1);
        gridpane.add(incorrect3_7, 3, 24, 1, 1);
        
        Label label8 = new Label("Question 9:");
        label8.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label8, HPos.RIGHT);
        gridpane.add(label8, 0, 26, 1, 1);
        
        TextField question8 = new TextField(topic4.questions.get(8).question);
        TextField answer8 = new TextField(topic4.questions.get(8).answer);
        TextField incorrect1_8 = new TextField(topic4.questions.get(8).incorrect1);
        TextField incorrect2_8 = new TextField(topic4.questions.get(8).incorrect2);
        TextField incorrect3_8 = new TextField(topic4.questions.get(8).incorrect3);
        
        answer8.setStyle("-fx-border-color: green;");
        
        gridpane.add(question8, 1, 26, 2, 1);
        gridpane.add(answer8, 0, 27, 1, 1);
        gridpane.add(incorrect1_8, 1, 27, 1, 1);
        gridpane.add(incorrect2_8, 2, 27, 1, 1);
        gridpane.add(incorrect3_8, 3, 27, 1, 1);
        
        Label label9 = new Label("Question 10:");
        label9.setStyle("-fx-font-weight: bold;");
        GridPane.setHalignment(label9, HPos.RIGHT);
        gridpane.add(label9, 0, 29, 1, 1);
        
        TextField question9 = new TextField(topic4.questions.get(9).question);
        TextField answer9 = new TextField(topic4.questions.get(9).answer);
        TextField incorrect1_9 = new TextField(topic4.questions.get(9).incorrect1);
        TextField incorrect2_9 = new TextField(topic4.questions.get(9).incorrect2);
        TextField incorrect3_9 = new TextField(topic4.questions.get(9).incorrect3);
        
        answer9.setStyle("-fx-border-color: green;");
        
        gridpane.add(question9, 1, 29, 2, 1);
        gridpane.add(answer9, 0, 30, 1, 1);
        gridpane.add(incorrect1_9, 1, 30, 1, 1);
        gridpane.add(incorrect2_9, 2, 30, 1, 1);
        gridpane.add(incorrect3_9, 3, 30, 1, 1);
        
        //add save and cancel buttons
        Button cancelButton = new Button("Cancel Changes");
        Button saveButton = new Button("Save Changes");
        
        cancelButton.setOnAction((ActionEvent e) -> {
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Quiz Management");
            confirmationAlert.setContentText("Discard changes?");
            
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.get() == ButtonType.OK){
                try {
                    Scene quizScene = manageQuizScene();
                    thestage.setScene(quizScene);
                } catch (IOException ex) {
                    Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        saveButton.setOnAction((ActionEvent e) -> {
            Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Quiz Management");
            confirmationAlert.setContentText("Save changes?");
            
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.get() == ButtonType.OK){
                try {
                    CSVWriter writer = new CSVWriter(new FileWriter("topic4.csv", false));
                    
                    String topicTitleValue[] = new String[] {topicTitle.getText()};
                
                    String q0Array[] = new String[] {
                        question0.getText(),
                        answer0.getText(),
                        incorrect1_0.getText(),
                        incorrect2_0.getText(),
                        incorrect3_0.getText()
                    };

                    String q1Array[] = new String[] {
                        question1.getText(),
                        answer1.getText(),
                        incorrect1_1.getText(),
                        incorrect2_1.getText(),
                        incorrect3_1.getText()
                    };
                    
                    String q2Array[] = new String[] {
                        question2.getText(),
                        answer2.getText(),
                        incorrect1_2.getText(),
                        incorrect2_2.getText(),
                        incorrect3_2.getText()
                    };

                    String q3Array[] = new String[] {
                        question3.getText(),
                        answer3.getText(),
                        incorrect1_3.getText(),
                        incorrect2_3.getText(),
                        incorrect3_3.getText()
                    };

                    String q4Array[] = new String[] {
                        question4.getText(),
                        answer4.getText(),
                        incorrect1_4.getText(),
                        incorrect2_4.getText(),
                        incorrect3_4.getText()
                    };

                    String q5Array[] = new String[] {
                        question5.getText(),
                        answer5.getText(),
                        incorrect1_5.getText(),
                        incorrect2_5.getText(),
                        incorrect3_5.getText()
                    };

                    String q6Array[] = new String[] {
                        question6.getText(),
                        answer6.getText(),
                        incorrect1_6.getText(),
                        incorrect2_6.getText(),
                        incorrect3_6.getText()
                    };

                    String q7Array[] = new String[] {
                        question7.getText(),
                        answer7.getText(),
                        incorrect1_7.getText(),
                        incorrect2_7.getText(),
                        incorrect3_7.getText()
                    };

                    String q8Array[] = new String[] {
                        question8.getText(),
                        answer8.getText(),
                        incorrect1_8.getText(),
                        incorrect2_8.getText(),
                        incorrect3_8.getText()
                    };

                    String q9Array[] = new String[] {
                        question9.getText(),
                        answer9.getText(),
                        incorrect1_9.getText(),
                        incorrect2_9.getText(),
                        incorrect3_9.getText()
                    };

                    writer.writeNext(topicTitleValue);
                    writer.writeNext(q0Array);
                    writer.writeNext(q1Array);
                    writer.writeNext(q2Array);
                    writer.writeNext(q3Array);
                    writer.writeNext(q4Array);
                    writer.writeNext(q5Array);
                    writer.writeNext(q6Array);
                    writer.writeNext(q7Array);
                    writer.writeNext(q8Array);
                    writer.writeNext(q9Array);
                    writer.close();
                    
                    Scene quizScene = manageQuizScene();
                    thestage.setScene(quizScene);
                    
                } catch (IOException ex) {
                    Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
                }

        }});
        
        cancelButton.setPrefWidth(200);
        saveButton.setPrefWidth(200);
        
        GridPane.setHalignment(cancelButton, HPos.RIGHT);
        
        gridpane.add(cancelButton, 2, 32, 1, 1);
        gridpane.add(saveButton, 3, 32, 1, 1);
        
        for (int i = 0; i <= 32; i++) {
            RowConstraints rowC = new RowConstraints();
            rowC.setPrefHeight(30);
            gridpane.getRowConstraints().add(rowC);
        }
        
        root0.setPrefSize(1200, 800);
        root0.setFitToWidth(true);
        root0.setContent(gridpane);
        
        return new Scene(root0, 1200, 800);
    }

    
}
