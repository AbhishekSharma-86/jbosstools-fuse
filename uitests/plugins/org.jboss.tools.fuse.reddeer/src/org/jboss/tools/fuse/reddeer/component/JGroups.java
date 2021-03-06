/*******************************************************************************
 * Copyright (c) 2017 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at https://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.fuse.reddeer.component;

public class JGroups implements CamelComponent {

	@Override
	public String getPaletteEntry() {
		return "JGroups";
	}

	@Override
	public String getLabel() {
		return "jgroups:clusterName";
	}

	@Override
	public String getTooltip() {
		return "Component providing support for messages multicasted from- or to JGroups channels (org.jgroups.Channel).";
	}

}
