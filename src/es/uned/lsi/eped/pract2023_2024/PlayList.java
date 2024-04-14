package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class PlayList implements PlayListIF {

	private String id;
	private List<Tune> tunes; 
	
	PlayList(String playListId){
		this.id = playListId;
	}
	
	public String getId() {
		return this.id;
	}
	
	@Override
	public ListIF<Integer> getPlayList() {
		List<Integer> ids = new List<>();
		IteratorIF<Tune> it = this.tunes.iterator();
		while (it.hasNext()) {
			ids.insert(ids.size()+1, it.getNext().getId());
		}
		return ids;
	}

	@Override
	public void addListOfTunes(ListIF<Integer> lT) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTune(int tuneID) {
		// TODO Auto-generated method stub

	}

}
