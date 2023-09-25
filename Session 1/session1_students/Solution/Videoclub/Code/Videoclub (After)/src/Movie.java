public class Movie {
	
	public static final MovieType REGULAR = new RegularMovie();
	public static final MovieType NEW_RELEASE = new NewReleaseMovie();
	public static final MovieType CHILDRENS = new ChildrenMovie();

	public Movie(String title, MovieType movieType) {
		this.title = title;
		this.type = movieType;
	}
		
	public String getTitle() {
		return title;
	}
	
	public void setType(MovieType type) {
		this.type = type;
	}

	public double getCharge(int daysRented) {
		return type.getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented) {
		return type.getFrequentRenterPoints(daysRented);
	}

	private String title;
	private MovieType type;
}
