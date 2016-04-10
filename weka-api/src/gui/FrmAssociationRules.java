package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import weka.api.AssociationRules;
import weka.associations.AssociationRule;



@SuppressWarnings("serial")
public class FrmAssociationRules extends JFrame
{
	
	private static final String TITLE = "REGLAS DE ASOCIACIÓN";
	private JLabel titulo;
	private List<AssociationRule> rules;
	
	public FrmAssociationRules()
	{
		this.rules = new AssociationRules().getAprioriRules(MainClass.data);
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
		
		JTextArea txtResultado = new JTextArea(5,20);
		txtResultado.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtResultado);
		scrollPane.setBounds(30,120,730,310);
		this.add(scrollPane);
		
		for(int i=0;i<rules.size();i++)
		{
			txtResultado.append((i+1)+".- "+ rules.get(i)+ "\n\n");
		}
		
	}
}
