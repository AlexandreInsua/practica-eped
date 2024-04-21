package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class PlayBackQueue implements PlayBackQueueIF {

	private List<Tune> tunes;
	
	
	PlayBackQueue (){
		this.tunes = new List<>();
	}
	
	
	@Override
	public ListIF<Integer> getContent() {
		IteratorIF<Tune> it = this.tunes.iterator();
		List<Integer> ids = new List<>();
		
		while (it.hasNext()) {
		ids.insert(ids.size() + 1, it.getNext().getId());	
		}
		return ids;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getFirstTune() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void extractFirstTune() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTunes(ListIF<Integer> lT) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
