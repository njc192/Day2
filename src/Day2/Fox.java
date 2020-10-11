package Day2;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class Fox  extends Pane {

    private Rectangle fox;
    public Circle radar;

    private NextLocation nextLocation;
    private static final int DX =1;
    private static final int DY =1;
    private Point2D destination;
    private List<Rabbit> rabbits;
    private static final int RADIUS = 100;
    private static final int WIDTH = 25;
    private static final int HEIGHT = 25;
    private static boolean radarIsVisible = true;


    public Fox(int x, int y, List<Rabbit> rabbitList)
    {
        fox = new Rectangle(WIDTH,HEIGHT, Color.ORANGE);

        rabbits = rabbitList;
        radar = new Circle(RADIUS);

        radar.setTranslateX(getTranslateX() + WIDTH/2.0);
        radar.setTranslateY(getTranslateY() + HEIGHT/2.0);
        radar.setStroke(Color.RED);
        radar.setVisible(radarIsVisible);

        nextLocation = new NextLocation(Day2.window_width,Day2.window_height);
        destination= nextLocation.next();
        addToX(x);
        addToY(y);
        getChildren().add(radar);
        getChildren().add(fox);
    }

    public void addToX(double x)
    {

        fox.setTranslateX(fox.getTranslateX() + x);
        radar.setTranslateX(radar.getTranslateX() + x);
    }

    public void addToY(double y)
    {
        fox.setTranslateY(fox.getTranslateY() + y);
        radar.setTranslateY(radar.getTranslateY() + y);
    }

    public Point2D getLocation()
    {
        return new Point2D(fox.getTranslateX(),fox.getTranslateY());
    }

    public void roam()
    {
        boolean scentFound = false;
        //travelTo(destination);
        //huntRabbits();
    }


    public void huntRabbits()
    {
        for (Rabbit rabbit : rabbits)
        {
            if (getBounds().intersects(rabbit.getBounds()))
            {
                rabbit.setFill(Color.PINK);
            }
        }
    }

    public void travelTo(Point2D location)
    {
        Point2D myLocation = new Point2D(getLocation().getX(),getLocation().getY());
        Point2D diff = location.subtract(myLocation);
        double dx = Math.abs(diff.getX());
        double dy = Math.abs(diff.getY());
        if (dx < DX && dy < DX)
        {
            destination = nextLocation.next();

        }

        Point2D horiz = new Point2D(1,0);


        double xComponent = Math.cos(Math.toRadians(horiz.angle(diff))) *DX;
        double yComponent = Math.sin(Math.toRadians(horiz.angle(diff))) *DY;

        yComponent = diff.getY() > 0 ? yComponent: -1*yComponent;



        addToY(yComponent);
        addToX(xComponent);
    }


    public Bounds getBounds()
    {
        return radar.getBoundsInParent();
    }

    @Override
    public String toString()
    {
        return "[Fox: x->" + fox.getTranslateX() + " y->" + fox.getTranslateY() +
                "]\n [Radar: x->" + radar.getTranslateX() + " y->" + radar.getTranslateY()+ "]\n";
    }

}
