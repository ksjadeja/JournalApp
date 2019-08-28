package App;


import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class FeedBox extends Region {

    private VBox feedbox;
    private Text dateField,timeField;
    private TextArea textField;

    public FeedBox(String date,String time,String text){
        dateField = new Text(date);
        timeField = new Text(time);
        textField = new TextArea(text);

        dateField.setTextAlignment(TextAlignment.LEFT);
        dateField.setFont(Font.font("Times New Roman Italic",14));
        timeField.setTextAlignment(TextAlignment.LEFT);
        timeField.setFont(Font.font("Times New Roman Italic",14));
        textField.setPrefSize(200,200);
        textField.setEditable(false);

        HBox header = new HBox(15,dateField,timeField);
        header.setPadding(new Insets(5,15,5,10));
        header.fillHeightProperty();
        header.setAlignment(Pos.TOP_RIGHT);

        feedbox = new VBox(10,header,textField);
        feedbox.setPadding(new Insets(10,10,10,10));
        feedbox.setPrefSize(700,150);
        getChildren().add(feedbox);
    }

    public String getDateField() {
        return dateField.getText();
    }

    public String getTimeField() {
        return timeField.getText();
    }

    public String getTextField() {
        return textField.getText();
    }

    public String toString(){
        return textField.getText();
    }

//    public void setOnClickAction(){
//        feedbox.setOnMouseClicked();
//    }
}
