package App;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class NewEntryController implements Initializable {

    private Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @FXML
    public Text timestampText;
    public Button submitButton;
    public TextArea textArea;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        timestampText.setText(formatter.format(Calendar.getInstance().getTime()));
        submitButton.setDisable(true);
    }

    public void OnKeyReleaseCheckText(){
        String text = textArea.getText();
        boolean disableButton = text.isEmpty();
        submitButton.setDisable(disableButton);
    }

    public void OnClick_submitButton(){
        String text = textArea.getText();
        System.out.println("onClick:Button@submitButton");
    }
}
