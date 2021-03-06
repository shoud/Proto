package view;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import model.CounterModel;
import model.Miniature;
import model.ImagePanel;
import model.PImage;
import controller.CounterController;
/**
* Classe permetttant de gérer l'affichage graphique
*/
public class GuiView implements Observer
{
	private CounterModel m_model;
	
	//Composants
	//L'image courante
	private ImagePanel imageCourante = new ImagePanel();	
	//Les images suivantes
	/*private Miniature image01;
	private Miniature image02;
	private Miniature image03;
	private Miniature image04;*/
	//Bouton pour suivant et precedent pour les 4 images
	private JButton btSuivant = new JButton("<-"); 
	private JButton btPrecedent = new JButton("->");
	//Titre de l'image courante
	private JTextField m_textTitreImage = new JTextField("Titre de l'image");
	//Les mots clé de l'image courante
	private JTextField m_textMotCle = new JTextField("Cachuete, elephant, test");
	//Pour faire une recherche
	private JTextField m_textRecherche = new JTextField("Recherche");
	//Pour choisir la langue du programme
	private String[] items = {"Français", "English", "中国"};
	private JComboBox m_choixLangue = new JComboBox(items);

	//ZONE TEST POUR IMAGE
	private PImage ip = new PImage(); 
	private PImage image01 = new PImage();
	private PImage image02 = new PImage();
	private PImage image03 = new PImage();
	private PImage image04 = new PImage();


	/**
	* Conttructeur de GuiView 
	* Permet de créer l'interface graphique
	* @param m Le CounterModel
	*/
	public GuiView(CounterModel m)
	{
		m_model = m;
		m.addObserver(this);
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				createAndShowGUI();
			}
		});
	}
	/**
	* Permet de créer la fenêtre en placant tout ses composants.
	*/
	public void createAndShowGUI()
	{
		//Initialisationdes components
		m_textTitreImage.setEditable(true);
		m_textMotCle.setEditable(true);
		//Initialisation du layout des components
		//Creation de la fenêtre
		JFrame frame = new JFrame();
		//Creation du panel général
		JPanel panel = new JPanel();
		//On utilise le panel générale comme une box (BorderLayout)
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
/*******************************************PANEL Recherche et Langue ***********************************************/

		//On creer le panel du haut, permettant de faire une recherche et de changer la langue
		JPanel panelHaut = new JPanel();
		panelHaut.setPreferredSize(new Dimension(800,50));
		panelHaut.add(m_textRecherche);
		panelHaut.add(m_choixLangue);
		panel.add(panelHaut);
	
/************************************* Panel Corp du programme ***************************************************/

		JPanel panelPrincipale = new JPanel();
		panelPrincipale.setLayout(new BoxLayout(panelPrincipale, BoxLayout.LINE_AXIS));

/******************************Sous-Panel Arbre **************/

		JPanel panelTree = new JPanel();
		panelTree.setPreferredSize(new Dimension(200,550));
		panelTree.add(new ArbreChemin(new File(".")));
		panelPrincipale.add(panelTree);

/****************************Sous-Panel Gestion Image ********/

		JPanel panelImage = new JPanel();
		panelImage.setLayout(new BoxLayout(panelImage, BoxLayout.PAGE_AXIS));
		panelImage.setPreferredSize(new Dimension(600,550));	
/*********Sous-sous-panel Image courante ***/
		JPanel panelImageCourante = new JPanel();
		panelImageCourante.setLayout(new BoxLayout(panelImageCourante, BoxLayout.LINE_AXIS));
		panelImageCourante.setPreferredSize(new Dimension(600,350));
/** Visualisation image courante */
	
		//imageCourante.setPreferredSize(new Dimension(400,350));
		panelImageCourante.add(ip.getImage());

/** Panel Modification Text/MotCle */

		JPanel panelModification = new JPanel();
		panelModification.setLayout(new BoxLayout(panelModification, BoxLayout.PAGE_AXIS));
		panelModification.setPreferredSize(new Dimension(200,350));
		//Le titre de l'image courante
		m_textTitreImage.setPreferredSize(new Dimension(200,100));
		panelModification.add(m_textTitreImage);
		//Les mot clés de l'image courante
		m_textMotCle.setPreferredSize(new Dimension(200,250));
		panelModification.add(m_textMotCle);
		//Ajout du panel modification dans image courante 
		panelImageCourante.add(panelModification);
		//Rajout de l'image courante dans image
		panelImage.add(panelImageCourante);

/** Panel quatres images suivantes */

		JPanel panelImageSuiv = new JPanel();
		panelImageSuiv.setLayout(new BoxLayout(panelImageSuiv, BoxLayout.LINE_AXIS));
		panelImageSuiv.setPreferredSize(new Dimension(600,200));
		panelImageSuiv.add(btSuivant);
		panelImageSuiv.add(image01.getImage());
		panelImageSuiv.add(image02.getImage());
		panelImageSuiv.add(image03.getImage());
		panelImageSuiv.add(image04.getImage());
		panelImageSuiv.add(btPrecedent);
		//Rajout des quatres images dans image
		panelImage.add(panelImageSuiv);
		//rajout de panel image dans le panel principale
		panelPrincipale.add(panelImage);
		//rajout du panel principale dans le panel général
		panel.add(panelPrincipale);
		
/*********************************** Fin des panels *********************************************************/
		//Rajoute du panel général dans la fenêtre
		frame.add(panel);
		//Finalisation du layout
		frame.pack();
		//On met un taille par défaut à la fenêtre
		frame.setSize(800,600);
		//On rajoute un titre à la fenêtre
		frame.setTitle("Gestionnaire d'images");
		//Pour quitter le programme quand on ferme la fenêtre.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Afficher la fenêtre au centre de l'écran
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	/**
	* Permet de rajouter des évènements
	*/
	public void addListenersToView(CounterController cont)
	{
		//Rajouter des actions au controller
		btSuivant.addActionListener(cont);
	}
	public void update(Observable o, Object arg)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				m_textTitreImage.setText(""+ m_model.getValeur());			
			}
		});
	}
	public JButton getIncBtn()
	{
		return btSuivant;
	}
}
