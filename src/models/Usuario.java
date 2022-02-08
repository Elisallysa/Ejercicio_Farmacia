package models;

public class Usuario {

	//Atributos
	private int id;
	private String pin;
	
	//Constructor
	public Usuario(int id, String pin) {
		super();
		this.id = id;
		this.pin = pin;
	}
	
	//Getters  y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	//ToString
	@Override
	public String toString() {
		return "Pin [id=" + id + ", pin=" + pin + "]";
	}
	
	
}
