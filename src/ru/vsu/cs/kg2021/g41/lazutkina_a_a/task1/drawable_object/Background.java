package ru.vsu.cs.kg2021.g41.lazutkina_a_a.task1.drawable_object;

import ru.vsu.cs.kg2021.g41.lazutkina_a_a.task1.utils.RandomUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Background implements Drawable
{
    private final double[][] randomCoefficients;
    private Color color;
    private List<Cloud> clouds;

    public Background(int numberClouds, Color color)
    {
        this.color = color;
        this.clouds = new ArrayList<>();
        randomCoefficients = generateRandomCoefficients(numberClouds);
        initRandomClouds(numberClouds);
    }

    @Override
    public void draw(Graphics2D g, int windowWidth, int windowHeight)
    {
        Color oldC = g.getColor();
        g.setColor(color);
        g.fillRect(0, 0, windowWidth, windowHeight);
        for (Cloud cloud : this.clouds)
        {
            cloud.draw(g, windowWidth, windowHeight);
        }
        g.setColor(oldC);
    }

    private void initRandomClouds(int numberClouds)
    {
        for (int i = 0; i < numberClouds; i++)
        {
            double[] cofCloud = randomCoefficients[i];
            this.clouds.add(new Cloud(cofCloud[0], cofCloud[1], cofCloud[2]));
        }
    }

    private double[][] generateRandomCoefficients(int numberClouds)
    {
        Random random = new Random();
        double maxCofWidth = 0.4;
        double minCofWidth = 0.05;
        double[][] cofClouds = new double[numberClouds][4];
        for (int i = 0; i < numberClouds; i++)
        {
            double cofWidth = RandomUtils.nextDouble(minCofWidth, maxCofWidth);
            double cofX = random.nextDouble();
            double cofY = random.nextDouble();
            cofClouds[i] = new double[] {cofX, cofY, cofWidth};
        }
        return cofClouds;
    }
}
