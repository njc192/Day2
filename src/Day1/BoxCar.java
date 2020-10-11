package Day1;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class BoxCar extends StackPane {


    private Rectangle car;
    private int widthCar = 50;
    private int heightCar = 75;
    private int x;
    private int y;

    public BoxCar(int x, int y)
    {
        this.x = x;
        this.y = y;
        car = new Rectangle(0,0,20,20);
        getChildren().add(car);
    }
    public void moveUp()
    {
        setTranslateY(getTranslateY() - 5);
    }

    public void moveDown()
    {
        setTranslateY(getTranslateY() + 5);
    }

    public void moveLeft()
    {
        setTranslateX(getTranslateX() - 5);
    }

    public void moveRight()
    {
        setTranslateX(getTranslateX() + 5);
    }

}
