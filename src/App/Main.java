package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        window=primaryStage;
        primaryStage.setTitle("My Journal");
        primaryStage.setScene(new Scene(root, 720, 600));
        primaryStage.show();
        //primaryStage.setOnCloseRequest(event -> closeProgram());
    }

   /* public void closeProgram(){
        // Check if all sub-windows are closed then
        System.out.println("Main Window Closed");
        window.close();
    }
*/
   public static void main(String[] args) {
        launch(args);
    }
}
