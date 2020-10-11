package Day2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Day2 extends Application {

    public static final int window_width = 800;
    public static final int window_height = 1000;

    private static final int NUM_OF_RABBITS = 5;
    private Fox fox;
    private List<Rabbit> rabbits;

    private Pane root;

    public static void main(String[] args) {
        launch(args);
    }
//
//    Thread timer = new Thread(() -> {
//        SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");
//        while(true) {
//            try {
//                // running "long" operation not on UI thread
//                Thread.sleep(500);
//            } catch (InterruptedException ex) {}
//            final String time = dt.format(new Date());
//            Platform.runLater(()-> {
//                // updating live UI object requires JavaFX App Thread
//                fox.roam();
//                System.out.println(fox);
//            });
//        }
//    });


    private Parent createContent()
    {
        int r1;
        int r2;
        root = new Pane();

        rabbits = new ArrayList<>();

        Rabbit q = new Rabbit(10,10);
        q.setFill(Color.BROWN);
        rabbits.add(q);

        q.setOnMouseClicked(e -> {
            System.out.println("clicked here");
        });

        for (int i = 0; i <NUM_OF_RABBITS; i++)
        {
            r1 = new Random().nextInt(window_width);
            r2 = new Random().nextInt(window_height);
            Rabbit wabbit = new Rabbit(r1,r2);

            rabbits.add(wabbit);

            Platform.runLater(() ->
            {
                root.getChildren().add(wabbit);
            });

        }

        r1 = new Random().nextInt(window_width);
        r2 = new Random().nextInt(window_height);

        for (Node child : root.getChildren())
        {
            child.setOnMouseClicked(e -> {
                System.out.println(e.getSource().toString());
            });
        }

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                //fox.roam();
            }
        };

        timer.start();


        root.setPrefSize(window_width,window_height);

        return root;
    }
    @Override
    public void start(Stage primaryStage) {


        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();

    }
}
