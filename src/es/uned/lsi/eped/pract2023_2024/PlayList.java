package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

public class PlayList implements PlayListIF {

	private ListIF<Integer> tuneIds;

	public PlayList() {
		tuneIds = new List<>();
	}

	@Override
	public ListIF<Integer> getPlayList() {
		return tuneIds;
	}

	@Override
	public void addListOfTunes(ListIF<Integer> lT) {
		IteratorIF<Integer> it = lT.iterator();
		while (it.hasNext()) {
			tuneIds.insert(tuneIds.size() + 1, it.getNext());
		}
	}

	@Override
	public void removeTune(int tuneID) {
		IteratorIF<Integer> it = tuneIds.iterator();
		int index = 0;
		while (it.hasNext()) {
			Integer currentTuneId = it.getNext();
			if (currentTuneId == tuneID) {
				this.tuneIds.remove(index);
			}
			index++;
		}
	}
}
