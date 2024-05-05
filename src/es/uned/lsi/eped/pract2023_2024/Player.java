package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class Player implements PlayerIF {

	private int maxmaxRecentlyPlayed;
	private TuneCollection repository;
	private PlayListManager playListManager;
	private PlayBackQueue playBackQueue;
	private RecentlyPlayed recentlyPlayed;

	public Player(TuneCollection tCollection, int maxRecentlyPlayed) {
		this.repository = tCollection;
		this.maxmaxRecentlyPlayed = maxRecentlyPlayed;
		this.playListManager = new PlayListManager();
		this.playBackQueue = new PlayBackQueue();
		this.recentlyPlayed = new RecentlyPlayed(maxRecentlyPlayed);
	}

	@Override
	public ListIF<String> getPlayListIDs() {
		ListIF<String> playListIds = playListManager.getIDs();
		if (playListIds == null) {
			playListIds = new List<String>();
		}
		return playListIds;
	}

	@Override
	public ListIF<Integer> getPlayListContent(String playListID) {
		PlayListIF playlist = playListManager.getPlayList(playListID);
		if (playlist == null) {
			return new List<Integer>();
		}
		return playlist.getPlayList();
	}

	@Override
	public ListIF<Integer> getPlayBackQueue() {
		return this.playBackQueue.getContent();

	}

	@Override
	public ListIF<Integer> getRecentlyPlayed() {
		return this.recentlyPlayed.getContent();
	}

	@Override
	public void createPlayList(String playListID) {
		this.playListManager.createPlayList(playListID);
	}

	@Override
	public void removePlayList(String playListID) {
		this.playListManager.removePlayList(playListID);

	}

	@Override
	public void addListOfTunesToPlayList(String playListID, ListIF<Integer> lT) {
		this.playListManager.getPlayList(playListID).addListOfTunes(lT);

	}

	@Override
	public void addSearchToPlayList(String playListID, String title, String author,
			String genre, String album, int min_year, int max_year, int min_duration,
			int max_duration) {
		ListIF<Integer> ids = new List<Integer>();
		QueryIF query = new Query(title, author, genre, album, min_year, max_year,
				min_duration, max_duration);

		for (int i = 0; i < repository.size(); i++) {
			Tune tune = repository.getTune(i);
			if (tune.match(query)) {
				ids.insert(ids.size() + 1, i);
			}
		}
		playListManager.getPlayList(playListID).addListOfTunes(ids);
	}

	@Override
	public void removeTuneFromPlayList(String playListID, int tuneID) {
		PlayList p = (PlayList) playListManager.getPlayList(playListID);
		p.removeTune(tuneID);

	}

	@Override
	public void addListOfTunesToPlayBackQueue(ListIF<Integer> lT) {
		playBackQueue.addTunes(lT);
	}

	@Override
	public void addSearchToPlayBackQueue(String title, String author, String genre,
			String album, int min_year, int max_year, int min_duration,
			int max_duration) {
		ListIF<Integer> ids = new List<Integer>();
		QueryIF query = new Query(title, author, genre, album, min_year, max_year,
				min_duration, max_duration);

		for (int i = 0; i < repository.size(); i++) {
			Tune tune = repository.getTune(i);
			if (tune.match(query)) {
				ids.insert(ids.size() + 1, i);
			}
		}
		playBackQueue.addTunes(ids);
	}

	@Override
	public void addPlayListToPlayBackQueue(String playListID) {
		playBackQueue.addTunes(playListManager.getPlayList(playListID).getPlayList());
	}

	@Override
	public void clearPlayBackQueue() {
		playBackQueue.clear();

	}

	@Override
	public void play() {
		if (!playBackQueue.isEmpty()) {
			recentlyPlayed.addTune(playBackQueue.getFirstTune());
			playBackQueue.extractFirstTune();
		}
	}

}
