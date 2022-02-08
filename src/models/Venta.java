package models;

public class Venta {
	
	// Atributos
	private int id;
	private String fecha;
	private int medicamento;
	private int cantidad;
	
	//Constructor
	public Venta(int id, String fecha, int medicamento, int cantidad) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.medicamento = medicamento;
		this.cantidad = cantidad;
	}

	//Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(int medicamento) {
		this.medicamento = medicamento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	//ToString
	@Override
	public String toString() {
		return "Venta [id=" + id + ", fecha=" + fecha + ", medicamento=" + medicamento + ", cantidad=" + cantidad + "]";
	}
	
	
	
}
