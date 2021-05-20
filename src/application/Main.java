package application;
	
import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/DesignFxml.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("CSV 변환 프로그램");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
