package temperature;

public class Temperature  {
	
	public static enum Unit { CELSIUS, FAHRENHEIT }
	
	public Temperature(double value) {
		this(value, Unit.CELSIUS);
	}
	
	public Temperature(double value, Unit unit) {
		if (unit.equals(Unit.CELSIUS))
			setCelsius(value);
		else if (unit.equals(Unit.FAHRENHEIT))
			setFahrenheit(value);
		else
			throw new AssertionError("Unidad de temperatura no implementada: " + unit);
	}
	
	public void setCelsius(double value) {
		this.value = value;
	}
	
	public void setFahrenheit(double value) {
		this.value = (value - 32) * 5 / 9;
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
