package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import dao.MedicamentoDAO;
import dao.VentasDAO;
import models.Medicamento;
import models.Venta;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Insets;

public class StockView {

	private JFrame frame;
	private JTextField tfNombre;
	private JTextField tfPrincipioActivo;
	private JTextField tfTipo;
	private JTextField tfFecha;
	private JTextField tfUdsStock;
	private JTextField tfPrecio;
	private JTextField tfAddStock;
	private JTextField tfDeleteStock;
	private JTextField tfVentasDelDia;
	private JLabel lblTitulo;
	private JButton btnBack;
	private JButton btnForward;
	private JLabel lblNombre;
	private JLabel lblPrincipioActivo;
	private JLabel lblFecha1;
	private JLabel lblTipo;
	private JLabel lblFecha2;
	private JButton btnPedido;
	private JLabel lblStock;
	private JLabel lblPrecio;
	private JLabel lblunidades;
	private JLabel lbleuros;
	private JButton btnActualizarVentasDelDía;
	private JButton btnVenta;
	private JButton btnEditar;
	private JButton btnAddStock;
	private JButton btnDeleteStock;
	private JButton btnSave;
	private JButton btnCancel;
	private ArrayList<Medicamento> medicamentos;
	private MedicamentoDAO medicamentoDAO;
	private VentasDAO ventasDAO;
	private int indice;
	private JButton btnlogout;
	
	/**
	 * Create the application.
	 */
	public StockView() {
		initialize();
		frame.setVisible(true);
		this.ventasDAO = new VentasDAO();
		this.medicamentoDAO = new MedicamentoDAO();
		this.medicamentos = medicamentoDAO.getAll();
		indice = 0;
		if (this.medicamentos.size() > 0) {
			printMedicamento();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		this.configureUIComponents();
		this.configureUIListeners();
	}
	
	public void configureUIComponents() {
		frame.setBounds(100, 100, 566, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("MEDICAMENTOS");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(130, 16, 300, 43);
		frame.getContentPane().add(lblTitulo);
		
		btnBack = new JButton("<");
		btnBack.setMargin(new Insets(1, 1, 1, 1));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(26, 62, 43, 43);
		frame.getContentPane().add(btnBack);
		
		btnForward = new JButton(">");
		btnForward.setMargin(new Insets(1, 1, 1, 1));
		btnForward.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnForward.setBounds(482, 62, 43, 43);
		frame.getContentPane().add(btnForward);
		
		lblNombre = new JLabel("Nombre comercial");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(27, 123, 185, 13);
		frame.getContentPane().add(lblNombre);
		
		lblPrincipioActivo = new JLabel("Principio activo");
		lblPrincipioActivo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrincipioActivo.setBounds(27, 158, 185, 13);
		frame.getContentPane().add(lblPrincipioActivo);
		
		lblFecha1 = new JLabel("Fecha de incorporaci\u00F3n");
		lblFecha1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFecha1.setBounds(26, 222, 174, 24);
		frame.getContentPane().add(lblFecha1);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTipo.setBounds(27, 193, 185, 13);
		frame.getContentPane().add(lblTipo);
		
		lblFecha2 = new JLabel("al mercado");
		lblFecha2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFecha2.setBounds(26, 242, 250, 24);
		frame.getContentPane().add(lblFecha2);
		
		lblStock = new JLabel("Stock");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStock.setBounds(429, 174, 67, 13);
		frame.getContentPane().add(lblStock);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrecio.setBounds(429, 251, 67, 13);
		frame.getContentPane().add(lblPrecio);
		
		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfNombre.setBounds(200, 123, 200, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfPrincipioActivo = new JTextField();
		tfPrincipioActivo.setEditable(false);
		tfPrincipioActivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPrincipioActivo.setColumns(10);
		tfPrincipioActivo.setBounds(200, 158, 200, 19);
		frame.getContentPane().add(tfPrincipioActivo);
		
		tfTipo = new JTextField();
		tfTipo.setEditable(false);
		tfTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfTipo.setColumns(10);
		tfTipo.setBounds(200, 193, 200, 19);
		frame.getContentPane().add(tfTipo);
		
		tfFecha = new JTextField();
		tfFecha.setEditable(false);
		tfFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfFecha.setColumns(10);
		tfFecha.setBounds(200, 228, 200, 19);
		frame.getContentPane().add(tfFecha);
		
		tfUdsStock = new JTextField();
		tfUdsStock.setHorizontalAlignment(SwingConstants.CENTER);
		tfUdsStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfUdsStock.setEditable(false);
		tfUdsStock.setBounds(429, 122, 67, 49);
		frame.getContentPane().add(tfUdsStock);
		tfUdsStock.setColumns(10);
		
		tfPrecio = new JTextField();
		tfPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		tfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPrecio.setEditable(false);
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(429, 197, 67, 49);
		frame.getContentPane().add(tfPrecio);
		
		btnPedido = new JButton("PEDIDO");
		btnPedido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPedido.setBounds(25, 283, 113, 33);
		frame.getContentPane().add(btnPedido);
		
		btnActualizarVentasDelDía = new JButton("ACTUALIZAR VENTAS DEL D\u00CDA");
		btnActualizarVentasDelDía.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnActualizarVentasDelDía.setBounds(287, 326, 238, 30);
		frame.getContentPane().add(btnActualizarVentasDelDía);
		
		btnVenta = new JButton("VENTA");
		btnVenta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVenta.setBounds(155, 283, 113, 33);
		frame.getContentPane().add(btnVenta);
		
		btnEditar = new JButton("EDITAR MEDICAMENTO");
		btnEditar.setMargin(new Insets(1, 1, 1, 1));
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEditar.setBounds(180, 69, 200, 33);
		frame.getContentPane().add(btnEditar);
		
		tfAddStock = new JTextField();
		tfAddStock.setVisible(false);
		tfAddStock.setText("Uds. stock");
		tfAddStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfAddStock.setBounds(25, 326, 113, 30);
		frame.getContentPane().add(tfAddStock);
		tfAddStock.setColumns(10);
		
		btnAddStock = new JButton("A\u00F1adir stock");
		btnAddStock.setMargin(new Insets(1, 1, 1, 1));
		btnAddStock.setVisible(false);
		btnAddStock.setBounds(155, 328, 113, 29);
		frame.getContentPane().add(btnAddStock);
		
		tfDeleteStock = new JTextField();
		tfDeleteStock.setVisible(false);
		tfDeleteStock.setText("Uds. vendidas");
		tfDeleteStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDeleteStock.setColumns(10);
		tfDeleteStock.setBounds(25, 366, 113, 30);
		frame.getContentPane().add(tfDeleteStock);
		
		btnDeleteStock = new JButton("Actualizar stock");
		btnDeleteStock.setMargin(new Insets(1, 1, 1, 1));
		btnDeleteStock.setVisible(false);
		btnDeleteStock.setBounds(155, 368, 113, 29);
		frame.getContentPane().add(btnDeleteStock);
		
		tfVentasDelDia = new JTextField();
		tfVentasDelDia.setEditable(false);
		tfVentasDelDia.setText("0");
		tfVentasDelDia.setBounds(287, 366, 238, 30);
		frame.getContentPane().add(tfVentasDelDia);
		tfVentasDelDia.setColumns(10);
		
		btnSave = new JButton("Guardar cambios");
		btnSave.setVisible(false);
		btnSave.setMargin(new Insets(1, 1, 1, 1));
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.setBounds(287, 283, 113, 33);
		frame.getContentPane().add(btnSave);
		
		btnCancel = new JButton("Cancelar cambios");
		btnCancel.setVisible(false);
		btnCancel.setMargin(new Insets(1, 1, 1, 1));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(412, 283, 113, 33);
		frame.getContentPane().add(btnCancel);
		
		lblunidades = new JLabel("uds.");
		lblunidades.setHorizontalAlignment(SwingConstants.LEFT);
		lblunidades.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblunidades.setBounds(499, 135, 43, 24);
		frame.getContentPane().add(lblunidades);
		
		lbleuros = new JLabel("\u20AC");
		lbleuros.setHorizontalAlignment(SwingConstants.LEFT);
		lbleuros.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbleuros.setBounds(499, 209, 43, 24);
		frame.getContentPane().add(lbleuros);
		
		btnlogout = new JButton("Cerrar sesi\u00F3n");
		btnlogout.setMargin(new Insets(1, 1, 1, 1));
		btnlogout.setBounds(412, 19, 113, 33);
		frame.getContentPane().add(btnlogout);
	}
	
	public void configureUIListeners() {
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			printBack();
			}
		});
		
		btnForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			printForward();
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			btnSave.setVisible(true);
			btnCancel.setVisible(true);
			setEditable();
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Medicamento m = medicamentos.get(indice);
			m.setNombre(tfNombre.getText());
			m.setPrincipioActivo(tfPrincipioActivo.getText());
			m.setFechaIncorporacion(tfFecha.getText());
			m.setTipo(tfTipo.getText());
			m.setPrecio(Double.valueOf(tfPrecio.getText()));
			medicamentoDAO.update(m);
			setEditable();
			btnSave.setVisible(false);
			btnCancel.setVisible(false);
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setEditable();
			btnSave.setVisible(false);
			btnCancel.setVisible(false);
			}
		});
		
		btnActualizarVentasDelDía.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tfVentasDelDia.setText(String.valueOf(ventasDAO.consulta())+" ventas, "+String.valueOf(ventasDAO.ingresos()+"€ de ingresos."));
			}
		});
		
		btnVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medicamento m = medicamentos.get(indice);
				if (m.getCantidad()==0) {
					JOptionPane.showMessageDialog(btnVenta, "No hay unidades en stock.");
				} else {
					tfDeleteStock.setVisible(true);
					btnDeleteStock.setVisible(true);
				}
				
			}
		});
		
		btnDeleteStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clase de Java para obtener la fecha de hoy
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String fechaHoy = dtf.format(LocalDateTime.now());
				
				
				int amount = Integer.parseInt(tfDeleteStock.getText());
				Medicamento m = medicamentos.get(indice);
				
				// Se actualiza el stock en la BD si hay suficiente stock para vender
				
				if (amount<=m.getCantidad()) {
					medicamentoDAO.venta(amount, m);
					
					// Añadimos una venta con fecha de hoy a la tabla "ventas"
					Venta v = new Venta(0, fechaHoy, m.getId(), amount);
					ventasDAO.insert(v, m);
					
					// Venta efectuada
					JOptionPane.showMessageDialog(btnDeleteStock, "Unidades eliminades del stock.");
					new StockView();
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(btnDeleteStock, "No hay suficientes unidades en stock.");
					tfDeleteStock.setVisible(false);
					btnDeleteStock.setVisible(false);
				}
				
			}
		});
		
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tfAddStock.setVisible(true);
			btnAddStock.setVisible(true);
			}
		});
		
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int amount = Integer.parseInt(tfAddStock.getText());
			Medicamento m = medicamentos.get(indice);
			medicamentoDAO.addStock(amount, m);
			JOptionPane.showMessageDialog(btnAddStock, "Unidades añadidas al stock.");
			tfAddStock.setVisible(false);
			btnAddStock.setVisible(false);
			new StockView();
			frame.dispose();
			}
		});
		
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmar = JOptionPane.showConfirmDialog(btnlogout,
						"¿Estás seguro/a de que quieres cerrar sesión?", "Confirmar cierre de sesión",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (confirmar == JOptionPane.YES_OPTION) {
					frame.dispose();
					new LoginView();
				} else {
					JOptionPane.showMessageDialog(btnlogout, "Veo que has cambiado de opinión.");
				}
			}
		});
	}
	
	public void printMedicamento() {
	
		if (medicamentos.size() > 0) {
			Medicamento m = medicamentos.get(indice);
			tfNombre.setText(m.getNombre());
			tfPrincipioActivo.setText(m.getPrincipioActivo());
			tfTipo.setText(m.getTipo());
			tfFecha.setText(m.getFechaIncorporacion());
			tfUdsStock.setText(String.valueOf(m.getCantidad()));
			tfPrecio.setText(String.valueOf(m.getPrecio()));

			if (indice == 0) {
				btnBack.setVisible(false);
				btnForward.setVisible(true);
			} else if (indice == medicamentos.size() - 1) {
				btnForward.setVisible(false);
				btnBack.setVisible(true);
			}
			
		}
	}
	
	public void printBack() {
		indice--;
		printMedicamento();
	}
	
	public void printForward() {
		indice++;
		printMedicamento();
	}
	
	public void setEditable() {
		tfNombre.setEditable(!tfNombre.isEditable());
		tfPrincipioActivo.setEditable(!tfPrincipioActivo.isEditable());
		tfTipo.setEditable(!tfTipo.isEditable());
		tfFecha.setEditable(!tfFecha.isEditable());
		tfPrecio.setEditable(!tfPrecio.isEditable());
	}
}
