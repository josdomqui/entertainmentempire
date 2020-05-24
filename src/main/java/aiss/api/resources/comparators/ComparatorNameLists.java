package aiss.api.resources.comparators;

import java.util.Comparator;

import aiss.model.Lists;

public class ComparatorNameLists implements Comparator<Lists> {

	@Override
	public int compare(Lists l1, Lists l2) {
		return l1.getListTitle().compareTo(l2.getListTitle());
	}

}
