package ru.vsu.cs.kg2021.g41.lazutkina_a_a.task1.drawable_object;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Cat implements Drawable
{
    private Point coordinates;
    private Dimension size;
    private Color colorCat;

    private double cofWidth;
    private double cofHeight;
    private double cofX;
    private double cofY;

    private final double COF_HEAD_SIZE = 0.4;
    private final double COF_EYES_WIDTH = 0.2 * COF_HEAD_SIZE;
    private final double COF_EYES_HEIGHT = 0.25 * COF_HEAD_SIZE;
    private final double COF_NOSE_WIDTH = 0.25 * COF_HEAD_SIZE;
    private final double COF_NOSE_HEIGHT = 0.1 * COF_HEAD_SIZE;
    private final double COF_LENGTH_MUSTACHE = 0.5 * COF_HEAD_SIZE;
    private final double COF_PAW = 0.25 * COF_HEAD_SIZE;

    private final double COF_HEAD_X = 0.5 * (1 - COF_HEAD_SIZE);
    private final double COF_EYES_Y = 0.1;
    private final double COF_LEFT_EYE_X = COF_HEAD_X + COF_EYES_WIDTH;
    private final double COF_RIGHT_EYE_X = COF_HEAD_X + COF_HEAD_SIZE - 2 * COF_EYES_WIDTH;
    private final double COF_MUSTACHE_Y = 0.6 * COF_HEAD_SIZE;
    private final double COF_LEFT_MUSTACHE_X = COF_LEFT_EYE_X + 0.5 * COF_EYES_WIDTH;
    private final double COF_RIGHT_MUSTACHE_X = COF_RIGHT_EYE_X + 0.5 * COF_EYES_WIDTH;
    private final double COF_PAW_Y= 1 - COF_PAW;
    private final double COF_LEFT_PAW_X = 0.45 - COF_PAW;
    private final double COF_RIGHT_PAW_X = 0.55;

    private final int NUMBER_MUSTACHE = 3;
    private final int NUMBER_CLAWS = 3;

    private final double COF_CLAW = 0.2 * COF_PAW;


    private Point headCoordinates;
    private int headWidth;
    private int headHeight;
    private int eyesY;
    private int leftEyeX;
    private int rightEyeX;
    private Dimension eyeDimension;
    private Point noseCoordinates;
    private Dimension noseDimension;
    private int mustacheY;
    private int leftMustacheX;
    private int rightMustacheX;
    private Dimension pawDimension;

    public Cat(double cofX, double cofY, int windowWidth, int windowHeight, double cofWidth, double cofHeight, Color color)
    {
        this.cofX = cofX;
        this.cofY = cofY;

        coordinates = new Point((int) (this.cofX * windowWidth), (int) (this.cofY * windowHeight));
        size = new Dimension((int)(this.cofWidth * windowWidth), (int)(this.cofHeight * windowHeight));
        colorCat = color;

        this.cofWidth = cofWidth;
        this.cofHeight = cofHeight;
        recalculate(windowWidth, windowHeight);
    }

    public void recalculate(int windowWidth, int windowHeight)
    {
        coordinates.x = (int) (cofX * windowWidth);
        coordinates.y = (int) (cofY * windowHeight);
        size.width = (int)(cofWidth * windowWidth);
        size.height = (int)(cofHeight * windowHeight);

        headWidth = (int)(COF_HEAD_SIZE * size.width);
        headHeight = (int)(COF_HEAD_SIZE * size.height);
        eyeDimension = new Dimension((int)(COF_EYES_WIDTH * size.width), (int)(COF_EYES_HEIGHT * size.height));
        noseDimension = new Dimension((int)(COF_NOSE_WIDTH * size.width), (int)(COF_NOSE_HEIGHT * size.height));
        pawDimension = new Dimension((int)(COF_PAW * size.width), (int)(COF_PAW * size.height));

        headCoordinates = new Point(coordinates.x + (int)(COF_HEAD_X * size.width), coordinates.y);
        eyesY = coordinates.y + (int)(COF_EYES_Y * size.height);
        leftEyeX = coordinates.x + (int)(COF_LEFT_EYE_X * size.width);
        rightEyeX = coordinates.x + (int)(COF_RIGHT_EYE_X * size.width);
        noseCoordinates = new Point(headCoordinates.x + (headWidth - noseDimension.width) / 2, coordinates.y + headHeight / 2);
        mustacheY = coordinates.y + (int)(COF_MUSTACHE_Y * size.height);
        leftMustacheX = coordinates.x + (int)(COF_LEFT_MUSTACHE_X * size.width);
        rightMustacheX = coordinates.x + (int)(COF_RIGHT_MUSTACHE_X * size.width);

    }

    public void draw(Graphics2D g, int windowWidth, int windowHeight)
    {
        recalculate(windowWidth, windowHeight);
        drawBody(g);
        drawHead(g);
        printSomething(g, "Я кот");
    }

    private void drawHead(Graphics2D g)
    {
        Color oldC = g.getColor();
        g.setColor(colorCat);
        drawEars(g);
        g.fillOval(headCoordinates.x, headCoordinates.y, headWidth, headHeight);
        g.setColor(new Color(90, 87, 87));
        g.drawOval(headCoordinates.x, headCoordinates.y, headWidth, headHeight);
        g.setColor(colorCat);
        drawEye(g, leftEyeX, eyesY);
        drawEye(g, rightEyeX, eyesY);
        drawNose(g);
        drawMustache(g, rightMustacheX, -Math.PI / 6);
        drawMustache(g, leftMustacheX, -7 * Math.PI / 6);
        drawMouth(g);
        g.setColor(oldC);
    }

    private void drawBody(Graphics2D g)
    {
        Color oldC = g.getColor();
        g.setColor(colorCat);
        int ovalWidth = size.width;
        int ovalHeight = size.height / 4;
        int ovalX = coordinates.x;
        int ovalY = coordinates.y + size.height - ovalHeight;
        int halfOvalHeightY = ovalY + ovalHeight / 2;
        int halfWidthCatX = headCoordinates.x + headWidth / 2;
        g.fillOval(ovalX, ovalY, ovalWidth, ovalHeight);
        g.fillPolygon(new int[] {ovalX, halfWidthCatX, ovalX + ovalWidth},
                new int[] {halfOvalHeightY, coordinates.y, halfOvalHeightY}, 3);
        int pawY = (int)(coordinates.y + size.height * COF_PAW_Y);
        drawPaw(g, coordinates.x + (int)(size.width * COF_LEFT_PAW_X), pawY);
        drawPaw(g, coordinates.x + (int)(size.width * COF_RIGHT_PAW_X), pawY);
        g.setColor(oldC);
    }

    private void drawEars(Graphics2D g)
    {
        g.fillPolygon(new int[] {headCoordinates.x, headCoordinates.x + headWidth / 4, headCoordinates.x},
                new  int[] {headCoordinates.y, headCoordinates.y + headHeight / 5, headCoordinates.y + headHeight / 2}, 3);
        g.fillPolygon(new int[] {headCoordinates.x + headWidth, headCoordinates.x + headWidth - headWidth / 4, headCoordinates.x + headWidth},
                new  int[] {headCoordinates.y, headCoordinates.y + headHeight / 5, headCoordinates.y + headHeight / 2}, 3);
    }

    private void drawEye(Graphics2D g, int x, int y)
    {
        Color oldC = g.getColor();
        g.setColor(new Color(220, 159, 85));
        g.fillOval(x, y, eyeDimension.width, eyeDimension.height);
        g.setColor(Color.BLACK);
        g.fillOval((int) (x + 0.375 * eyeDimension.width), y,
                eyeDimension.width / 4, eyeDimension.height);
        g.setColor(oldC);
    }

    private void drawNose(Graphics2D g)
    {
        Color oldC = g.getColor();
        g.setColor(new Color(220, 121, 121));
        g.fillPolygon(
                new int[] {noseCoordinates.x, noseCoordinates.x + noseDimension.width,
                noseCoordinates.x + noseDimension.width / 2},
                new int[] {noseCoordinates.y, noseCoordinates.y, noseCoordinates.y + noseDimension.height},
                3);
        g.setColor(oldC);
    }

    private void drawMustache(Graphics2D g, int x, double initialAlpha)
    {
        Color oldC = g.getColor();
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(3));
        double alpha = Math.PI * 0.5 / NUMBER_MUSTACHE;
        for (int i = 0; i < NUMBER_MUSTACHE; i++)
        {
            double a = alpha * i;
            double x2 = x + (headWidth * 0.5) * Math.cos(initialAlpha + a);
            double y2 = mustacheY + (headHeight * 0.5) * Math.sin(initialAlpha + a);
            g.drawLine(x, mustacheY, (int)x2, (int)y2);
        }
        g.setColor(oldC);
    }

    private void drawMouth(Graphics2D g)
    {
        Color oldC = g.getColor();
        g.setColor(new Color(220, 121, 121));
        g.setStroke(new BasicStroke(3));
        g.drawArc(headCoordinates.x + (int)(headWidth * 0.25), headCoordinates.y + (int)(headHeight * 0.6),
                headWidth / 4, headHeight / 5, -180, 180);
        g.drawArc(headCoordinates.x + (int)(headWidth * 0.5), headCoordinates.y + (int)(headHeight * 0.6),
                headWidth / 4, headHeight / 5, -180, 180);
        g.setColor(oldC);
    }

    private void printSomething(Graphics2D g, String s)
    {
        Color oldC = g.getColor();
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("SansSerif", Font.PLAIN, 30));
        g.drawString(s,headCoordinates.x + headWidth, coordinates.y);
        g.setColor(oldC);
    }

    private void drawPaw(Graphics2D g, int x, int y)
    {
        Color oldC = g.getColor();
        g.setColor(new Color(0,0,0));
        Shape shape = new Ellipse2D.Double(x, y, pawDimension.width, pawDimension.height);
        g.fill(shape);
        g.setStroke(new BasicStroke(2));
        g.setColor(new Color(90, 87, 87));
        g.draw(shape);
        g.setColor(new Color(213, 213, 213));
        int clawLengthX = (int) (size.width * COF_CLAW);
        int clawLengthY = (int) (size.height * COF_CLAW);
        int pawRadiusX = (int) (size.width * COF_PAW * 0.5);
        int pawRadiusY = (int) (size.height * COF_PAW * 0.5);
        double initAlpha = Math.PI / 3;
        double alpha = Math.PI / (2 * NUMBER_CLAWS);
        for (int i = 0; i < NUMBER_CLAWS; i++)
        {
            double a = alpha * i;
            double x1 = x + pawRadiusX  + (pawRadiusX - clawLengthX) * Math.cos(initAlpha + a);
            double y1 = y + pawRadiusY + (pawRadiusY - clawLengthY) * Math.sin(initAlpha + a);
            double x2 = x + pawRadiusX +  pawRadiusX * Math.cos(initAlpha + a);
            double y2 = y + pawRadiusY + pawRadiusY * Math.sin(initAlpha + a);
            g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        }
        g.setColor(oldC);
    }
}
