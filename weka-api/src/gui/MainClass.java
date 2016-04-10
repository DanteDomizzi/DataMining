package gui;

//JAVA PACKAGES
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

//WEKA PACKAGES
import weka.core.Instance;
import weka.core.Instances;
import weka.api.LoadSaveData;
import weka.api.DataPreparation;


@SuppressWarnings("serial")
public class MainClass extends JFrame
{
	private static final String TITLE = "PROYECTO FINAL";
	
	//ELEMENTOS DE LA INTERFAZ
	private DefaultTableModel dataTableModel;
	private JTable dataTable;
	
	//VARIABLES GLOBALES
	public static Instances data;
	private LoadSaveData lsd;
	private String file;
	private static ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	/**
	 * CONSTRUCTOR
	 */
	public MainClass()
	{
		lsd = new LoadSaveData();
		initElements();
	}
	
	/**
	 * CARGA LA INTERFAZ GRAFICA
	 */
	private void initElements()
	{
		
		//CREACIÓN DE LA VENTANA
		this.setBounds(200,100,800,500);
		this.setTitle(TITLE);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		
		//TABLA DE DATOS
		JScrollPane scroll = new JScrollPane();
		dataTableModel = new DefaultTableModel();
		dataTable = new JTable(dataTableModel);
		dataTable.setEnabled(true);
		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scroll.setViewportView(dataTable);
		scroll.setBounds(20,100,500,350);
		this.add(scroll);
		
		JButton btnCalcular = new JButton("Open file");
		btnCalcular.setBounds(50,55,100,20);
		btnCalcular.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				openFileChooser(evt);
			}
		});
		this.add(btnCalcular);
		
		JButton btnApriori = new JButton("Apriori");
		btnApriori.setBounds(580,55,100,20);
		btnApriori.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				openApriori(evt);
			}
		});
		btnApriori.setEnabled(false);
		this.add(btnApriori);
		buttons.add(btnApriori);
		
		JButton btnClasificador = new JButton("Clasificador");
		btnClasificador.setBounds(580,100,100,20);
		btnClasificador.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				openClasificador(evt);
			}
		});
		btnClasificador.setEnabled(false);
		this.add(btnClasificador);
		buttons.add(btnClasificador);
	}
	
	/**
	 * MANDA A LLAMAR EL FRAME CON LOS CLASIFICADORES
	 * @param evt
	 */
	private void openClasificador(ActionEvent evt)
	{
		new FrmClassifications();
	}
	
	/**
	 * MANDA A LLAMAR EL FRAME CON LAS REGLAS DE ASOCIACIÓN
	 * @param evt
	 */
	private void openApriori(ActionEvent evt)
	{
		new FrmAssociationRules();
	}
	
	/**
	 * ABRE EL SELECTOR DE ARCHIVOS Y CARGA EL CONJUNTO DE DATOS
	 * @param evt
	 */
	private void openFileChooser(ActionEvent evt)
	{
		try
		{
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(this);
			file = fileOpen.getSelectedFile().getAbsoluteFile().toString();
			data = lsd.openCSV(file);
			loadData(dataTableModel);
			for(JButton b:buttons)
			{
				b.setEnabled(true);
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
	}
	
	/**
	 * CARGA LOS DATOS EN LA TABLA
	 * @param dtm	MODELO DE LA TABLA DONDE SE CARGARAN LOS DATOS
	 */
	private void loadData(DefaultTableModel dtm)
	{
		
		Object[][] dataRow = new Object[data.numInstances()][data.numAttributes()];
		
		//OBTIENE LOS NOMBRES DE LOS ATRIBUTOS
		ArrayList<String> names = lsd.getNames();
		
		//MUESTRA LOS NOMBRES DE LOS ATRIBUTOS EN LA TABLA
		for(int i=0;i<names.size();i++)
		{
			dtm.addColumn(names.get(i));
		}
		
		//PREPROCESAMIENTO DE LOS DATOS
		DataPreparation.normalization();
		
		//MUESTRA LOS DATOS EN LA TABLA
		for(int i=0;i<data.numInstances();i++)
		{
			Instance ins = data.instance(i);
			
			for(int j=0;j<ins.numValues();j++)
			{
				if(ins.attribute(j).isNominal())
				{
					dataRow[i][j] = ins.stringValue(j);
				}
				else if(ins.attribute(j).isNumeric())
				{
					dataRow[i][j] = ins.value(j);
				}
			}
			
			dtm.addRow(dataRow[i]);
			
		}
	}
	
	public static void main(String[] args)
	{
		new MainClass();
	}
}
