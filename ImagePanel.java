// Author: Jay Sheridan
// Class to extend swing's JPanel with image display functionality
// 9/7/2003

// javac ImagePanel.java

import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;

public class ImagePanel extends JPanel
{
    private Image theImage;
    private boolean centered = false;

    public ImagePanel()
    {
	theImage = null;
	centered = false;
    }

    public ImagePanel(Image img, boolean center)
    {
	theImage = img;
	centered = center;
    }

    public void paint(Graphics g)
    {
	int x, y, imgw, imgh;

	x = 0;
	y = 0;
	g.clearRect(0,0,getWidth(),getHeight());
	if (centered) {
	    imgw = theImage.getWidth(this);
	    imgh = theImage.getHeight(this);
	    x = (int)(getWidth()/2.0 - imgw/2.0);
	    y = (int)(getHeight()/2.0 - imgh/2.0);
	}

	g.drawImage(theImage,x,y,this);
    }

    public void setCentered(boolean center)
    {
	centered = center;
    }

    public boolean isCentered()
    {
	return centered;
    }

    public void setImage(Image img)
    {
	theImage = img;
    }

    public Image getImage()
    {
	return theImage;
    }

} // end class
