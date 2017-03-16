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
	TextField user_fld;
	TextField pwd_fld;
	Label prompt_txt;
	
	String User1 = "rick";
	String Pwd1 = "astley";
	String temp1 = "";
	String temp2 = "";
	
	public void start(Stage adminstage) throws Exception {
		title_txt = new Label("Admin Login");
		user_fld = new TextField("Name");
		pwd_fld = new TextField("Password");
		login_btn = new Button("Log In");
		prompt_txt = new Label("");
		
		login_btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent args){
				temp1 = user_fld.getText();
				temp2 = pwd_fld.getText();
				
				if (temp1 == User1 && temp2 == Pwd1) {
					// if login success
					prompt_txt.setText("Welcome!");
					
				} else {
					// if login fail
					prompt_txt.setText("Incorrect Username or Password");
					
				}
			}
		});
		
		
		VBox root = new VBox();
		root.getChildren().addAll(title_txt, user_fld, pwd_fld, login_btn, prompt_txt);
		
		Scene scene = new Scene(root);
		adminstage.setScene(scene);
		adminstage.setWidth(200);
		adminstage.setHeight(200);
		adminstage.setTitle("Interactive Quiz - Admin Login");
		
		
		
		adminstage.show();
	}
}