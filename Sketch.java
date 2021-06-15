import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;
import javafx.scene.paint.Color;
import java.util.function.*;

/**
 * 
 * Anzeigefläche für ein Bild.
 *
 * @author S. Gebert 
 * @version 06.2021
 */
public class Sketch extends PApplet
{       
    private PImage displayImg;
    private int width = 600;
    private int height = 400;

    /**
     * settings() Methode 
     * Fenstergröße size(int width, int height) und smooth(int level) muss hier eingestellt werden.
     */
    @Override
    public void settings()
    {
        size(width,height);
    }        

    /**
     * Die setup() Methode wird einmal aufgerufen, wenn das Programm startet.
     * Hier werden Einstellungen wie die Hintergrundfarbe vorgenommen
     * und Medien wie Bilder und Schriftarten geladen.
     */
    @Override
    public void setup()
    {    
        displayImg = createImage(width,height,RGB);
        image(displayImg,0,0);
    }

    public void runOpL(UnaryOperator<PImage> gop)
    {
        displayImg = gop.apply(displayImg);
    }
    
    public void runOp( Bildoperationen gop)
    {
        displayImg = gop.apply(displayImg);
    }

    /**
     * Speichert das aktuell angezeigte Bild
     *
     * @param filename Der Dateiname des zu speichernden Bildes.
     */
    public void save(String filename)
    {
        displayImg.save(filename);
    }
    
    /**
     * Läd ein neues Bild in die Anzeige
     *
     * @param filename Der Dateinmame des anzuzeigenden Bildes.
     */
    public void load(String filename)
    {
        displayImg = loadImage( filename );
    }
    
    /**
     * Die draw() Methode wird nach der setup() Methode aufgerufen
     * und führt den Code innerhalb ihres Blocks fortlaufend aus,
     * bis das Programm gestoppt oder noLoop() aufgerufen wird.
     */
    @Override
    public void draw()
    {
        image(displayImg,0,0);
    }
}
