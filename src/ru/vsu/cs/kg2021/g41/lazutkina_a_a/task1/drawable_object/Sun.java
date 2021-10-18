package ru.vsu.cs.kg2021.g41.lazutkina_a_a.task1.drawable_object;

import java.awt.*;

public class Sun implements Drawable
{
    private int x;
    private int y;
    private int radInner;
    private int radOuter;
    private int numLights;
    private Color color;

    public Sun(int x, int y,
               int radInner, int radOuter,
               int numLights, Color color)
    {
        this.x = x;
        this.y = y;
        this.radInner = radInner;
        this.radOuter = radOuter;
        this.numLights = numLights;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g, int windowWidth, int windowHeight)
    {
        Color oldC = g.getColor();
        g.setColor(color);
        g.fillOval(x - radInner, y - radInner, 2*radInner, 2*radInner);
        g.setStroke(new BasicStroke(3));
        double da = 2 * Math.PI / numLights;
        for (int i = 0; i < numLights; i++)
        {
            double a = da * i;
            double x1 = x + radInner * Math.cos(a);
            double y1 = y + radInner * Math.sin(a);
            double x2 = x + radOuter * Math.cos(a);
            double y2 = y + radOuter * Math.sin(a);
            g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        }
        g.setColor(oldC);
    }
}
