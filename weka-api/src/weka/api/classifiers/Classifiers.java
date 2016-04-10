package weka.api.classifiers;

//JAVA PACKAGES
import java.util.Random;

//WEKA PACKAGES
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.Classifier;

/**
 * SUPERCLASE QUE CONTIENE LOS METODOS PARA EVALUAR LOS CLASIFICADORES
 */
public class Classifiers
{
	private Evaluation eval;
	
	/**
	 * METODO QUE EVALUA LOS CLASIFICADORES
	 * @param cls	CLASIFICADOR A EVALUAR
	 */
	public void evaluateClassi(Classifier cls)
	{
		try 
		{
			eval = new Evaluation(gui.MainClass.data);
			Random rand = new Random(1);
			int folds = 10;
			eval.crossValidateModel(cls, gui.MainClass.data, folds, rand);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * @return		LA INFORMACIÓN RESUMIDA DEL RESULTADO DE EVALUACION
	 */
	public String getEvaluationResultSummary()
	{
		return eval.toSummaryString();
	}
	
	/**
	 * 
	 * @return		INFORMACION DETALLADA DE LA EVALUACION
	 * @throws Exception
	 */
	public String getEvluationResultDetails() throws Exception
	{
		return eval.toClassDetailsString();
	}
	
	/**
	 * @return		MATRIZ DE CONFUSION
	 * @throws Exception
	 */
	public String getConfusionMatrix() throws Exception
	{
		return eval.toMatrixString();
	}
	
	
}
