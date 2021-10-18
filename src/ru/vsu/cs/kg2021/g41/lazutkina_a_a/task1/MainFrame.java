package ru.vsu.cs.kg2021.g41.lazutkina_a_a.task1;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame
{
    public MainFrame() throws HeadlessException
    {
        DrawPanel dp = new DrawPanel(new Dimension(800, 800));
        this.add(dp);
        this.setSize(dp.getSize());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
