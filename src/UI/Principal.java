package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Models.Coche;
import Models.ListaOrdenada;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Principal {

	/**
	 * Atributos
	 */
	private JFrame frame;
	private ListaOrdenada<Coche> Coches;
	private JTextField txtMatricula;
	private JTextField textHoraEntrada;
	private JTextField textHoraSalida;
	private JTextField textImporte;
	private JButton btnEntrada;
	private JButton btnSalida;
	private JButton btnCaja;
	private JButton btnRegistrar;
	private JLabel lblTotalAPagar;
	private JLabel lblPagar;
	private JLabel lblCambio;
	private JLabel labelCambio;
	private JButton btnPagarYSalir;
	private Date HoraEntrada;
	private Date HoraSalida;
	private float PrecioTotal;
	private float Cambio;
	private float DiferenciaHora;
	
	//Getters and Setters
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public float getPrecioTotal() {
		return PrecioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		PrecioTotal = precioTotal;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		setComponetProperties();
		setComponentAdapters();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		labelCambio = new JLabel("\u20AC");
		btnEntrada = new JButton("Entrada Vehiculo");
		btnSalida = new JButton("Salida Vehiculo");
		btnCaja = new JButton("Caja del dia");
		btnRegistrar = new JButton("Registrar");
		textHoraEntrada = new JTextField();
		textHoraEntrada.setText("Hora Entrada");
		txtMatricula = new JTextField();
		txtMatricula.setText("Matricula");
		textHoraSalida = new JTextField();
		textHoraSalida.setText("Hora Salida");
		textImporte = new JTextField();
		textImporte.setText("Importe");
		lblTotalAPagar = new JLabel("Total a pagar");
		lblPagar = new JLabel(ObtenerPrecio()+"\u20AC");
		lblCambio = new JLabel("Cambio");
		btnPagarYSalir = new JButton("Pagar y salir del parking");
		
		
		
	}
	/**
	 * Adaptadores
	 */
	private void setComponentAdapters(){
		btnEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modoEntrada(); //Ponemos visibles(flase) los elementos que no queremos que aparezcan 
			}
		});
		
		btnSalida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modoSalida();//Ponemos visibles(flase) los elementos que no queremos que aparezcan 
			}
		});

		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				HoraEntrada = new Date();//Recogemos la fecha de salida
				Coche c = new Coche(HoraEntrada, HoraSalida, PrecioTotal); //Creamos un nuevo coche
				ListaOrdenada<Coche> ListaCoches =new ListaOrdenada<Coche>(); //Guardamos el coche creado
				ListaCoches.aniadir(c);
				modoSalida();//Ponemos visibles(flase) los elementos que no queremos que aparezcan 
			}
		});

		btnPagarYSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				HoraSalida=new Date();//Recogemos la fecha de salida
			}
		});

		btnCaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CajaDelDia window = new CajaDelDia(); //Al clikear sobre este boton nos cambiara la ventana
				window.getFrame().setVisible(true);
				frame.dispose();
			}
		});
	}
	/**
	 * Propiedades de los componentes
	 */
	private void setComponetProperties(){
		frame.setBounds(100, 100, 583, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);	
		
		btnEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrada.setBounds(29, 27, 134, 84);
		frame.getContentPane().add(btnEntrada);
				
		btnSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalida.setBounds(212, 27, 134, 84);
		frame.getContentPane().add(btnSalida);
				
		btnCaja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCaja.setBounds(396, 27, 134, 84);
		frame.getContentPane().add(btnCaja);
				
		txtMatricula.setHorizontalAlignment(SwingConstants.LEFT);
		txtMatricula.setBounds(129, 138, 115, 32);
		frame.getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);
		
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnRegistrar.setBounds(164, 312, 226, 84);
		frame.getContentPane().add(btnRegistrar);	
		
		textHoraEntrada.setBounds(129, 195, 115, 32);
		frame.getContentPane().add(textHoraEntrada);
		textHoraEntrada.setColumns(10);
		textHoraEntrada.setVisible(false);
			
		textHoraSalida.setBounds(129, 255, 115, 32);
		frame.getContentPane().add(textHoraSalida);
		textHoraSalida.setColumns(10);
		textHoraSalida.setVisible(false);
		
		lblTotalAPagar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalAPagar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotalAPagar.setBounds(405, 145, 125, 50);
		frame.getContentPane().add(lblTotalAPagar);
		lblTotalAPagar.setVisible(false);
			
		lblPagar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPagar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagar.setBounds(436, 196, 62, 25);
		frame.getContentPane().add(lblPagar);
		lblPagar.setVisible(false);
		
		textImporte.setBounds(396, 255, 118, 32);
		frame.getContentPane().add(textImporte);
		textImporte.setColumns(10);
		textImporte.setVisible(false);
				
		lblCambio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCambio.setBounds(405, 298, 125, 40);
		frame.getContentPane().add(lblCambio);
		lblCambio.setVisible(false);
				
		labelCambio.setHorizontalAlignment(SwingConstants.CENTER);
		labelCambio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelCambio.setBounds(436, 344, 62, 25);
		frame.getContentPane().add(labelCambio);
		labelCambio.setVisible(false);
		
		btnPagarYSalir.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnPagarYSalir.setBounds(29, 324, 245, 55);
		frame.getContentPane().add(btnPagarYSalir);
		btnPagarYSalir.setVisible(false);
	}

	

	public void modoEntrada(){
		textHoraEntrada.setVisible(false);
		textHoraSalida.setVisible(false);
		lblTotalAPagar.setVisible(false);
		lblPagar.setVisible(false);
		textImporte.setVisible(false);
		lblCambio.setVisible(false);
		labelCambio.setVisible(false);
		btnPagarYSalir.setVisible(false);
	}
	
	public void modoSalida(){
		btnRegistrar.setVisible(false);
		textHoraEntrada.setVisible(true);
		textHoraSalida.setVisible(true);
		lblTotalAPagar.setVisible(true);
		lblPagar.setVisible(true);
		textImporte.setVisible(true);
		lblCambio.setVisible(true);
		labelCambio.setVisible(true);
		btnPagarYSalir.setVisible(true);
	}
	
	private float DiferenciaHora(Date d1, Date d2, TimeUnit timeUnit) {
		long DiferenciaHora = d2.getTime() - d1.getTime();
		return timeUnit.convert(DiferenciaHora, TimeUnit.MINUTES);
	}

	private float ObtenerPrecio() {
		if (DiferenciaHora<=30) {
			PrecioTotal = 0.0492f*DiferenciaHora;
		} else if(DiferenciaHora>=31 && DiferenciaHora<=60){
			PrecioTotal = 0.0056f* DiferenciaHora;
		}else if(DiferenciaHora>=61 && DiferenciaHora<=720){
			PrecioTotal = 0.027f* DiferenciaHora;
		}else {
			PrecioTotal = 0.15f* DiferenciaHora;
		}
		
		return PrecioTotal;
	}
	
}
