import processing.core.PApplet;
import processing.core.PImage;
import java.util.Objects;
import java.io.File;

/**
 * Ein Bild, inkusive Betrachter.
 * 
 * @author S. Gebert 
 * @version 06.2021
 */
public class Picture
{
    protected Sketch sketch;
    private String initialImg;
    
    public Picture()
    {
        
    }
    public Picture(String filename)
    {
        this.initialImg = filename; 
        display();
    }

    public void display()
    {
        if( ! Objects.isNull(sketch) ) return;
        sketch = new Sketch();
        PApplet.runSketch(new String[]{"sketch"}, sketch);  
        if( this.initialImg != null && this.initialImg != "" ){
            load(initialImg);
        }
    }

    public void load(String dateiname) {
        sketch.load("images/"+dateiname);
    }

    public void save(String dateiname) {
        sketch.save( new File("images/"+dateiname).getAbsolutePath() );
    }
    
    public void runOp(Bildoperationen op)
    {
        sketch.runOp(op);
    }

}
