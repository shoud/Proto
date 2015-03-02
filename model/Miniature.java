package model;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Miniature {

	private String nom;
	private BufferedImage original;
	private final String chemin;
	private ImageIcon image;

	public Miniature(String chemin, int maxWidth, int maxHeight) throws Exception{
		this.chemin = chemin;
		Path p = Paths.get(chemin);
		nom = p.getFileName().toString();

		original = ImageIO.read(new File(chemin));
		if(original	== null) throw new Exception(chemin + ": Ne fichier n'a pas pu être ouvert.");

		int imgWidth = original.getWidth();
		int imgHeight = original.getHeight();

		double maxRatio = (double)maxWidth / maxHeight;
		double imgRatio = (double)imgWidth / imgHeight;
		double echelle = (imgRatio > maxRatio ? (double)maxWidth / imgWidth : (double)maxHeight/imgHeight);

		int finalWidth = (int)(imgWidth * echelle);
		int finalHeight = (int)(imgHeight * echelle);


		image = new ImageIcon(original.getScaledInstance(finalWidth, finalHeight, java.awt.Image.SCALE_FAST));

	}

	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getChemin() {
		return chemin;
	}
	public ImageIcon getImage()
	{
		return image;
	}
	public BufferedImage getOriginalImage()
	{
		return original;
	}
}
