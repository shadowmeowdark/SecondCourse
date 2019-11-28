package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;

import java.util.Random;


public class Controller {
    @FXML
    private Button draw1;
    @FXML
    private Canvas Canvas1;

    @FXML
    void initialize() {
        draw1.setOnAction(new EventHandler<ActionEvent>() {
            GraphicsContext gc = Canvas1.getGraphicsContext2D();

            @Override
            public void handle(ActionEvent actionEvent) {
                Random random = new Random();
                gc.clearRect(0, 0, 500, 400);
                gc.setStroke(Color.RED);
                gc.strokeLine(random.nextInt(400), random.nextInt(400), random.nextInt(400), random.nextInt(400));
                gc.setStroke(Color.BLUE);
                gc.strokeOval(random.nextInt(400), random.nextInt(400), random.nextInt(400), random.nextInt(400));
                gc.setFill(Color.DIMGRAY);
                gc.fillOval(random.nextInt(400), random.nextInt(400), random.nextInt(400), random.nextInt(400));
                int[] numbers = new int[4];
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = random.nextInt(400);
                }
                gc.setStroke(Color.KHAKI);
                gc.strokeRect(400 - numbers[0], 400 - numbers[1], numbers[0], numbers[1]);
                gc.setFill(Color.INDIANRED);
                gc.fillRect(400 - numbers[2], 400 - numbers[3], numbers[2], numbers[3]);
                gc.setStroke(Color.MEDIUMAQUAMARINE);
                gc.setFill(Color.NAVAJOWHITE);
                double [] x = new double[3];
                double [] y = new double[3];
                for (int i = 0; i < x.length ; i++) {
                    x[i] = Double.valueOf(random.nextInt(400));
                    y[i] = Double.valueOf(random.nextInt(400));
                }
                gc.strokePolygon(x , y , 3);
                gc.fillPolygon(x , y , 3);
            }
        });
    }
}
