package App;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.YearMonth;


public class Controller {

    @FXML
    VBox feedVBox;
    @FXML
    Pane calendarPane;
    @FXML
    VBox calendarVBox;
    int calendarCount;
    @FXML
    void initialize(){
        try {
            ConnectionClass connectionClass = new ConnectionClass();
            Connection conn = connectionClass.getConnection();
            Statement statement = conn.createStatement();
            ResultSet list = statement.executeQuery("SELECT * FROM timeline WHERE user='Kiran';" );

            while (list.next()) {
                try {
                    TextFlow textField;
                    Text dateField,timeField;
                    VBox element = FXMLLoader.load(getClass().getResource("FeedBox.fxml"));
                    dateField=new Text(String.valueOf(list.getString("date")));
                    timeField=new Text(String.valueOf(list.getString("time")));
                    textField=new TextFlow(new Text(list.getString("text")));
                    element.getChildren().addAll(dateField,timeField,textField);
                    feedVBox.getChildren().add(element);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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


    public void loadCalendar(Event event) {
        calendarCount++;
        if(calendarCount==1) {
            System.out.println("onClick:Pane@Calendar");
            VBox vb = new FullCalendarView(YearMonth.now()).getView();
            calendarVBox.getChildren().add(vb);
        }
    }

//    public void closeCalendar(Event event) {
//        System.out.println("Calendar Closed");
//    }
}