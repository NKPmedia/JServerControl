package de.nkpmedia.jservercontrol.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class JServerMonitorPanel extends JPanel
{
	public JLabel domainLabel;
	public JLabel nameLabel;
	public JCheckBox aktivCheckBox;
	public JLabel portLabel;
	public JButton optionsButton;
	public JLabel statusLabel;
	JServerMonitorPanel (){
		super();
		this.init();
		this.initLayout();
		this.setPreferredSize(new Dimension(1100, 100));
	}
	
	private void init(){
		nameLabel = new JLabel("Name");
		domainLabel = new JLabel("Domain");
        portLabel = new JLabel("Port");
        aktivCheckBox = new JCheckBox("");
        optionsButton = new JButton("Options");
        statusLabel = new JLabel("Status");
	}
	private void initLayout(){
		GroupLayout gl_panel_1 = new GroupLayout(this);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(this.aktivCheckBox)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addComponent(this.nameLabel)
        					.addGap(18)
        					.addComponent(this.domainLabel)
        					.addGap(18)
        					.addComponent(this.optionsButton)
        					.addPreferredGap(ComponentPlacement.RELATED, 555, Short.MAX_VALUE)
        					.addComponent(this.statusLabel))
        				.addComponent(this.portLabel))
        			.addContainerGap())
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(this.nameLabel)
        				.addComponent(this.domainLabel)
        				.addComponent(this.aktivCheckBox)
        				.addComponent(this.optionsButton)
        				.addComponent(this.statusLabel))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(this.portLabel)
        			.addContainerGap(530, Short.MAX_VALUE))
        );
        this.setLayout(gl_panel_1);
	}

	public void setStatusLabel(String status)
	{
		this.statusLabel.setText(status);
		if(status.equals("Online"))
		{
			this.statusLabel.setForeground(Color.GREEN);
		}
		else
		{
			this.statusLabel.setForeground(Color.RED);
		}
	}
}
