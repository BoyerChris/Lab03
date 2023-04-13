import java.awt.*;

public class BigRectangleFilter implements Filter
{
    @Override
    public boolean accept(Object x)
    {
        Rectangle side = (Rectangle) x;
        return (side.height + side.height + side.width + side.width) > 10;

    }
}
