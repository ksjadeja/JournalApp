package App;


import com.sun.javafx.scene.control.skin.FXVK;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ParallelCamera;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import jdk.jshell.EvalException;

import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class FeedBox extends Region {

    private String id;
    private VBox feedbox;
    private Text dateField,timeField;
    private TextArea textField;
    private Button editEntry;

    public FeedBox(String feed_id,String date,String time,String text){
        id = new String(feed_id);
        dateField = new Text(date);
        timeField = new Text(time);
        textField = new TextArea(text);
        editEntry = new Button("Edit");

        dateField.setTextAlignment(TextAlignment.LEFT);
        dateField.setFont(Font.font("Times New Roman Italic",14));
        timeField.setTextAlignment(TextAlignment.LEFT);
        timeField.setFont(Font.font("Times New Roman Italic",14));
        textField.setPrefSize(200,200);
        textField.setEditable(false);
        editEntry.setVisible(false);

        editEntry.addEventHandler(MouseEvent.MOUSE_CLICKED,e -> {
            try {
                Dialog<ButtonType> editEntryWindow = new Dialog<>();
                editEntryWindow.initOwner(feedbox.getScene().getWindow());
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("EditEntryDialog.fxml"));
                editEntryWindow.getDialogPane().setContent(loader.load());
                EditEntryController editEntryController = loader.getController();
                editEntryController.setId(id);
                editEntryWindow.getDialogPane().getButtonTypes().add(ButtonType.OK);
                editEntryWindow.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
                editEntryWindow.show();

            }catch (IOException ex){
                ex.printStackTrace();
            }

        });

        HBox header = new HBox(15,editEntry,dateField,timeField);
        header.setPadding(new Insets(5,15,5,10));
        header.fillHeightProperty();
        header.setAlignment(Pos.TOP_RIGHT);

        feedbox = new VBox(10,header,textField);
        feedbox.setPadding(new Insets(10,10,10,10));
        feedbox.setPrefSize(700,150);
        feedbox.addEventHandler(MouseEvent.MOUSE_ENTERED,e->setEditEntryVisibility(true));
        feedbox.addEventHandler(MouseEvent.MOUSE_EXITED,e->setEditEntryVisibility(false));


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

    public String get_id(){
        return id;
    }

    public String toString(){
        return textField.getText();
    }

    public void setEditEntryVisibility(boolean flag){
        editEntry.setVisible(flag);
    }

    /*public void onClick_editEntry(MouseEvent event){
            public void handle(MouseEvent event){

        }
    }*/

}
