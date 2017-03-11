package excelWriter;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ShowStats extends Application{
	public static void main(String[] args){
		launch (args);
		}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = CreateBackground.createBackground("Comsci");

		DrawMenu.makeMenu(scene);
		
		DrawPieChart.makePie(scene);
		
		CreateBackground.drawBackground(primaryStage, scene);
		
	}
	
}
		