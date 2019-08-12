package App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

    @FXML
    public void OnClick_newEntryButton() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("NewEntryWindow.fxml"));
        Stage NewEntryWindow = new Stage();
        NewEntryWindow.setTitle("New Entry");
        NewEntryWindow.setScene(new Scene(root, 600, 433));
        NewEntryWindow.show();
        System.out.println("onClick:Button@newEntryButton");
    }


}