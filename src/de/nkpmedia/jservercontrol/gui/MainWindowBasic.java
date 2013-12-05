package de.nkpmedia.jservercontrol.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class MainWindowBasic
{

	public JFrame frame;
	public JPanel centerPanel;
	public JPanel headPanel;
	public JPanel footerPanel;
	public JMenu mnFile;
	public JMenuItem mntmNew;
	public JMenuItem mntmOpen;
	public JMenuItem mntmSave;
	public JMenuItem mntmExit;
	public JMenu mnHosts;
	public JMenu mnServices;
	public JScrollPane centerScroll;
	public JButton optionAllButton;
	public JMenuBar menuBar;
	public JCheckBox selectAll;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainWindowBasic window = new MainWindowBasic();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindowBasic()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1162, 671);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		mnHosts = new JMenu("Hosts");
		menuBar.add(mnHosts);
		
		mnServices = new JMenu("Services");
		menuBar.add(mnServices);
		
		// JPanel (Head) wird erstellt
		this.headPanel = new JPanel();
		this.headPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		selectAll = new JCheckBox("Select all");
		this.headPanel.add(selectAll);
		this.headPanel.add(new JLabel("Server:"));
		frame.getContentPane().add(this.headPanel, BorderLayout.NORTH);
		
        // JPanel wird erzeugt
        this.centerPanel = new JPanel();
        this.centerPanel.setLayout(new GridLayout(0, 1, 0, 0));
        
        // JScrollPane wird erzeugt; dabei wird über den 
        // Konstruktor direkt unser JPanel hinzugefügt
       centerScroll = new JScrollPane (this.centerPanel, 
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        centerScroll.setPreferredSize(new Dimension(1100, 600));
        
        JServerMonitorPanel panel_1 = new JServerMonitorPanel();
        this.centerPanel.add(panel_1);
        
        // JScrollPane wird dem Dialog hinzugefügt
        frame.getContentPane().add(centerScroll, BorderLayout.CENTER);
        // Wir lassen unseren Dialog anzeigen
        
        // JPanel (Head) wird erstellt
     	this.footerPanel = new JPanel();
     	optionAllButton = new JButton("Options");
     	this.footerPanel.add(optionAllButton);
     	frame.getContentPane().add(this.footerPanel, BorderLayout.SOUTH);
        
        
        
        
	}
}
