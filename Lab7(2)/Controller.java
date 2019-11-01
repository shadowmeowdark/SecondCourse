package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Controller {
    @FXML
    public TextField outX;

    @FXML
    public TextField outY;

    @FXML
    public Label answer;

    @FXML
    public Button button;

    @FXML
    void initialize() {
        button.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        double x, y;
                        try {
                            x = Double.parseDouble(outX.getText());
                            y = Double.parseDouble(outY.getText());
                            if (checking(x, y)) {
                                answer.setText("Точка (" + x + "; " + y + ") лежит в этой области");
                                answer.setTextFill(Color.BLUE);
                            } else {
                                answer.setText("Точка (" + x + "; " + y + ") не попала в эту область");
                                answer.setTextFill(Color.RED);
                            }
                        } catch (NumberFormatException ex) {
                            answer.setText("Некорректный ввод");
                        }
                    }
                }
        );
    }

    public boolean checking(double x, double y) {
        boolean answer = false;
        if (x >= 0 && x <= 3) {
            if (x * x + y * y <= 36) answer = true;
            else answer = false;
        } else if (x >= -3 && x <= 0) {
            if (y >= 0 && y <= 6) {
                if (y <= 2 * x + 6) answer = true;
                else answer = false;
            }
        } else answer = false;
        return answer;
    }
}
