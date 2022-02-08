package models;

public class Medicamento {

	// Atributos
	private int id;
	private String nombre;
	private String principioActivo;
	private String fechaIncorporacion;
	private String tipo;
	private int cantidad;
	private double precio;
	
	//Constructor
	public Medicamento(int id, String nombre, String principioActivo, String fechaIncorporacion, String tipo,
			int cantidad, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.principioActivo = principioActivo;
		this.fechaIncorporacion = fechaIncorporacion;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	//Getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrincipioActivo() {
		return principioActivo;
	}

	public void setPrincipioActivo(String principioActivo) {
		this.principioActivo = principioActivo;
	}

	public String getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	public void setFechaIncorporacion(String fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	//ToString
	@Override
	public String toString() {
		return "Medicamento [id=" + id + ", nombre=" + nombre + ", principioActivo=" + principioActivo
				+ ", fechaIncorporacion=" + fechaIncorporacion + ", tipo=" + tipo + ", cantidad=" + cantidad
				+ ", precio=" + precio + "]";
	}
	
}
