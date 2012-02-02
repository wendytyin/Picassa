package model;

import java.awt.Dimension;

import expressions.Expression;


/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 */
public class Model
{
    public static final double DOMAIN_MIN = -1;
    public static final double DOMAIN_MAX = 1;

    private static double evalY;
    private static double evalX;

    /**
     * Evaluate an expression for each point in the image.
     */
    public Pixmap evaluate (String input, Dimension size)
    {
        Pixmap result = new Pixmap(size);
        // create expression to evaluate just once
        Expression toEval = new Parser().makeExpression(input);
        
        System.out.println(toEval.toString());
        
        // evaluate at each pixel
        for (int imageY = 0; imageY < size.height; imageY++)
        {
            evalY = imageToDomainScale(imageY, size.height);
            for (int imageX = 0; imageX < size.width; imageX++)
            {
                evalX = imageToDomainScale(imageX, size.width);
                //changed: .evaluate must take two arguments now indicating location
                result.setColor(imageX, imageY,
                                toEval.evaluate().toJavaColor());
            }
        }
        return result;
    }


    /**
     * Convert from image space to domain space.
     */
    protected double imageToDomainScale (int value, int bounds)
    {
        double range = DOMAIN_MAX - DOMAIN_MIN;
        return ((double)value / bounds) * range + DOMAIN_MIN;
    }
    
    
    public static double getXCoordinate(){
    	return evalX;
    }
    public static double getYCoordinate(){
    	return evalY;
    }
        
}
