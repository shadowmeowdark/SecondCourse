package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    public TextField a;

    @FXML
    public TextField b;

    @FXML
    public TextField c;

    @FXML
    public Button button;

    @FXML
    public Label discrim;

    @FXML
    public Label answer;

    @FXML
    void initialize() {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double a1 = 0, b1 = 0, c1 = 0, Disc = 0;
                try {
                    a1 = Double.parseDouble(a.getText());
                    b1 = Double.parseDouble(b.getText());
                    c1 = Double.parseDouble(c.getText());
                    if (a1 == 0) {
                        discrim.setText("a = 0 , это уравнение не квадратное, а линейное");
                        answer.setText("x = " + (-c1/b1));
                    } else {
                        Disc = b1 * b1 - 4 * a1 * c1;
                        Disc = (double) Math.round(Disc * 10) / 10d;
                        discrim.setText("D = " + String.valueOf(Disc));
                    double x1, x2;
                    if (Disc > 0) {
                        x1 = (-1 * b1 + Math.sqrt(Disc)) / 2 * a1;
                        x2 = (-1 * b1 - Math.sqrt(Disc)) / 2 * a1;
                        answer.setText("Корни: x1 = " + x1 + ", x2 = " + x2);
                    } else if (Disc == 0) {
                        x1 = (-1 * b1 - Math.sqrt(Disc)) / 2 * a1;
                        answer.setText("Корень x = " + x1);
                    } else if (Disc < 0) {
                        double re, im, re1;
                        re = -b1 / (2 * a1);
                        im = Math.sqrt(-1 * Disc) / (2 * a1);
                        re = (double) Math.round(re * 10d) / 10d;
                        im = (double) Math.round(im * 10d) / 10d;
                        answer.setText("Корни: x1 = " + re + " + i*" + im + " , x2 = " + re + " - i*" + im);
                    }
                }} catch (NumberFormatException ex) {
                    discrim.setText("Некорректный ввод");
                    answer.setText("");
                }
            }
        });
    }
}
