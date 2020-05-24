package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Lists;

public class ComparatorNameListsReversed implements Comparator<Lists> {

	@Override
	public int compare(Lists l1, Lists l2) {
		return l2.getListTitle().compareTo(l1.getListTitle());
	}

}
