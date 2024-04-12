package es.uned.lsi.eped.pract2023_2024;

public class Query implements QueryIF {

	private String title;
	private String author;
	private String genre;
	private String album;
	private int min_year;
	private int max_year;
	private int min_duration;
	private int max_duration;

	public Query(String title, String author, String genre, String album, int min_year,
			int max_year, int min_duration, int max_duration) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.album = album;
		this.min_year = min_year;
		this.max_year = max_year;
		this.min_duration = min_duration;
		this.max_duration = max_duration;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getAuthor() {
		return this.author;
	}

	@Override
	public String getGenre() {
		return this.genre;
	}

	@Override
	public String getAlbum() {
		return this.album;
	}

	@Override
	public int getMin_year() {
		return this.min_year;
	}

	@Override
	public int getMax_year() {
		return this.max_year;
	}

	@Override
	public int getMin_duration() {
		return this.min_duration;
	}

	@Override
	public int getMax_duration() {
		return this.max_duration;
	}

}
