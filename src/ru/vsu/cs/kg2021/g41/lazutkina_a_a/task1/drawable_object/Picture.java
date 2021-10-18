package ru.vsu.cs.kg2021.g41.lazutkina_a_a.task1.drawable_object;

import java.awt.*;

public class Picture implements Drawable
{
    Drawable background;
    Drawable window;
    Drawable cat;

    public Picture(Drawable background, Drawable window, Drawable cat)
    {
        this.background = background;
        this.window = window;
        this.cat = cat;
    }

    @Override
    public void draw(Graphics2D g, int windowWidth, int windowHeight)
    {
        background.draw(g, windowWidth, windowHeight);
        window.draw(g, windowWidth, windowHeight);
        cat.draw(g, windowWidth, windowHeight);
    }
}
