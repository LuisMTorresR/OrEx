package clases;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author luism
 */
public class Disennio {
    
    private String logo = "src/images/OrexLogo.png";
    private String wallpaper = "src/images/39908-azul-solido.jpg";
    
        public Disennio() {
    }


    public String getWallpaper() {
        return wallpaper;
    }

    public String getLogo() {
        return logo;
    }


    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/OrexLogo.png"));
        return retValue;
    }

}
