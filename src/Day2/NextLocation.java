package Day2;

import javafx.geometry.Point2D;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class NextLocation{

    private Queue<Point2D> queue;
    private static final int DEFAULT_LOAD = 50;
    private final int WINDOW_WIDTH;
    private final int WINDOW_HEIGHT;

    public NextLocation(int window_width, int window_height)
    {
        WINDOW_WIDTH = window_width;
        WINDOW_HEIGHT = window_height;
        queue = new LinkedList<>();
        loadQueue();
    }


    public void viewQueue()
    {
        queue.forEach(System.out::println);
    }
    private void loadQueue()
    {
        for (int i = 0; i < DEFAULT_LOAD; i++)
        {
            Random rand = new Random();
            double x = rand.nextInt(WINDOW_WIDTH);
            double y = rand.nextInt(WINDOW_HEIGHT);


            queue.add(new Point2D(x,y));
        }
    }

    public Iterator<Point2D> iterator()
    {
        return queue.iterator();
    }

    public Point2D next()
            throws ArrayIndexOutOfBoundsException
    {
        if (!queue.isEmpty())
        {
            return queue.poll();
        }
        loadQueue();
        if (queue.isEmpty())
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        return iterator().next();
    }
}
