package es.uned.lsi.eped.pract2023_2024;

public class Tune implements TuneIF {
	private String title;
	private String author;
	private String genre;
	private String album;
	private int year;
	private int duration;

	public Tune(String title, String author, String genre, String album, int year,
			int duration) throws IllegalArgumentException {

		if (title.isEmpty() || author.isEmpty() || genre.isEmpty() || album.isEmpty()
				|| year <= 0 || duration <= 0)
			throw new IllegalArgumentException();

		this.title = title;
		this.author = author;
		this.genre = genre;
		this.album = album;
		this.year = year;
		this.duration = duration;
	}

	@Override
	public boolean match(QueryIF q) {
		return matchTitle(q) && matchAuthor(q) && matchGenre(q) && matchAlbum(q)
				&& matchYear(q) && matchDuration(q);
	}

	private boolean matchTitle(QueryIF q) {
		return q.getTitle().isEmpty() || q.getTitle().equalsIgnoreCase(title);
	}

	private boolean matchAuthor(QueryIF q) {
		return q.getAuthor().isEmpty()|| q.getAuthor().equalsIgnoreCase(author);
	}

	private boolean matchGenre(QueryIF q) {
		return q.getGenre().isEmpty() || q.getGenre().equalsIgnoreCase(genre);
	}

	private boolean matchAlbum(QueryIF q) {
		return q.getAlbum().isEmpty() || q.getAlbum().equalsIgnoreCase(album);
	}

	private boolean matchYear(QueryIF q) {
		int year_min = q.getMin_year();
		int year_max = q.getMax_year();
		if (year_min == -1 ) year_min = Integer.MIN_VALUE;
		if (year_max == -1 ) year_max = Integer.MAX_VALUE;
		
		return (year >= year_min && year <= year_max);
	}

	private boolean matchDuration(QueryIF q) {
		int min_duration = q.getMin_duration();
		int max_duration = q.getMax_duration();
		if (min_duration == -1 ) min_duration = Integer.MIN_VALUE;
		if (max_duration == -1 ) max_duration = Integer.MAX_VALUE;
		
		return (duration >= min_duration && duration <= max_duration); 
	}

}
