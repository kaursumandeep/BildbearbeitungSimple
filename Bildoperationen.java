import processing.core.PApplet;
import processing.core.PImage;
import javafx.scene.paint.Color;

/**
 * Abstrakte Klasse Bildoperationen,
 * Implementiert einige nützliche Methoden zur Nutzung in Bildoperationen.
 * 
 * @author S. Gebert
 * @version 06.2021
 */
public abstract class Bildoperationen
{
    public static final int RGB = 1;
    public static final int HSB = 3;

    public abstract PImage apply(PImage originalbild);

    
    /**
     * Wandelt ein Color-Objekt in einen Farbwert um.
     *
     * @param color Ein Color Objekt
     * @return Farbwert
     */
    public int color(Color color)
    {
        int R = (int)Math.round(255 * color.getRed());
        int G = (int)Math.round(255 * color.getGreen());
        int B = (int)Math.round(255 * color.getBlue());

        R = (R << 16) & 0x00FF0000; 
        G = (G << 8) & 0x0000FF00; 
        B = B & 0x000000FF; 

        return 0xFF000000 | R | G | B; 
    } 

    /**
     * Wandelt Bilddaten (Pixel) aus einem eindimensionalen Array zu Bilddaten in einem zweidimensionalen Array um.
     * @param pixels Eindimensionales Array mit Bilddaten
     * @param width Breite des Bildes
     * @param height Höhe des Bildes
     * @return Ein zweidimensionales Array, der gegebenen Breite und Höhe
     */
    public int[][] pixelsExplode( int[] pixels, int width, int height )
    {
        int[][] pixels2D = new int[width][height];
        for(int i = 0; i < width; i++){
            for( int k = 0; k < height; k++ ){
                pixels2D[i][k] = pixels[i + k*width];

            }
        }
        return pixels2D;
    }

    /**
     * Wandelt Bilddaten (Pixel) aus einem zweidimensionalen Array zu Bilddaten in einem eindimensionalen Array um.
     * @param pixels Zweidimensionales Array mit Bilddaten
     * @return Ein eindimensionales Array mit den Bilddaten
     */
    public int[] pixelsFlatten( int[][] pixels2D )
    {
        int[] pixels = new int[ pixels2D.length * pixels2D[0].length ];
        for( int i = 0; i < pixels2D.length; i++ ){
            for( int k = 0; k < pixels2D[0].length; k++ ){
                pixels[i+k*pixels2D.length] = pixels2D[i][k];
            }
        }
        return pixels;
    }

}
