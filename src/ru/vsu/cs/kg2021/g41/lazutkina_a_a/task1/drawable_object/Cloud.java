package ru.vsu.cs.kg2021.g41.lazutkina_a_a.task1.drawable_object;

import ru.vsu.cs.kg2021.g41.lazutkina_a_a.task1.utils.RandomUtils;

import java.awt.*;

public class Cloud implements Drawable
{
    private double cofX;
    private double cofY;
    private double cofWidth;
    private double cofHeight;

    public Cloud(double cofX, double cofY, double cofWidth)
    {
        this.cofX = cofX;
        this.cofY = cofY;
        this.cofWidth = cofWidth;
        this.cofHeight = RandomUtils.nextDouble(0.3, 1);
    }

    @Override
    public void draw(Graphics2D g, int windowWidth, int windowHeight)
    {
        int x = (int) (cofX * windowWidth);
        int y = (int) (cofY * windowHeight);
        int width = (int) (cofWidth * windowWidth);
        int height = (int) (cofHeight * width);
        drawCloud(g, x, y, width, height);
    }

    private void drawCloud(Graphics2D g, int x, int y, int width, int height)
    {
        Color oldC = g.getColor();
        g.setColor(new Color(255, 255, 255, 134));
        g.fillOval(x, y, width, height);
        g.setColor(oldC);
    }
}
