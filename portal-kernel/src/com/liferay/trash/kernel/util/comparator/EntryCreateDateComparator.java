/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.trash.kernel.util.comparator;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.trash.kernel.model.TrashEntry;

/**
 * @author     Sergio González
 * @deprecated As of 7.0.0, replaced by {@link
 *             com.liferay.trash.util.comparator.EntryCreateDateComparator}
 */
@Deprecated
public class EntryCreateDateComparator extends OrderByComparator<TrashEntry> {

	public static final String ORDER_BY_ASC = "TrashEntry.createDate ASC";

	public static final String ORDER_BY_DESC = "TrashEntry.createDate DESC";

	public static final String[] ORDER_BY_FIELDS = {"createDate"};

	public EntryCreateDateComparator() {
		this(false);
	}

	public EntryCreateDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(TrashEntry entry1, TrashEntry entry2) {
		int value = DateUtil.compareTo(
			entry1.getCreateDate(), entry2.getCreateDate());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}