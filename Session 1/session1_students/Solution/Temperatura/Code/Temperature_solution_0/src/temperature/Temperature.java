package temperature;

public class Temperature {
	
	public Temperature(double value) {
		this.value = value;
	}
	
	public double asCelsius() {
		return value;
	}
	
	public double asFahrenheit() {
		return value * 9 / 5 + 32;
	}

	// La representación interna del valor de la temperatura, en grados Celsius 
	private double value;
}
