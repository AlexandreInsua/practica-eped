package es.uned.lsi.eped.pract2023_2024;

import java.util.Iterator;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class Player implements PlayerIF {

	private int maxmaxRecentlyPlayed;
	private TuneCollection repository;
	private List<PlayList> playLists;
	private PlayBackQueue playBackQueue;
	private RecentlyPlayed recentlyPlayed;

	public Player(TuneCollection tCollection, int maxRecentlyPlayed) {
		this.repository = tCollection;
		this.maxmaxRecentlyPlayed = maxRecentlyPlayed;
		this.playLists = new List<PlayList>();
		this.playBackQueue = new PlayBackQueue();
		this.recentlyPlayed = new RecentlyPlayed(maxRecentlyPlayed);
	}

	@Override
	public List<String> getPlayListIDs() {
		if (this.playLists.size() == 0)
			return null;
		List<String> ids = new List<String>();

		IteratorIF<PlayList> it = this.playLists.iterator();
		while (it.hasNext()) {
			ids.insert(ids.size() + 1, it.getNext().getId());
		}
		return ids;
	}

	@Override
	public ListIF<Integer> getPlayListContent(String playListID) {
		IteratorIF<PlayList> it = this.playLists.iterator();

		while (it.hasNext()) {
			PlayList playList = it.getNext();
			if (playList.getId() == playListID) {
				return playList.getPlayList();
			}
		}
		return new List<Integer>();
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
		this.playLists.insert(this.playLists.size() + 1, new PlayList(playListID));
	}

	@Override
	public void removePlayList(String playListID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListOfTunesToPlayList(String playListID, ListIF<Integer> lT) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSearchToPlayList(String playListID, String t, String a, String g,
			String al, int min_y, int max_y, int min_d, int max_d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTuneFromPlayList(String playListID, int tuneID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListOfTunesToPlayBackQueue(ListIF<Integer> lT) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSearchToPlayBackQueue(String t, String a, String g, String al,
			int min_y, int max_y, int min_d, int max_d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPlayListToPlayBackQueue(String playListID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearPlayBackQueue() {
		// TODO Auto-generated method stub

	}

	@Override
	public void play() {
		// TODO Auto-generated method stub

	}

}
