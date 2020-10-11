package Day1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Day1 extends Application {


    private static final int SCENE_SIZE = 500;

    private BoxCar boxCar;
    private double mouseX = 0;
    private double mouseY = 0;
    public static void main(String[] args) {
        launch(args);
    }





    public void update()
    {
        if(boxCar.getTranslateX() != mouseX && boxCar.getTranslateY() != mouseY)
        {
            Point2D mouse = new Point2D(mouseX,mouseY);
            Point2D car = new Point2D(boxCar.getTranslateX(),boxCar.getTranslateY());
            Point2D diff = mouse.subtract(car);
            Point2D horiz = new Point2D(1,0);
            double angle = horiz.angle(diff);

            System.out.println("mouse" + mouse + "\n car" + car + "\n diff" + diff);
            System.out.println("angle" + angle);

            //cos(angle) gives you A/H but because it is a unit vector H =1 therefore cos(angle) = A
            //and same for sin(angle) = Opposite
            double xComponent = Math.cos(Math.toRadians(angle))*5;
            double yComponent = Math.sin(Math.toRadians(angle))*5;
            boxCar.setTranslateX(boxCar.getTranslateX() + xComponent);
            boxCar.setTranslateY(boxCar.getTranslateY() + (diff.getY() > 0 ? yComponent : -1*yComponent));

//            System.out.println("X: " + xComponent);
//            System.out.println("Y: "  + yComponent);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        root.setOnKeyPressed(e ->
        {
            switch (e.getCode())
            {
                case A:
                    boxCar.moveLeft();
                    break;
                case S:
                    boxCar.moveDown();
                    break;
                case W:
                    boxCar.moveUp();
                    break;
                case D:
                    boxCar.moveRight();
                    break;

                //TODO: this link kinda got my head thinking https://stackoverflow.com/questions/23052257/multiple-key-press-on-javafx-scene

            }

        });

        root.setOnMousePressed(e ->
        {
            double mouseX = e.getX();
            double mouseY = e.getY();

            setDestination(mouseX,mouseY);
//            System.out.println("box X: " + boxCar.getTranslateX() + " box Y: " + boxCar.getTranslateY()
//             + " angle: " + angle + " x comp: " + xComponent + " y comp: " + yComponent);
//
        });


        boxCar = new BoxCar(50,50);
        root.getChildren().add(boxCar);

        Scene scene = new Scene(root,SCENE_SIZE,SCENE_SIZE);




        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };

        primaryStage.setScene(scene);
        timer.start();
        primaryStage.show();

    }

    private void setDestination(double mouseX, double mouseY)
    {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }
}
