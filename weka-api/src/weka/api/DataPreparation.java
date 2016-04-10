package weka.api;

import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.Filter;

/**
 * CLASE CON LAS FUNCIONES PARA EL PREPROCESAMIENTO DE LOS DATOS
 */
public class DataPreparation 
{
	/**
	 * NORMALIZA EL CONJUNTO DE DATOS
	 * @param data
	 */
	public static void normalization()
	{
		Normalize norm =  new Normalize();
		try{
			norm.setInputFormat(gui.MainClass.data);
			gui.MainClass.data = Filter.useFilter(gui.MainClass.data, norm);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
