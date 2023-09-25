
public class Temperatura {

	private double celsius;
	private double farenheit;

	public Temperatura(double celsius) {
		this.celsius = celsius;
		this.farenheit = toFarenheit(celsius);
	}

	/**
	 * @return the celsius
	 */
	protected double asCelsius() {
		return celsius;
	}

	/**
	 * @param the temperature in celsius to set
	 */
	protected void setCelsius(double celsius) {
		this.celsius = celsius;
		this.farenheit = toFarenheit(celsius);
	}

	/**
	 * @return the farenheit
	 */
	protected double asFarenheit() {
		return farenheit;
	}

	/**
	 * @param the temperature in farenheit to set
	 */
	protected void setFarenheit(double farenheit) {
		this.farenheit = farenheit;
		this.celsius = toCelsius(farenheit);
	}
	
	private double toFarenheit(double celsius) {
		return (celsius * 9 / 5) + 32;
	}
	
	private double toCelsius(double farenheit) {
		return (farenheit - 32) * 5 / 9;
	}

}
