package App;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.awt.*;

public class FeedBox extends Region {


    private Text dateField,timeField,text;
    private TextFlow textField;

    public FeedBox(String date,String time,String text){
        dateField = new Text(date);
        timeField = new Text(time);
        this.text = new Text(text);
        textField = new TextFlow(this.text);

        dateField.setTextAlignment(TextAlignment.LEFT);
        dateField.setFont(Font.font("Times New Roman",14));
        timeField.setTextAlignment(TextAlignment.LEFT);
        timeField.setFont(Font.font("Times New Roman",14));
        textField.setPrefSize(200,200);

        HBox header = new HBox(15,dateField,timeField);
        header.setPadding(new Insets(5,15,5,10));
        header.fillHeightProperty();
        header.setAlignment(Pos.TOP_RIGHT);

        VBox feedbox = new VBox(10,header,textField);
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

    public String getText() {
        return this.text.getText();
    }

    public String toString(){
        return this.text.getText();
    }
}
