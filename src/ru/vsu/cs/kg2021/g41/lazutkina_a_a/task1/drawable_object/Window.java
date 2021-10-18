package ru.vsu.cs.kg2021.g41.lazutkina_a_a.task1.drawable_object;

import java.awt.*;

public class Window implements Drawable
{
    double cof;
    public Window(double cof)
    {
        this.cof = cof;
    }

    @Override
    public void draw(Graphics2D g, int windowWidth, int windowHeight)
    {
        Color oldC = g.getColor();
        g.setColor(new Color(211, 215, 229, 255));
        int width = (int)(windowWidth * cof);
        int height = (int)(windowHeight * cof);
        int innerWidth = width / 2;
        int innerHeight = height / 2;
        g.fillRect(0, 0, width, windowHeight);
        g.fillRect(0, 0, windowWidth, height);
        g.fillRect(windowWidth - width, 0, width, windowHeight);
        g.fillRect(0, windowHeight - height, windowWidth, height);
        g.fillRect((windowWidth - innerWidth) / 2, height, innerWidth, windowHeight - 2 * height);
        g.fillRect(width, (windowHeight - innerHeight) / 2, windowWidth - 2 * width, innerHeight);

        g.setColor(new Color(85, 87, 101, 255));
        g.setStroke(new BasicStroke(10));
        g.drawRect(0, 0, windowWidth, windowHeight);
        int widthInnerFrame = (windowWidth - innerWidth) / 2 - width;
        int heightInnerFrame = (windowHeight - innerHeight) / 2 - height;
        g.drawRect(width, height, widthInnerFrame, heightInnerFrame);
        g.drawRect(width, (windowHeight + innerHeight) / 2, widthInnerFrame, heightInnerFrame);
        g.drawRect((windowWidth + innerWidth) / 2, height, widthInnerFrame, heightInnerFrame);
        g.drawRect((windowWidth + innerWidth) / 2, (windowHeight + innerHeight) / 2, widthInnerFrame, heightInnerFrame);
        g.setColor(oldC);
    }

}
