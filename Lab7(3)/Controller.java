package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML
    private ComboBox<String> box1;

    ObservableList<String> observableList1 = FXCollections.observableArrayList("Кузнечик", "Вася", "Крокодил", "Орел", "Трактор", "Боинг 747", "Слоник");
    @FXML
    private ComboBox<String> box2;

    ObservableList<String> observableList2 = FXCollections.observableArrayList("ушел", "полетел", "побежал", "залез", "уполз", "упрыгал", "умчался");

    @FXML
    private ComboBox<String> box3;

    ObservableList<String> observableList3 = FXCollections.observableArrayList("в кусты", "на дискотеку", "домой", "за пивом", "на Чукотку", "по грибы", "на охоту");

    @FXML
    private TextArea text;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonClose;

    @FXML
    void initialize() {

        box1.setItems(observableList1);
        box2.setItems(observableList2);
        box3.setItems(observableList3);

        buttonClose.setOnAction(e -> Platform.exit());

        buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.appendText(box1.getValue() + " " + box2.getValue() + " " + box3.getValue() + "\n");
            }
        });
    }
}