package Day2;

import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


public class Rabbit extends StackPane {

    private Rectangle rabbit;
    private static final int width = 25;
    private static final int height = 25;
    public Rabbit(int x, int y)
    {
        rabbit = new Rectangle(width,height,Color.AQUA);
        rabbit.setTranslateX(x);
        rabbit.setTranslateY(y);

        getChildren().add(rabbit);
        setPrefSize(width,height);

    }

    public void setFill(Paint paint)
    {
        rabbit.setFill(paint);
    }

    public Bounds getBounds()
    {
        return rabbit.getBoundsInParent();
    }

    public String toString()
    {
        return "[rabbit x-> " + rabbit.getTranslateX() + " y -> "+ rabbit.getTranslateY() + " ]";
    }
}
