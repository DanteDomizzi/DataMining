package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import weka.api.classifiers.*;


@SuppressWarnings("serial")
public class FrmClassifications extends JFrame {
	
	private static final String TITLE = "CLASIFICADORES";
	private JLabel titulo;
	
	public FrmClassifications()
	{
		new AdaBoost().doAdaBoost();
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
		
		
		titulo = new JLabel("Algoritmo Apriori");
		titulo.setBounds(300,0,200,40);
		this.add(titulo);
	}
}