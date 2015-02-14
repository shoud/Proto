import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel
{

	private BufferedImage image;
	public ImagePanel()
	{
		try
		{
			image = ImageIO.read(new File("default.gif"));
		}
		catch(IOException ex)
		{

		}
	}
	public ImagePanel(File file)
	{
       		try
		{                
          		image = ImageIO.read(file);
       		}
		catch(IOException ex)
		{
         
      		}
   	}
	@Override
    	protected void paintComponent(Graphics graphique)
	{
        	super.paintComponent(graphique);
        	graphique.drawImage(image, 0, 0, null);            
   	 }
}
