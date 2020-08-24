package clases;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author luism
 */
public class Disennio {
    
    private String logo = "src/images/Logo.png";
    private String wallpaper = "src/images/Fondo.jpg";
    
        public Disennio() {
    }


    public String getWallpaper() {
        return wallpaper;
    }

    public String getLogo() {
        return logo;
    }


    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/Logo.png"));
        return retValue;
    }

}
