package weka.api;

//WEKA PACKAGES
import weka.core.Instances;
import weka.associations.Apriori;
import weka.associations.AssociationRule;

import java.util.List;


/**
 * CLASE QUE GENERA LAS REGLAS DE ASOCIACION
 */
public class AssociationRules 
{
	/**
	 * GENERA LAS REGLAS DE ASOCIACION CON EL ALGORITMO APRIORI
	 * @param data		Instancias del conjunto de datos
	 * @return			Lista de las 10 mejores reglas de asociación	
	 */
	public List<AssociationRule> getAprioriRules(Instances data)
	{
		Apriori model = new Apriori();
		try {
			//ESTABLECE EL SOPORTE
			model.setLowerBoundMinSupport(0.1);
			model.setUpperBoundMinSupport(0.2);
			
			//LE PASA EL CONJUNTO DE DATOS PARA GENERAR LAS REGLAS
			model.buildAssociations(data);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return model.getAssociationRules().getRules();
	}
}
