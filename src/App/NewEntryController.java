package App;
import Connectivity.ConnectionClass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class NewEntryController implements Initializable {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @FXML
    public Text timeText,dateText;
    public Button submitButton,alertYes,alertNo;
    public TextArea textArea;
    public AnchorPane alertBox;
    public VBox newEntryBox;
    private Stage window;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        dateText.setText(LocalDate.now().toString());
        timeText.setText(formatter.format(LocalTime.now()));
        submitButton.setDisable(true);
    }

    public void OnKeyReleaseCheckText(){
        String text = textArea.getText();
        boolean disableButton = text.isEmpty();
        submitButton.setDisable(disableButton);
    }

    public void OnClick_submitButton(){
        String TABLE_NAME="timeline";
        String USER_NAME="Kiran";
        String TEXT_DATA;
        String DATE= LocalDate.now().toString();
        String TIME = formatter.format(LocalTime.now());
        TEXT_DATA = textArea.getText();

        try {
            ConnectionClass connectionClass = new ConnectionClass();
            Connection conn = connectionClass.getConnection();
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO "+ TABLE_NAME + " (user,date,time,text) VALUES('" + USER_NAME + "','" + DATE + "','"+ TIME + "','" + TEXT_DATA + "')" );
            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("MySQL db conn error");
            e.printStackTrace();
        }
        System.out.println("onClick:Button@submitButton");
        Stage stage = (Stage)submitButton.getScene().getWindow();
        stage.close();
    }

  /*  public void closeProgram(Stage stage){
        stage.close();
    }

    public void OnClick_alertButtons(ActionEvent event){
        window = (Stage) newEntryBox.getScene().getWindow();
        if(event.equals(alertYes)){
            closeProgram((Stage)alertYes.getScene().getWindow());
            window.close();
        }
        if(event.equals(alertNo)){
            closeProgram((Stage)alertYes.getScene().getWindow());
        }

    }*/
}
