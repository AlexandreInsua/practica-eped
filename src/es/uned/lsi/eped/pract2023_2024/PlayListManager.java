package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class PlayListManager implements PlayListManagerIF {
	
	ListIF<PlayListId> playListids;
	
	PlayListManager(){
		playListids = new List<PlayListId>();
	}

	@Override
	public boolean contains(String playListID) {
		IteratorIF<PlayListId> it = playListids.iterator();
		while( it.hasNext()) {
			if ( playListID == it.getNext().getId()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public PlayListIF getPlayList(String playListID) {
		IteratorIF<PlayListId> it = playListids.iterator();
		while( it.hasNext()) {
			if ( playListID == it.getNext().getId()) {
				return it.getNext().getPlayList();
			}
		}
		return null;
	}

	@Override
	public ListIF<String> getIDs() {
		ListIF<String> ids = new List<String>();
		IteratorIF<PlayListId> it = playListids.iterator();
		while( it.hasNext()) {
			ids.insert(ids.size()+1, it.getNext().getId());
		}
		return !ids.isEmpty()? ids : null;
	}

	@Override
	public void createPlayList(String playListID) {
		this.playListids.insert(this.playListids.size()+1, new PlayListId(playListID));
	}

	@Override
	public void removePlayList(String playListID) {
		int index = 1;
		IteratorIF<PlayListId> it = this.playListids.iterator();
		while(it.hasNext()) {
		 PlayListId playlist= it.getNext();
		 if (playlist.getId() == playListID) {
			 this.playListids.remove(index);
		 }
		}

	}

	class PlayListId {
		String id;
		PlayList playList;

		public PlayListId(String id, PlayList playList) {
			this.id = id;
			this.playList = playList;
		}
		
		public PlayListId(String id) {
			this.id = id;
			this.playList = new PlayList();
		}
		
		

		public String getId() {
			return id;
		}

		public PlayList getPlayList() {
			return playList;
		}

	}
}
