import java.awt.*;
import java.util.ArrayList;

public class BigRectLister
{
    public static void main(String[] args)
    {
        ArrayList<Rectangle> rectangles = new ArrayList<>();

        Rectangle rectangle0 = new Rectangle(1, 1);
        rectangles.add(rectangle0);
        Rectangle rectangle1 = new Rectangle(2, 1);
        rectangles.add(rectangle1);
        Rectangle rectangle2 = new Rectangle(2, 3);
        rectangles.add(rectangle2);
        Rectangle rectangle3 = new Rectangle(4, 2);
        rectangles.add(rectangle3);
        Rectangle rectangle4 = new Rectangle(5, 3);
        rectangles.add(rectangle4);
        Rectangle rectangle5 = new Rectangle(1, 6);
        rectangles.add(rectangle5);
        Rectangle rectangle6 = new Rectangle(7, 5);
        rectangles.add(rectangle6);
        Rectangle rectangle7 = new Rectangle(8, 6);
        rectangles.add(rectangle7);
        Rectangle rectangle8 = new Rectangle(9, 7);
        rectangles.add(rectangle8);
        Rectangle rectangle9 = new Rectangle(8, 6);
        rectangles.add(rectangle9);

        BigRectangleFilter filter = new BigRectangleFilter();
        ArrayList<Rectangle> passedRectangles = new ArrayList<>();

        for (Rectangle rect: rectangles)
        {
            if (filter.accept(rect))
            {
                passedRectangles.add(rect);
            }
        }

        int i = 0;
        int x = 0;

        i = passedRectangles.size();

        while (x < i)
        {
            System.out.println(passedRectangles.get(x));
            x = x + 1;
        }
    }
}
