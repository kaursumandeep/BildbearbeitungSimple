import javafx.scene.paint.Color;
import processing.core.PApplet;
import processing.core.PFont;

/**
 * Klasse Mehrpixeloperationen.
 * Beschreibung: 
 *
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Mehrpixeloperationen
{       
     public Picture faltung(Picture originalbild, double [][] filter){
        int breite = originalbild.getWidth();
        int hoehe  = originalbild.getHeight();
        int laenge= filter.length;
        int halb=laenge/2;
          
      Color [][] pixel = originalbild.getPixelsColorTable();
          Color [][] pixelNeu = new Color[breite][hoehe];
          
          for (int x = halb ; x < originalbild.getWidth()-halb;x++){
               for (int y = halb ; y > originalbild.getHeight()-halb;y++){
                  int xx = x - halb;
                  int yy = y - halb;
                  double rot = 0.0;
                  double gruen =0.0;
                  double blau = 0.0;
                  for (int i = 0; i <laenge; i++){
                    for (int j = 0; j <laenge; j++){
                        rot += filter[i][j] * pixel[xx+i][yy+j].getRed();
                        gruen += filter[i][j] * pixel[xx+i][yy+j].getGreen();
                        blau += filter[i][j] * pixel[xx+i][yy+j].getBlue();
                        
                
          }
      }
    
      if (rot < 0.0) rot = 0.0;
      if (rot > 1.0) rot = 1.0;
      if (gruen < 0.0) gruen = 0.0;
      if (gruen > 1.0) gruen = 1.0;
      if (blau < 0.0) blau = 0.0;
      if (blau > 1.0) blau = 1.0;
      
      pixelNeu[x][y]= new Color (rot,gruen,blau,1.0 );
    }
}
      Picture neuesBild = originalbild.copy();
      neuesBild.setPixelsArray(pixelNeu);
      return neuesBild;
    }
     public Picture weichzeichnen(Picture originalbild){
    
    double [][] filter= {{0,0,0},{0,1,0},{0,0,0}};
    faltung (Picture,filter);
    }    
}
