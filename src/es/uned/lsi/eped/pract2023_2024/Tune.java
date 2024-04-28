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
		return q.getMin_year() == -1
				|| q.getMin_year() <= year && q.getMax_year() == -1
				|| q.getMax_year() >= year;
	}

	private boolean matchDuration(QueryIF q) {
		return q.getMin_duration() == -1
				|| q.getMin_duration() <= duration && q.getMax_duration() == -1
				|| q.getMax_duration() >= duration;
	}

}
