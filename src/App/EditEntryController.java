package App;

import Connectivity.ConnectionClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.print.DocFlavor;
import java.net.PortUnreachableException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EditEntryController {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @FXML
    public Text timeText,dateText;
//    public Button submitButton;
    public TextArea textArea;
    public String Id;
    public VBox newEntryBox;

    public void initialize(){
        dateText.setText(LocalDate.now().toString());
        timeText.setText(formatter.format(LocalTime.now()));
        textArea.setText("");
//        submitButton.setDisable(true);
    }

//    public void OnKeyReleaseCheckText(){
//        String text = textArea.getText();
//        boolean disableButton = text.isEmpty();
//        submitButton.setDisable(disableButton);
//    }

    public void OnClick_OKButton(){
        String TABLE_NAME="timeline";
        String USER_NAME="Kiran";
        String TEXT_DATA;
        String FEED_ID= Id;
//        String DATE= LocalDate.now().toString();
//        String TIME = formatter.format(LocalTime.now());
        TEXT_DATA = textArea.getText();

        try {
            ConnectionClass connectionClass = new ConnectionClass();
            Connection conn = connectionClass.getConnection();
            Statement statement = conn.createStatement();
            statement.execute("UPDATE "+ TABLE_NAME + " SET (text) VALUES('" + TEXT_DATA + "')" + " WHERE ID="+ FEED_ID + ";");
            statement.close();
            conn.close();
        }catch (SQLException e){
            System.out.println("MySQL db conn error");
            e.printStackTrace();
        }
        System.out.println("onClick:Button@submitButton");
        System.out.println("NewEntry Window closed with submit button");
    }

}
