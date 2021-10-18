package ru.vsu.cs.kg2021.g41.lazutkina_a_a.task1.utils;

import java.util.Random;

public class RandomUtils
{
    public static double nextDouble(double min, double max)
    {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }
}