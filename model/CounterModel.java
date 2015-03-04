package model;

import java.util.Observable;

/**
* Classe permettant de gérer le model
*/
public class CounterModel extends Observable
{ 
	
	private int valeur;
	/**
	* Constructeur de la classe CounterModel
	*/
	public CounterModel()
	{

		valeur = 1;

	}
	public void incValue()
	{
		this.valeur++;
		setChanged();
		notifyObservers();
	}
	public int getValeur()
	{
		return this.valeur;
	}
}
