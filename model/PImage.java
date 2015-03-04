package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PImage{

	private BufferedImage image;
	private JLabel picLabel;

	public PImage()
	{
		try
		{                
			image = ImageIO.read(new File("../rsc/default.gif"));
			picLabel = new JLabel(new ImageIcon(image));
		}catch (IOException ex)
		{
			// handle exception...
		}
	}
	public JLabel getImage()
	{
		return this.picLabel;
	}
}
