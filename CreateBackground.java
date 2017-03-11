package excelWriter;

import java.util.Random;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateBackground {
	  
	//public void start(Stage primaryStage) throws Exception {

	public static Scene createBackground(){
		
		Group root = new Group();
		Scene scene = new Scene(root, 1500,900);
		Random rand = new Random(System.currentTimeMillis());
		
		int red = 0;
		int blue = 0;
		int green = 0;	
		int rot = 0;
		
		
		for (int i=0; i<500; i++){
			int x = rand.nextInt((int) scene.getWidth());
			int y = rand.nextInt(200);
			red = rand.nextInt(100);
			green = rand.nextInt(200);
			blue = rand.nextInt(200);	
			rot = rand.nextInt(360);
			
			Text text = new Text(x,y, "quiz");
			Font serifSmall = new Font ("Serif", 18);
			text.setFont(serifSmall);
			text.setFill(Color.rgb(red, blue, green, .4));
			text.setRotate(rot);
			root.getChildren().add(text);
			
		}
		

		Text text2 = new Text(570,120,"Statistics");
		text2.setFont(Font.font("Serif", FontWeight.BOLD, 80));		
		root.getChildren().add(text2);
		return scene;

}
	
	
	
	
	public static Scene createBackground(String backgroundText, int fontSize){
	
		Group root = new Group();
		Scene scene = new Scene(root, 1500,900);
		Random rand = new Random(System.currentTimeMillis());
		
		int red = 0;
		int blue = 0;
		int green = 0;	
		int rot = 0;
		
		
		for (int i=0; i<500; i++){
			int x = rand.nextInt((int) scene.getWidth());
			int y = rand.nextInt(200);
			red = rand.nextInt(100);
			green = rand.nextInt(200);
			blue = rand.nextInt(200);	
			rot = rand.nextInt(360);
			
			Text text = new Text(x,y, backgroundText);
			Font serifSmall = new Font ("Serif", fontSize);
			text.setFont(serifSmall);
			text.setFill(Color.rgb(red, blue, green, .4));
			text.setRotate(rot);
			root.getChildren().add(text);
			
		}
		

		Text text2 = new Text(570,120,"Statistics");
		text2.setFont(Font.font("Serif", FontWeight.BOLD, 80));		
		root.getChildren().add(text2);
		return scene;

}
	
	
	public static Scene createBackground(int fontSize){
		
		Group root = new Group();
		Scene scene = new Scene(root, 1500,900);
		Random rand = new Random(System.currentTimeMillis());
		
		int red = 0;
		int blue = 0;
		int green = 0;	
		int rot = 0;
		
		
		for (int i=0; i<500; i++){
			int x = rand.nextInt((int) scene.getWidth());
			int y = rand.nextInt(200);
			red = rand.nextInt(100);
			green = rand.nextInt(200);
			blue = rand.nextInt(200);	
			rot = rand.nextInt(360);
			
			Text text = new Text(x,y, "Quiz");
			Font serifSmall = new Font ("Serif", fontSize);
			text.setFont(serifSmall);
			text.setFill(Color.rgb(red, blue, green, .4));
			text.setRotate(rot);
			root.getChildren().add(text);
			
		}
		

		Text text2 = new Text(570,120,"Statistics");
		text2.setFont(Font.font("Serif", FontWeight.BOLD, 80));		
		root.getChildren().add(text2);
		return scene;

}	

	public static Scene createBackground(String backgroundText){
		
		Group root = new Group();
		Scene scene = new Scene(root, 1500,900);
		Random rand = new Random(System.currentTimeMillis());
		
		int red = 0;
		int blue = 0;
		int green = 0;	
		int rot = 0;
		
		
		for (int i=0; i<500; i++){
			int x = rand.nextInt((int) scene.getWidth());
			int y = rand.nextInt(200);
			red = rand.nextInt(100);
			green = rand.nextInt(200);
			blue = rand.nextInt(200);	
			rot = rand.nextInt(360);
			
			Text text = new Text(x,y, backgroundText);
			Font serifSmall = new Font ("Serif", 16);
			text.setFont(serifSmall);
			text.setFill(Color.rgb(red, blue, green, .4));
			text.setRotate(rot);
			root.getChildren().add(text);
			
		}
		

		Text text2 = new Text(570,120,"Quiz");
		text2.setFont(Font.font("Serif", FontWeight.BOLD, 80));		
		root.getChildren().add(text2);
		return scene;

}	

   public static void drawBackground(Stage primaryStage, Scene scene){
		primaryStage.setScene(scene);
		primaryStage.setTitle("Interactive Quiz");
		primaryStage.show();
  }
}