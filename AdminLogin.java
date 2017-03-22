import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AdminLogin extends Application {
	
	Label title_txt;
	Button login_btn;
	Label user_txt;
	TextField user_fld;
	Label pwd_txt;
	TextField pwd_fld;
	Label prompt_txt;
	
	String User1 = "admin";
	String Pwd1 = "adminpw";
	String temp1 = "";
	String temp2 = "";
	
	public void start(Stage adminstage) throws Exception {
		
		title_txt = new Label("Admin Login");
		user_txt = new Label("Username");
		user_fld = new TextField("");
		pwd_txt = new Label("Password");
		pwd_fld = new TextField("");
		login_btn = new Button("Log In");
		prompt_txt = new Label("");
		
		login_btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent args){
				temp1 = user_fld.getText();
				temp2 = pwd_fld.getText();
				
				if (temp1.equals(User1) && temp2.equals(Pwd1)) {
					// if login success
					prompt_txt.setText("Welcome!");
					System.out.println("temp1: " + temp1 + " temp2: " + temp2 + "  User1: " + User1 + " Pwd1: " + Pwd1);
					// link to manage quiz
					// Scene firstScene = firstTopicScene();
					// thestage.setScene(firstScene);
					
				} else {
					// if login fail
					prompt_txt.setText("Incorrect Username or Password");
					System.out.println("temp1: " + temp1 + " temp2: " + temp2 + "  User1: " + User1 + " Pwd1: " + Pwd1);
				}
			}
		});
		
		
		VBox root = new VBox();
		root.getChildren().addAll(title_txt, user_txt, user_fld, pwd_txt, pwd_fld, login_btn, prompt_txt);
		
		Scene scene = new Scene(root);
		adminstage.setScene(scene);
		adminstage.setWidth(1200);
		adminstage.setHeight(800);
		adminstage.setTitle("Interactive Quiz - Admin Login");
		
		
		
		adminstage.show();
	}
}
