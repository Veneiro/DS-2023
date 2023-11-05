package filesystem.output;

public interface Output {
	public void open();
	public void send();
	public void close();
}
