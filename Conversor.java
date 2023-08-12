import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;

public class Conversor extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField valorIngresado;
	private JComboBox listaConversiones;
	private JLabel resultadoFinal;
	private JButton botonConvertir;
	private JButton botonSalir;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox listaTipoConversiones;
	private JLabel lblTipoConversion;
	private JLabel lblNewLabel_2;
	
	public static void main(String[] args) {
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Conversor() {
		setTitle("Conversions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tituloConversor = new JLabel("Conversor de Monedas");
		tituloConversor.setFont(new Font("Times New Roman", Font.BOLD, 26));
		tituloConversor.setBounds(107, 21, 268, 29);
		contentPane.add(tituloConversor);
		
		listaTipoConversiones = new JComboBox();
		rellenaListaTipoConversiones();
		listaTipoConversiones.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				rellenalistaConversiones((String) listaTipoConversiones.getSelectedItem());
			}

		});
		
				
		listaTipoConversiones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listaTipoConversiones.setBounds(205, 101, 240, 22);
		contentPane.add(listaTipoConversiones);
		
		lblTipoConversion = new JLabel("Tipo Conversión");
		lblTipoConversion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoConversion.setBounds(51, 98, 195, 29);
		contentPane.add(lblTipoConversion);
		
		listaConversiones = new JComboBox();
		rellenalistaConversiones((String) listaTipoConversiones.getSelectedItem());
		
		
		listaConversiones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listaConversiones.setBounds(51, 147, 394, 22);
		contentPane.add(listaConversiones);
		
					
		JLabel ingresarValor = new JLabel("Ingrese Valor a Convertir");
		ingresarValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ingresarValor.setBounds(51, 180, 212, 29);
		contentPane.add(ingresarValor);
		
		valorIngresado = new JTextField();
		valorIngresado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		valorIngresado.setBounds(273, 186, 116, 22);
		contentPane.add(valorIngresado);
		valorIngresado.setColumns(10);
		
		botonConvertir = new JButton("Convertir");
		botonConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = valorIngresado.getText();
				double valorNum = Double.parseDouble(valor);
				
				double tipoCambioDolar = 3950;
				double tipoCambioEuro = 4124 ;
				double resultadoFinal2 = 0;
				
				DecimalFormat formatear = new DecimalFormat("0.00");
				DecimalFormat formatear1 = new DecimalFormat("0.0");
				
				if (listaTipoConversiones.getSelectedIndex()== 0) {
					
					if (listaConversiones.getSelectedIndex() == 0) {
						resultadoFinal2 = (valorNum/tipoCambioDolar);
						resultadoFinal.setText( formatear.format(resultadoFinal2) + " Dolares USA");
					} else if (listaConversiones.getSelectedIndex() == 1) {
						resultadoFinal2 = (valorNum*tipoCambioDolar);
						resultadoFinal.setText(formatear.format(resultadoFinal2) + " Pesos COL" );
					} else if (listaConversiones.getSelectedIndex() == 2) {
						resultadoFinal2 = (valorNum/tipoCambioEuro);
						resultadoFinal.setText( formatear.format(resultadoFinal2) + " EUROS");
					} else if (listaConversiones.getSelectedIndex() == 3) {
						resultadoFinal2 = (valorNum*tipoCambioEuro);
						resultadoFinal.setText(formatear.format(resultadoFinal2) + " Pesos COL" );
					}
				
				}else if (listaTipoConversiones.getSelectedIndex()== 1)  {
					if (listaConversiones.getSelectedIndex() == 0) {
						resultadoFinal2 = (valorNum*1.8+32);resultadoFinal.setText( formatear1.format(resultadoFinal2) + " °Fahrenheit");
					} else if (listaConversiones.getSelectedIndex() == 1) {
						resultadoFinal2 = ((valorNum-32)/1.8);
						resultadoFinal.setText( formatear1.format(resultadoFinal2) + " °Celsius" );
					}
					
				}
			}
		});
		botonConvertir.setFont(new Font("Tahoma", Font.BOLD, 18));
		botonConvertir.setBounds(165, 219, 147, 29);
		contentPane.add(botonConvertir);
		
		botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botonSalir.setBounds(401, 315, 89, 23);
		contentPane.add(botonSalir);
		
		resultadoFinal = new JLabel("0");
		resultadoFinal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resultadoFinal.setBounds(157, 259, 310, 30);
		contentPane.add(resultadoFinal);
		
		JLabel textoResultado = new JLabel("Resultado");
		textoResultado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textoResultado.setBounds(31, 263, 116, 22);
		contentPane.add(textoResultado);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\alexl\\OneDrive\\Documentos\\Programa ONE\\Git - Github\\imagenes\\Alura Latam.png"));
		lblNewLabel.setBounds(401, 11, 89, 59);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\alexl\\OneDrive\\Documentos\\Programa ONE\\Git - Github\\imagenes\\ONE Oracle.png"));
		lblNewLabel_1.setBounds(10, 11, 77, 59);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("by ALEX LICONA");
		lblNewLabel_2.setForeground(new Color(0, 128, 0));
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 9));
		lblNewLabel_2.setBounds(10, 335, 95, 14);
		contentPane.add(lblNewLabel_2);
		
				
	}

	
	private void rellenaListaTipoConversiones() {
		listaTipoConversiones.addItem("Monedas");
		listaTipoConversiones.addItem("Temperatura");
		
	}
	

	private void rellenalistaConversiones(String seleccionEnlistaTipoConversiones) {
		listaConversiones.removeAllItems();
		if (seleccionEnlistaTipoConversiones.equals("Monedas")) {
			listaConversiones.addItem("Pesos COL a Dolar USA");
			listaConversiones.addItem("Dolar USA a Pesos COL");
			listaConversiones.addItem("Pesos COL a EURO");
			listaConversiones.addItem("EURO a Pesos COL");
		} else if (seleccionEnlistaTipoConversiones.equals("Temperatura")) {
			listaConversiones.addItem("Celsius a Fahreneheit");
			listaConversiones.addItem("Fahrenheit a Celsius");
			
		}
		
	}


	
}
