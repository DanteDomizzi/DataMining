package gui;

//JAVA PACKAGES
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import weka.api.classifiers.*;


@SuppressWarnings("serial")
public class FrmClassifications extends JFrame {
	
	private static final String TITLE = "CLASIFICADORES";
	private JLabel titulo;
	
	public FrmClassifications()
	{
		//new AdaBoost().doAdaBoost();
		initElements();
	}
	
	private void initElements()
	{
		//CREACIÓN DE LA VENTANA
		this.setBounds(200,100,800,500);
		this.setTitle(TITLE);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		
		
		titulo = new JLabel("Clasificadores");
		titulo.setBounds(300,0,200,40);
		this.add(titulo);
		
		//TABLA DE DATOS
		JScrollPane scroll = new JScrollPane();
		DefaultTableModel dataTableModel = cargarTabla();
		JTable dataTable = new JTable(dataTableModel);
		dataTable.setEnabled(true);
		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scroll.setViewportView(dataTable);
		scroll.setBounds(20,50,755,400);
		this.add(scroll);
		
	}
	
	private DefaultTableModel cargarTabla()
	{
		 
		AdaBoost ada = new AdaBoost();
		ada.doAdaBoost();
		ada.evaluateClassi();
		System.out.println(ada.getEvaluationResultSummary());
		
		try {
			System.out.println(ada.getEvluationResultDetails());
			System.out.println(ada.getConfusionMatrix());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] columns = {"Clasificador","Precisión","Exactitud","Sensibilidad"};
		/*for(int i=0;i<columns.length;i++)
		{
			dtm.addColumn(columns[i]);
		}*/
		
		Object[][] tablecontent = {{"AdaBoost",ada.getPrecision(),ada.getExactitud(),ada.getPrecision()},
								   {"NaiveBayes","","",""},
								   {"ID3","","",""},
								   {"RandomForest","","",""}};
		System.out.println("ENTROOO");
		return new DefaultTableModel(tablecontent,columns);
		
	}
}
