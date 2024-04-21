package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.Queue;
import es.uned.lsi.eped.DataStructures.Stack;

public class RecentlyPlayed implements RecentlyPlayedIF {
	
	int max;
	Queue<Integer> ids;

	RecentlyPlayed(int max) {
		this.max = max;
		this.ids = new Queue<>();
	}

	@Override
	public ListIF<Integer> getContent() {
		List<Integer> ids = new List<>();
		IteratorIF<Integer> it = this.ids.iterator();
		
		while (it.hasNext()) {
			ids.insert(ids.size()+1, it.getNext());
		}
			return ids;
	}

	@Override
	public void addTune(int tuneID) {
		this.ids.enqueue(tuneID);			
		if (this.ids.size()>= this.max) {
			this.ids.dequeue();
		} 
	}
}
