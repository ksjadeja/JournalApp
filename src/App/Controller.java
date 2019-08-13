package App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.beans.EventHandler;

public class Controller {

    Stage NewEntryWin;

    @FXML
    public void OnClick_newEntryButton() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("NewEntryWindow.fxml"));
        Stage NewEntryWindow = new Stage();
        NewEntryWin=NewEntryWindow;
        NewEntryWindow.setTitle("New Entry");
        NewEntryWindow.setScene(new Scene(root, 600, 433));
        NewEntryWindow.show();
        //NewEntryWindow.setOnCloseRequest(event -> closeProgram());
        System.out.println("onClick:Button@newEntryButton");
    }

    /*public void closeProgram(){
        System.out.println("NewEntryWin Closed");
        NewEntryWin.close();
    }*/



}