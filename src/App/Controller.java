package App;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class Controller {


    @FXML
    VBox entriesLIst;

    @FXML
    public void initialize(){

        try {
            ConnectionClass connectionClass = new ConnectionClass();
            Connection conn = connectionClass.getConnection();
            Statement statement = conn.createStatement();
            ResultSet list = statement.executeQuery("SELECT * FROM timeline WHERE user='Kiran';" );
            while (list.next()){
                entriesLIst.getChildren().add(new FeedBox(list.getString("date"),list.getString("time"),list.getString("text")));
            }
            statement.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("SQLException");
        }


    }

    @FXML
    public void OnClick_newEntryButton(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("newEntryWindow.fxml"));
        Stage newEntryWindow = new Stage();
        newEntryWindow.setTitle("New Entry");
        newEntryWindow.setScene(new Scene(root, 600, 433));
        newEntryWindow.setResizable(false);

        newEntryWindow.show();

        newEntryWindow.setOnCloseRequest(e -> {
            newEntryWindow.close();
            System.out.println("NewEntry Window Exited with X button");
        });
        System.out.println("onClick:Button@newEntryButton");
    }



}