/*
 *
 * Paros and its related class files.
 * 
 * Paros is an HTTP/HTTPS proxy for assessing web application security.
 * Copyright (C) 2003-2004 Chinotec Technologies Company
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the Clarified Artistic License
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Clarified Artistic License for more details.
 * 
 * You should have received a copy of the Clarified Artistic License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.parosproxy.paros.view;

import javax.swing.JPanel;

import java.awt.CardLayout;
/**
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class WorkbenchPanel extends JPanel {
	private javax.swing.JSplitPane splitVert = null;
	private javax.swing.JSplitPane splitHoriz = null;
	private javax.swing.JPanel paneStatus = null;
	private javax.swing.JPanel paneSelect = null;
	private javax.swing.JPanel paneWork = null;
	private org.parosproxy.paros.view.TabbedPanel tabbedStatus = null;
	private org.parosproxy.paros.view.TabbedPanel tabbedWork = null;
	private org.parosproxy.paros.view.TabbedPanel tabbedSelect = null;
	/**
	 * This is the default constructor
	 */
	public WorkbenchPanel() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
		java.awt.GridBagConstraints consGridBagConstraints1 = new java.awt.GridBagConstraints();

		this.setLayout(new java.awt.GridBagLayout());
		this.setSize(800, 600);
		this.setPreferredSize(new java.awt.Dimension(800,600));
		consGridBagConstraints1.gridx = 0;
		consGridBagConstraints1.gridy = 0;
		consGridBagConstraints1.weightx = 1.0;
		consGridBagConstraints1.weighty = 1.0;
		consGridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
		this.add(getSplitVert(), consGridBagConstraints1);
	}
	/**

	 * This method initializes splitVert	

	 * 	

	 * @return javax.swing.JSplitPane	

	 */    
	private javax.swing.JSplitPane getSplitVert() {
		if (splitVert == null) {
			splitVert = new javax.swing.JSplitPane();
			splitVert.setDividerLocation(480);
			splitVert.setDividerSize(3);
			splitVert.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
			splitVert.setResizeWeight(0.5D);
			splitVert.setPreferredSize(new java.awt.Dimension(800,400));
			splitVert.setTopComponent(getSplitHoriz());
			splitVert.setBottomComponent(getPaneStatus());
			splitVert.setContinuousLayout(false);
		}
		return splitVert;
	}

	/**

	 * This method initializes splitHoriz	

	 * 	

	 * @return javax.swing.JSplitPane	

	 */    
	private javax.swing.JSplitPane getSplitHoriz() {
		if (splitHoriz == null) {
			splitHoriz = new javax.swing.JSplitPane();
			splitHoriz.setLeftComponent(getPaneSelect());
			splitHoriz.setRightComponent(getPaneWork());
			splitHoriz.setDividerLocation(280);
			splitHoriz.setDividerSize(3);
			splitHoriz.setResizeWeight(0.3D);
			splitHoriz.setPreferredSize(new java.awt.Dimension(800,400));
			splitHoriz.setContinuousLayout(false);
			splitHoriz.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		}
		return splitHoriz;
	}

	/**

	 * This method initializes paneStatus	

	 * 	

	 * @return javax.swing.JPanel	

	 */    
	private javax.swing.JPanel getPaneStatus() {
		if (paneStatus == null) {
			paneStatus = new javax.swing.JPanel();
			paneStatus.setLayout(new CardLayout());
			paneStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
			paneStatus.add(getTabbedStatus(), getTabbedStatus().getName());
		}
		return paneStatus;
	}

	/**

	 * This method initializes paneSelect	

	 * 	

	 * @return javax.swing.JPanel	

	 */    
	private javax.swing.JPanel getPaneSelect() {
		if (paneSelect == null) {
			paneSelect = new javax.swing.JPanel();
			paneSelect.setLayout(new CardLayout());
			paneSelect.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
			paneSelect.add(getTabbedSelect(), getTabbedSelect().getName());
		}
		return paneSelect;
	}

	/**

	 * This method initializes paneWork	

	 * 	

	 * @return javax.swing.JPanel	

	 */    
	private javax.swing.JPanel getPaneWork() {
		if (paneWork == null) {
			paneWork = new javax.swing.JPanel();
			paneWork.setLayout(new CardLayout());
			paneWork.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
			paneWork.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
			paneWork.add(getTabbedWork(), getTabbedWork().getName());
		}
		return paneWork;
	}

	/**

	 * This method initializes tabbedStatus	

	 * 	

	 * @return com.proofsecure.paros.view.ParosTabbedPane	

	 */    
	public org.parosproxy.paros.view.TabbedPanel getTabbedStatus() {
		if (tabbedStatus == null) {
			tabbedStatus = new org.parosproxy.paros.view.TabbedPanel();
			tabbedStatus.setPreferredSize(new java.awt.Dimension(800,200));
			tabbedStatus.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
			tabbedStatus.setName("tabbedStatus");
			tabbedStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		}
		return tabbedStatus;
	}

	/**

	 * This method initializes tabbedWork	

	 * 	

	 * @return com.proofsecure.paros.view.ParosTabbedPane	

	 */    
	public org.parosproxy.paros.view.TabbedPanel getTabbedWork() {
		if (tabbedWork == null) {
			tabbedWork = new org.parosproxy.paros.view.TabbedPanel();
			tabbedWork.setPreferredSize(new java.awt.Dimension(600,400));
			tabbedWork.setName("tabbedWork");
			tabbedWork.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		}
		return tabbedWork;
	}

	/**

	 * This method initializes tabbedSelect	

	 * 	

	 * @return com.proofsecure.paros.view.ParosTabbedPane	

	 */    
	public org.parosproxy.paros.view.TabbedPanel getTabbedSelect() {
		if (tabbedSelect == null) {
			tabbedSelect = new org.parosproxy.paros.view.TabbedPanel();
			tabbedSelect.setPreferredSize(new java.awt.Dimension(200,400));
			tabbedSelect.setName("tabbedSelect");
			tabbedSelect.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		}
		
		return tabbedSelect;
	}

        }
