package controller;

import model.CounterModel;
import view.GuiView;

/**
* Classe permettant de gérer l'application
*/
public class CounterController 
{
	//Le model de l'application
	private CounterModel m_model;
	//La vue de l'application
	private GuiView m_view;	

	//Variable de l'image courante	
	


	/**
	* Constructeur de la classe CounterController
	* @param m Le CounterModel de l'application
	* @param v Le GuiView de l'application
	*/
	public CounterController(CounterModel m, GuiView v)
	{
		m_model = m;
		m_view = v;
		v.addListenersToView(this);
	}
	/**
	* Permet de mettre à jour l'image courante
	*/
	public void setImageCourante()
	{

	}
	/**
	* Permet de modifier le nom de l'image courante
	*/
	public void setNameImageCourante(String nom)
	{

	}
	/**
	* Permet de modifier les tags de l'image courante
	*/
	public void setTagImageCourante(String tag)
	{

	} 
}
