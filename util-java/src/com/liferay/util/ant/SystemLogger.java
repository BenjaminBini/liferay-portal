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

package com.liferay.util.ant;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.util.StringUtils;

/**
 * @author Brian Wing Shun Chan
 */
public class SystemLogger extends DefaultLogger {

	@Override
	public void messageLogged(BuildEvent event) {
		int priority = event.getPriority();

		if (priority > msgOutputLevel) {
			return;
		}

		StringBundler sb = new StringBundler();

		boolean first = true;

		for (String line : StringUtil.splitLines(event.getMessage())) {
			if (!first) {
				sb.append(StringUtils.LINE_SEP);
			}

			first = false;

			sb.append("  ");
			sb.append(line);
		}

		String msg = sb.toString();

		if (priority != Project.MSG_ERR) {
			printMessage(msg, out, priority);
		}
		else {
			printMessage(msg, err, priority);
		}

		log(msg);
	}

}