package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.Queue;

public class PlayBackQueue implements PlayBackQueueIF {

	private Queue<Integer> tuneIds;

	@Override
	public ListIF<Integer> getContent() {
		ListIF<Integer> ids = new List<>();
		IteratorIF<Integer> it = tuneIds.iterator();
		while (it.hasNext()) {
			ids.insert(ids.size() +1 , it.getNext());
		}
		return ids;
	}

	@Override
	public boolean isEmpty() {
		return this.tuneIds.isEmpty();
	}

	@Override
	public int getFirstTune() {
		return this.tuneIds.getFirst();
	}

	@Override
	public void extractFirstTune() {
		this.tuneIds.dequeue();
	}

	@Override
	public void addTunes(ListIF<Integer> lT) {
		IteratorIF<Integer> it = lT.iterator();
		while(it.hasNext()) {
			this.tuneIds.enqueue(it.getNext());
		}

	}

	@Override
	public void clear() {
		this.tuneIds.clear();
	}
}
