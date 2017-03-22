import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class StartQuiz extends Application {
	
	Label main_txt;
	Button start_btn;
	Button admin_btn;
	
	public void start(Stage startstage) throws Exception {
		main_txt = new Label("Welcome to the Interactive Quiz!");
		start_btn = new Button("Start Quiz");
		admin_btn = new Button("Admin Login");
		
		start_btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent args){
				// Link to Start Quiz
			}
		});
		
		admin_btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent args){
				// Link to Admin Start Page ?
				Application.launch(AdminLogin.class);
				// Scene AdminLoginScene = firstTopicScene();
				// thestage.setScene(AdminLoginScene);
			}
		});
		
		VBox root = new VBox();
		root.getChildren().addAll(main_txt, start_btn, admin_btn);
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root);
		
		startstage.setScene(scene);
		startstage.setWidth(1200);
		startstage.setHeight(800);
		startstage.setTitle("Interactive Quiz - Start Quiz");
		
		main_txt.setFont(Font.font ("Comic Sans MS", 24));
		
		startstage.show();
	}
}
