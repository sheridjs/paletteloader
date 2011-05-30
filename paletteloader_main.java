/* Author: Jay Sheridan
 * Program to test loading palettes from files
 */

// javac -classpath .;./jiu.jar paletteloader_main.java
// java -cp .;./jiu.jar paletteloader_main
// jar cvfm pngex.jar manifest.txt pngex.class pngex$1.class

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import net.sourceforge.jiu.data.Paletted8Image;
import net.sourceforge.jiu.data.Palette;
import net.sourceforge.jiu.gui.awt.ImageCreator;
import net.sourceforge.jiu.gui.awt.RGBA;

public class paletteloader_main implements ActionListener
{
    JFrame frm_MainWindow;
    ImagePanel pnl_Main;
    Paletted8Image pim_testImage;
    Palette pal_testPalette;
    int imageHeight, imageWidth;

    public static void main(String[] args)
    {
	new paletteloader_main();
    }

    public paletteloader_main()
    {
	frm_MainWindow = new JFrame("Test Palette Loader");
	frm_MainWindow.setDefaultCloseOperation(2); //dispose on exit
	frm_MainWindow.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		    System.exit(0);
		}
	    });

	makeObjects();
	doLayout();

	frm_MainWindow.getContentPane().add(pnl_Main);
	frm_MainWindow.pack();
	frm_MainWindow.show();
    }

    public void makeObjects()
	// setup of GUI objects
    {
	imageWidth = 256;
	imageHeight = 50;

	pim_testImage = new Paletted8Image(imageWidth,imageHeight);
	pal_testPalette = new Palette(256);

	// draw image
	for (int i=0; i<imageWidth; i++) {
	    for (int j=0; j<imageHeight; j++) {
		// Draw the entire palette from 0 to 255 along the width
		pim_testImage.putSample(0,i,j,i);
	    }
	}
	// make palette
	for (int i=0; i<256; i++) {
	    pal_testPalette.put(i,i,0,0); // red "grayscale"
	}
	pim_testImage.setPalette(pal_testPalette);

	pnl_Main = new ImagePanel();
	pnl_Main.setPreferredSize(new Dimension(imageWidth+10,imageHeight+10));
	pnl_Main.setImage(ImageCreator.convertToAwtImage(pim_testImage, RGBA.DEFAULT_ALPHA));
	pnl_Main.setCentered(true);

    }

    public void doLayout()
	// layout of GUI objects
    {

    }

    public void actionPerformed(ActionEvent e)
    {
	Object evtObj;
	evtObj = e.getSource();

/*
	if (evtObj.equals(btn_Load)) {
	    onLoadBtn();
	}
	else if (evtObj.equals(btn_Extract)) {
	    onExtractBtn();
	}
	*/
    }


} // End program

