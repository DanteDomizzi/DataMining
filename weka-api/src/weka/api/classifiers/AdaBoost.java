package weka.api.classifiers;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.meta.AdaBoostM1;

/**
 * CLASE QUE REALIZA EL ALGORITMO ADABOOST
 */
public class AdaBoost extends Classifiers
{
	
	/**
	 * METODO QUE EJECUTA EL ALGORITMO
	 */
	public void doAdaBoost()
	{
		// OPCIONES DEL ALGORITMO
		String options[] = {"-P","90", //PORCENTAJE QUE USARA PARA EL ENTRENAMIENTO
							"-S","1", //SEMILLA PARA EL RANDOM
							"-I","5"}; //NUMERO DE ITERACIONES
		AdaBoostM1 adaboost = new AdaBoostM1();
		try {
			adaboost.setOptions(options); //SE ESTABLECEN LAS OPCIONES
			adaboost.setClassifier(new NaiveBayes()); //SE ESTABLECE EL CLASIFICADOR A USAR
			adaboost.buildClassifier(gui.MainClass.data); //SE ESTABLECE EL CONJUNTO DE DATOS
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//SE IMPRIMEN LOS RESULTADOS
		System.out.println(adaboost);
		
	}
}
