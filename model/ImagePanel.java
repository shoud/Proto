package model;

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
	private String nom = null;
	private String chemin = null;
	private BufferedImage image = null;

	public void setNom(String nom){
	
		this.nom = nom;
	}
	public String getNom(){
		return nom;
	}
	
	public String getChemin(){
		return chemin;
	}
	
	public BufferedImage getImage(){
		return image;
	}

	public void set(Miniature m){
		nom = m.getNom();
		chemin = m.getChemin();
		image = m.getImage();
	}
	public int getWidth() {
		return (image != null ? image.getWidth() : 0);
	}

	public int getHeight() {
		return (image != null ? image.getHeight() : 0);
	}

	public static boolean isImage( String chemin ){
		String extension = null;
		int pos = chemin.lastIndexOf('.');
		if(pos>0 && pos<chemin.length(à-1){
			extension = chemin.substring(pos+1).toLowerCase();
		}
		if(extension != null){
			if(extension.equals("jpg")
					|| extension.equals("jpeg")
					|| extension.equals("gif")
					|| extension.equals("png")){
				return true;
			}
		}
		return false;
	}

	@Override
    	protected void paintComponent(Graphics graphique)
	{
        	super.paintComponent(graphique);
        	graphique.drawImage(image, 0, 0, null);            
   	 }
}
