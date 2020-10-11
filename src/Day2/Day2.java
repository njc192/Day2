package Day2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Day2 extends Application {

    public static final int window_width = 800;
    public static final int window_height = 1000;

    private static final int NUM_OF_RABBITS = 5;
    private Fox fox;
    private List<Rabbit> rabbits;

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

    @Override
    public void start(Stage primaryStage) {

        int r1;
        int r2;
        Pane root = new Pane();

        rabbits = new ArrayList<>();

        Rabbit q = new Rabbit(10,10);
        q.setFill(Color.BROWN);
        rabbits.add(q);

        q.setOnMouseClicked(e -> {
            System.out.println(q);
        });

        root.getChildren().add(q);
        for (int i = 0; i <NUM_OF_RABBITS; i++)
        {
            r1 = new Random().nextInt(window_width);
            r2 = new Random().nextInt(window_height);
            Rabbit wabbit = new Rabbit(r1,r2);
            wabbit.setOnMouseClicked(e -> {
                wabbit.setFill(Color.BURLYWOOD);

            });

            rabbits.add(wabbit);
            root.getChildren().add(wabbit);
        }

        r1 = new Random().nextInt(window_width);
        r2 = new Random().nextInt(window_height);

        fox = new Fox(r1,r2,rabbits);



        fox.setOnMouseClicked(e -> {
            System.out.println(fox);
        });

        root.getChildren().add(fox);


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                fox.roam();
            }
        };
        Scene scene = new Scene(root,window_width,window_height);
        fox.radar.setFill(scene.getFill());
        primaryStage.setScene(scene);
        primaryStage.show();
        timer.start();
    }
}
