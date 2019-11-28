package sample;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Tab tab1;

    @FXML
    private Canvas Canvas1;

    @FXML
    private TextField StartX1;

    @FXML
    private TextField StartY1;

    @FXML
    private TextField EndX1;

    @FXML
    private TextField EndY1;

    @FXML
    private Button draw1;

    @FXML
    private Tab tab2;

    @FXML
    private Canvas Canvas2;

    @FXML
    private TextField StartX2;

    @FXML
    private TextField StartY2;

    @FXML
    private TextField EndX2;

    @FXML
    private TextField EndY2;

    @FXML
    private Button draw2;

    @FXML
    private Tab tab3;

    @FXML
    private Canvas Canvas3;

    @FXML
    private TextField StartX3;

    @FXML
    private TextField StartY3;

    @FXML
    private TextField EndX3;

    @FXML
    private TextField EndY3;

    @FXML
    private Button draw3;

    @FXML
    private Tab tab4;

    @FXML
    private Canvas Canvas4;

    @FXML
    private TextField StartX4;

    @FXML
    private TextField StartY4;

    @FXML
    private TextField StartZ4;

    @FXML
    private TextField EndX4;

    @FXML
    private TextField EndY4;

    @FXML
    private TextField EndZ4;

    @FXML
    private Button draw4;

    @FXML
    void initialize() {
        draw1.setOnAction(new EventHandler<ActionEvent>() {
            GraphicsContext gcFirstTabPane = Canvas1.getGraphicsContext2D();

            @Override
            public void handle(ActionEvent e) {
                double x, y, x1, y1;
                try {
                    x = Double.parseDouble(StartX1.getText());
                    y = Double.parseDouble(StartY1.getText());
                    x1 = Double.parseDouble(EndX1.getText());
                    y1 = Double.parseDouble(EndY1.getText());
                    gcFirstTabPane.clearRect(0, 0, 465, 340);
                    gcFirstTabPane.strokeLine(x, y, x1, y1);
                } catch (NumberFormatException ex) {
                    System.out.println("Некорректный ввод");
                }
            }
        });

        draw2.setOnAction(new EventHandler<ActionEvent>() {
            GraphicsContext gcSecondTabPane = Canvas2.getGraphicsContext2D();

            @Override
            public void handle(ActionEvent actionEvent) {
                double x, y, x1, y1;
                try {
                    x = Double.parseDouble(StartX2.getText());
                    y = Double.parseDouble(StartY2.getText());
                    x1 = Double.parseDouble(EndX2.getText());
                    y1 = Double.parseDouble(EndY2.getText());
                    gcSecondTabPane.clearRect(0, 0, 465, 340);
                    gcSecondTabPane.strokeRect(x, y, x1 - x, y1 - y);
                } catch (NumberFormatException ex) {
                    System.out.println("Некорректный ввод");
                }
            }
        });

        draw3.setOnAction(new EventHandler<ActionEvent>() {
            GraphicsContext gcThirdTabPane = Canvas3.getGraphicsContext2D();

            @Override
            public void handle(ActionEvent event) {
                double x, y, x1, y1;
                try {
                    x = Double.parseDouble(StartX3.getText());
                    y = Double.parseDouble(StartY3.getText());
                    x1 = Double.parseDouble(EndX3.getText());
                    y1 = Double.parseDouble(EndY3.getText());
                    gcThirdTabPane.clearRect(0, 0, 465, 340);
                    gcThirdTabPane.fillOval(x, y, x1 - x, y1 - y);
                } catch (NumberFormatException ex) {
                    System.out.println("Некорректный ввод");
                }
            }
        });

        draw4.setOnAction(new EventHandler<ActionEvent>() {
            GraphicsContext gcFourthTabPane = Canvas4.getGraphicsContext2D();

            @Override
            public void handle(ActionEvent event) {
                double[] x = new double[3], y = new double[3];
                try {
                    x[0] = Double.parseDouble(StartX4.getText());
                    y[0] = Double.parseDouble(StartY4.getText());
                    x[1] = Double.parseDouble(EndX4.getText());
                    y[1] = Double.parseDouble(EndY4.getText());
                    x[2] = Double.parseDouble(StartZ4.getText());
                    y[2] = Double.parseDouble(EndZ4.getText());
                    gcFourthTabPane.clearRect(0, 0, 465, 340);
                    gcFourthTabPane.fillPolygon(x, y, 3);
                } catch (NumberFormatException ex) {
                    System.out.println("Некорректный ввод");
                }
            }
        });
    }
}

