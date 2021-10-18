package ru.vsu.cs.kg2021.g41.lazutkina_a_a.task1;

import ru.vsu.cs.kg2021.g41.lazutkina_a_a.task1.drawable_object.Window;
import ru.vsu.cs.kg2021.g41.lazutkina_a_a.task1.drawable_object.*;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel
{
    private Drawable picture;
    public DrawPanel(Dimension dimension)
    {
        this.setSize(dimension);
        this.picture = new Picture
                (new Background(10, new Color(79, 148, 227, 255)), new Window(0.08),
                new Cat(0.25,0.35, dimension.width, dimension.height, 0.5, 0.6, new Color(43, 43, 43, 255)));
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D gr = (Graphics2D) g;
        if (this.picture != null)
        {
            picture.draw(gr, this.getWidth(), this.getHeight());
        }
    }
}
