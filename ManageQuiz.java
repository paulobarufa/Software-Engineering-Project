/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managequiz;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
        
        Label topLabel = new Label("Quiz Management");
        
        Button buttonTopic1 = new Button(topic0.name);
        Button buttonTopic2 = new Button(topic1.name);
        Button buttonTopic3 = new Button(topic2.name);
        Button buttonTopic4 = new Button(topic3.name);
        Button buttonTopic5 = new Button(topic4.name);
        
        buttonTopic1.setOnAction(e-> {
            try {
                ButtonClicked0(e);
            } catch (IOException ex) {
                Logger.getLogger(ManageQuiz.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        
        buttonTopic1.setPrefWidth(200);
        buttonTopic2.setPrefWidth(200);
        buttonTopic3.setPrefWidth(200);
        buttonTopic4.setPrefWidth(200);
        buttonTopic5.setPrefWidth(200);
        
        vbox.getChildren().addAll(
                topLabel,
                buttonTopic1,
                buttonTopic2,
                buttonTopic3,
                buttonTopic4,
                buttonTopic5
        );
        
        vbox.setAlignment(Pos.CENTER);
        root.setCenter(vbox);
        BorderPane.setAlignment(vbox, Pos.CENTER);
        
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
        BorderPane root0 = new BorderPane();
        
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
        
        Label label0 = new Label("Question 1");
        GridPane.setHalignment(label0, HPos.CENTER);
        gridpane.add(label0, 0, 1, 1, 1);
        
        TextField question0 = new TextField(topic0.questions.get(0).question);
        TextField answer0 = new TextField(topic0.questions.get(0).answer);
        TextField incorrect1_0 = new TextField(topic0.questions.get(0).incorrect1);
        TextField incorrect2_0 = new TextField(topic0.questions.get(0).incorrect2);
        TextField incorrect3_0 = new TextField(topic0.questions.get(0).incorrect3);
        
        gridpane.add(topicTitle, 1, 0, 2, 1);
        gridpane.add(question0, 1, 1, 2, 1);
        gridpane.add(answer0, 0, 2, 1, 1);
        gridpane.add(incorrect1_0, 1, 2, 1, 1);
        gridpane.add(incorrect2_0, 2, 2, 1, 1);
        gridpane.add(incorrect3_0, 3, 2, 1, 1);
        
        Label label1 = new Label("Question 2");
        GridPane.setHalignment(label1, HPos.CENTER);
        gridpane.add(label1, 0, 3, 1, 1);
        
        TextField question1 = new TextField(topic0.questions.get(1).question);
        TextField answer1 = new TextField(topic0.questions.get(1).answer);
        TextField incorrect1_1 = new TextField(topic0.questions.get(1).incorrect1);
        TextField incorrect2_1 = new TextField(topic0.questions.get(1).incorrect2);
        TextField incorrect3_1 = new TextField(topic0.questions.get(1).incorrect3);
        
        gridpane.add(question1, 1, 3, 2, 1);
        gridpane.add(answer1, 0, 4, 1, 1);
        gridpane.add(incorrect1_1, 1, 4, 1, 1);
        gridpane.add(incorrect2_1, 2, 4, 1, 1);
        gridpane.add(incorrect3_1, 3, 4, 1, 1);
        
        Label label2 = new Label("Question 3");
        GridPane.setHalignment(label2, HPos.CENTER);
        gridpane.add(label2, 0, 5, 1, 1);
        
        TextField question2 = new TextField(topic0.questions.get(2).question);
        TextField answer2 = new TextField(topic0.questions.get(2).answer);
        TextField incorrect1_2 = new TextField(topic0.questions.get(2).incorrect1);
        TextField incorrect2_2 = new TextField(topic0.questions.get(2).incorrect2);
        TextField incorrect3_2 = new TextField(topic0.questions.get(2).incorrect3);
        
        gridpane.add(question2, 1, 5, 2, 1);
        gridpane.add(answer2, 0, 6, 1, 1);
        gridpane.add(incorrect1_2, 1, 6, 1, 1);
        gridpane.add(incorrect2_2, 2, 6, 1, 1);
        gridpane.add(incorrect3_2, 3, 6, 1, 1);
        
        Label label3 = new Label("Question 4");
        GridPane.setHalignment(label3, HPos.CENTER);
        gridpane.add(label3, 0, 7, 1, 1);
        
        TextField question3 = new TextField(topic0.questions.get(3).question);
        TextField answer3 = new TextField(topic0.questions.get(3).answer);
        TextField incorrect1_3 = new TextField(topic0.questions.get(3).incorrect1);
        TextField incorrect2_3 = new TextField(topic0.questions.get(3).incorrect2);
        TextField incorrect3_3 = new TextField(topic0.questions.get(3).incorrect3);
        
        gridpane.add(question3, 1, 7, 2, 1);
        gridpane.add(answer3, 0, 8, 1, 1);
        gridpane.add(incorrect1_3, 1, 8, 1, 1);
        gridpane.add(incorrect2_3, 2, 8, 1, 1);
        gridpane.add(incorrect3_3, 3, 8, 1, 1);
        
        Label label4 = new Label("Question 5");
        GridPane.setHalignment(label4, HPos.CENTER);
        gridpane.add(label4, 0, 9, 1, 1);
        
        TextField question4 = new TextField(topic0.questions.get(4).question);
        TextField answer4 = new TextField(topic0.questions.get(4).answer);
        TextField incorrect1_4 = new TextField(topic0.questions.get(4).incorrect1);
        TextField incorrect2_4 = new TextField(topic0.questions.get(4).incorrect2);
        TextField incorrect3_4 = new TextField(topic0.questions.get(4).incorrect3);
        
        gridpane.add(question4, 1, 9, 2, 1);
        gridpane.add(answer4, 0, 10, 1, 1);
        gridpane.add(incorrect1_4, 1, 10, 1, 1);
        gridpane.add(incorrect2_4, 2, 10, 1, 1);
        gridpane.add(incorrect3_4, 3, 10, 1, 1);
        
        Label label5 = new Label("Question 6");
        GridPane.setHalignment(label5, HPos.CENTER);
        gridpane.add(label5, 0, 11, 1, 1);
        
        TextField question5 = new TextField(topic0.questions.get(5).question);
        TextField answer5 = new TextField(topic0.questions.get(5).answer);
        TextField incorrect1_5 = new TextField(topic0.questions.get(5).incorrect1);
        TextField incorrect2_5 = new TextField(topic0.questions.get(5).incorrect2);
        TextField incorrect3_5 = new TextField(topic0.questions.get(5).incorrect3);
        
        gridpane.add(question5, 1, 11, 2, 1);
        gridpane.add(answer5, 0, 12, 1, 1);
        gridpane.add(incorrect1_5, 1, 12, 1, 1);
        gridpane.add(incorrect2_5, 2, 12, 1, 1);
        gridpane.add(incorrect3_5, 3, 12, 1, 1);
        
        Label label6 = new Label("Question 7");
        GridPane.setHalignment(label6, HPos.CENTER);
        gridpane.add(label6, 0, 13, 1, 1);
        
        TextField question6 = new TextField(topic0.questions.get(6).question);
        TextField answer6 = new TextField(topic0.questions.get(6).answer);
        TextField incorrect1_6 = new TextField(topic0.questions.get(6).incorrect1);
        TextField incorrect2_6 = new TextField(topic0.questions.get(6).incorrect2);
        TextField incorrect3_6 = new TextField(topic0.questions.get(6).incorrect3);
        
        gridpane.add(question6, 1, 13, 2, 1);
        gridpane.add(answer6, 0, 14, 1, 1);
        gridpane.add(incorrect1_6, 1, 14, 1, 1);
        gridpane.add(incorrect2_6, 2, 14, 1, 1);
        gridpane.add(incorrect3_6, 3, 14, 1, 1);
        
        Label label7 = new Label("Question 8");
        GridPane.setHalignment(label7, HPos.CENTER);
        gridpane.add(label7, 0, 15, 1, 1);
        
        TextField question7 = new TextField(topic0.questions.get(7).question);
        TextField answer7 = new TextField(topic0.questions.get(7).answer);
        TextField incorrect1_7 = new TextField(topic0.questions.get(7).incorrect1);
        TextField incorrect2_7 = new TextField(topic0.questions.get(7).incorrect2);
        TextField incorrect3_7 = new TextField(topic0.questions.get(7).incorrect3);
        
        gridpane.add(question7, 1, 15, 2, 1);
        gridpane.add(answer7, 0, 16, 1, 1);
        gridpane.add(incorrect1_7, 1, 16, 1, 1);
        gridpane.add(incorrect2_7, 2, 16, 1, 1);
        gridpane.add(incorrect3_7, 3, 16, 1, 1);
        
        Label label8 = new Label("Question 9");
        GridPane.setHalignment(label8, HPos.CENTER);
        gridpane.add(label8, 0, 17, 1, 1);
        
        TextField question8 = new TextField(topic0.questions.get(8).question);
        TextField answer8 = new TextField(topic0.questions.get(8).answer);
        TextField incorrect1_8 = new TextField(topic0.questions.get(8).incorrect1);
        TextField incorrect2_8 = new TextField(topic0.questions.get(8).incorrect2);
        TextField incorrect3_8 = new TextField(topic0.questions.get(8).incorrect3);
        
        gridpane.add(question8, 1, 17, 2, 1);
        gridpane.add(answer8, 0, 18, 1, 1);
        gridpane.add(incorrect1_8, 1, 18, 1, 1);
        gridpane.add(incorrect2_8, 2, 18, 1, 1);
        gridpane.add(incorrect3_8, 3, 18, 1, 1);
        
        Label label9 = new Label("Question 10");
        GridPane.setHalignment(label9, HPos.CENTER);
        gridpane.add(label9, 0, 19, 1, 1);
        
        TextField question9 = new TextField(topic0.questions.get(9).question);
        TextField answer9 = new TextField(topic0.questions.get(9).answer);
        TextField incorrect1_9 = new TextField(topic0.questions.get(9).incorrect1);
        TextField incorrect2_9 = new TextField(topic0.questions.get(9).incorrect2);
        TextField incorrect3_9 = new TextField(topic0.questions.get(9).incorrect3);
        
        gridpane.add(question9, 1, 19, 2, 1);
        gridpane.add(answer9, 0, 20, 1, 1);
        gridpane.add(incorrect1_9, 1, 20, 1, 1);
        gridpane.add(incorrect2_9, 2, 20, 1, 1);
        gridpane.add(incorrect3_9, 3, 20, 1, 1);
        
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
        
        gridpane.add(cancelButton, 2, 21, 1, 1);
        gridpane.add(saveButton, 3, 21, 1, 1);
        
        root0.setCenter(gridpane);
        
        return new Scene(root0, 1200, 800);
    }
    
}
