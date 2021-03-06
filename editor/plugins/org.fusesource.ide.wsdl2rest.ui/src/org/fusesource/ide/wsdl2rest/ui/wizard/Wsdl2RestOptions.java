/*******************************************************************************
 * Copyright (c) 2018 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at https://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/ 
package org.fusesource.ide.wsdl2rest.ui.wizard;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;

/**
 * Collects the various data points needed for the wsdl2rest utility.
 * @author brianf
 *
 */
public class Wsdl2RestOptions {

	private static final String TARGET_REST_SERVICE_ADDRESS = "targetRestServiceAddress"; //$NON-NLS-1$
	private static final String TARGET_SERVICE_ADDRESS = "targetServiceAddress"; //$NON-NLS-1$
	private static final String DESTINATION_CAMEL = "destinationCamel"; //$NON-NLS-1$
	private static final String DESTINATION_JAVA = "destinationJava"; //$NON-NLS-1$
	private static final String PROJECT_NAME = "projectName"; //$NON-NLS-1$
	private static final String WSDL_URL = "wsdlURL"; //$NON-NLS-1$

	private String wsdlURL;
	private String projectName;
	private String destinationJava;
	private String destinationCamel;
	private String targetServiceAddress;
	private String targetRestServiceAddress;

	private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	/**
	 * URL to the WSDL to be processed by the wsdl2rest utility.
	 * @return String
	 */
	public String getWsdlURL() {
		return wsdlURL;
	}

	/**
	 * Set URL to the WSDL to be processed by the wsdl2rest utility.
	 * @param wsdlURL
	 */
	public void setWsdlURL(String wsdlURL) {
		String oldValue = this.wsdlURL;
		this.wsdlURL = wsdlURL;
		firePropertyChange(WSDL_URL, oldValue, wsdlURL);
	}

	/**
	 * Project used for the destination of the files generated by the wsdl2rest utility.
	 * @return String
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Set Project used for the destination of the files generated by the wsdl2rest utility.
	 * @param projectName
	 */
	public void setProjectName(String projectName) {
		String oldValue = this.projectName;
		this.projectName = projectName;
		firePropertyChange(PROJECT_NAME, oldValue,  projectName);
	}

	/**
	 * Destination of the Java files generated by the wsdl2rest utility.
	 * @return String
	 */
	public String getDestinationJava() {
		return destinationJava;
	}

	/**
	 * Set Destination of the Java files generated by the wsdl2rest utility.
	 * @param destinationJava
	 */
	public void setDestinationJava(String destinationJava) {
		String oldValue = this.destinationJava;
		this.destinationJava = destinationJava;
		firePropertyChange(DESTINATION_JAVA, oldValue, destinationJava);
	}

	/**
	 * Destination of the Camel files generated by the wsdl2rest utility.
	 * @return String
	 */
	public String getDestinationCamel() {
		return destinationCamel;
	}

	/**
	 * Set Destination of the Camel configuration generated by the wsdl2rest utility.
	 * @param destinationCamel
	 */
	public void setDestinationCamel(String destinationCamel) {
		String oldValue = this.destinationCamel;
		this.destinationCamel = destinationCamel;
		firePropertyChange(DESTINATION_CAMEL, oldValue, destinationCamel);
	}

	/**
	 * Target Service Address used by the wsdl2rest utility.
	 * @return String
	 */
	public String getTargetServiceAddress() {
		return targetServiceAddress;
	}

	/**
	 * Set Target Service Address used by the wsdl2rest utility.
	 * @param targetServiceAddress
	 */
	public void setTargetServiceAddress(String targetServiceAddress) {
		String oldValue = this.targetServiceAddress;
		this.targetServiceAddress = targetServiceAddress;
		firePropertyChange(TARGET_SERVICE_ADDRESS, oldValue, targetServiceAddress);
	}

	/**
	 * Target Rest Service Address used by the wsdl2rest utility.
	 * @return String
	 */
	public String getTargetRestServiceAddress() {
		return targetRestServiceAddress;
	}

	/**
	 * Set Target Rest Service Address used by the wsdl2rest utility.
	 * @param targetServiceAddress
	 */
	public void setTargetRestServiceAddress(String targetRestServiceAddress) {
		String oldValue = this.targetRestServiceAddress;
		this.targetRestServiceAddress = targetRestServiceAddress;
		firePropertyChange(TARGET_REST_SERVICE_ADDRESS, oldValue, targetRestServiceAddress);
	}

	/**
	 * @param listener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * @param listener
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

	/**
	 * @param propertyName
	 * @param oldValue
	 * @param newValue
	 */
	protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		changeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	public IProject getProject() {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName());
	}
}
