package Day2;

import javafx.geometry.Bounds;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


public class Rabbit extends StackPane {

    private Rectangle rectangle;
    private static final int width = 25;
    private static final int height = 25;
    public Rabbit(int x, int y)
    {
        rectangle = new Rectangle(width,height,Color.AQUA);
        setTranslateX(x);
        setTranslateY(y);

        getChildren().add(rectangle);
        setPrefSize(width,height);

        setOnMouseClicked(e -> {
            rectangle.setFill(Color.DARKKHAKI);
            System.out.println(toString());

        });

    }

    public void setFill(Paint paint)
    {
        rectangle.setFill(paint);
    }

    public Bounds getBounds()
    {
        return getBoundsInParent();
    }

    public String toString()
    {
        return "[rabbit x-> " + getTranslateX() + " y -> "+ getTranslateY() + " ]";
    }
}
