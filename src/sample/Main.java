package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

// chapter1/FXModality.java
public class Main extends Application {

    @Override
    public void start(Stage stage1) {
//        // here we create a regular window
//        Scene scene = new Scene(new Group(), 300, 250);
//        stage1.setTitle("Main Window");
//        stage1.setScene(scene);
//        stage1.show();
//
//        // this window doesn't block mouse and keyboard events
//        Stage stage2 = new Stage();
//        stage2.setTitle("I don't block anything");
//        stage2.initModality(Modality.NONE);
//        stage2.show();
//
//        // this window blocks everything - you can't interact
//        // with other windows while it's open
//        Stage stage3 = new Stage();
//        stage3.setTitle("I block everything");
//        stage3.initModality(Modality.APPLICATION_MODAL);
//        stage3.show();
//
//        // this window blocks only interaction with it's owner window (stage1)
//        Stage stage4 = new Stage();
//        stage4.setTitle("I block only clicks to main window");
//        stage4.initOwner(stage1);
//        stage4.initModality(Modality.WINDOW_MODAL);
//        stage4.show();

//        HBox root = new HBox();
//        Rectangle red;
//        root.getChildren().addAll(
//                new Rectangle(75,25,Color.GREEN), // stays behind blue and red
//                new Rectangle(75, 75, Color.BLUE),
//                red = new Rectangle(90, 90, Color.RED));
//
//        red.toBack();
//
//        GridPane root = new GridPane();
//        for (int i = 0; i < 5; i++) {
//            root.getColumnConstraints().add(new ColumnConstraints(30));
//            root.getRowConstraints().add(new RowConstraints(30));
//        }
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if ((i+j)%2 == 0)
//                    root.add(new Rectangle(45, 30, Color.BLUE), i, j);
//            }
//        }
//
//        Scene scene = new Scene(root,500,500);
//        Stage stage = new Stage();
//        stage.setTitle("hello");
//        stage.setScene(scene);
//        stage.show();
    }
}
