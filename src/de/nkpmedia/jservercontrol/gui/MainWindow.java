package de.nkpmedia.jservercontrol.gui;

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

public class MainWindow
{

	private JFrame frame;
	private JPanel centerPanel;
	private JPanel headPanel;
	private JPanel footerPanel;

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
					MainWindow window = new MainWindow();
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
	public MainWindow()
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
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnHosts = new JMenu("Hosts");
		menuBar.add(mnHosts);
		
		JMenu mnServices = new JMenu("Services");
		menuBar.add(mnServices);
		
		// JPanel (Head) wird erstellt
		this.headPanel = new JPanel();
		this.headPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.headPanel.add(new JCheckBox("Select all"));
		this.headPanel.add(new JLabel("Server:"));
		frame.getContentPane().add(this.headPanel, BorderLayout.NORTH);
		
        // JPanel wird erzeugt
        this.centerPanel = new JPanel();
        this.centerPanel.setLayout(new GridLayout(0, 1, 0, 0));
        
        // JScrollPane wird erzeugt; dabei wird über den 
        // Konstruktor direkt unser JPanel hinzugefügt
        JScrollPane centerScroll = new JScrollPane (this.centerPanel, 
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        centerScroll.setPreferredSize(new Dimension(1100, 600));
        
        JServerMonitorPanel panel_1 = new JServerMonitorPanel();
        this.centerPanel.add(panel_1);
        JServerMonitorPanel panel_2 = new JServerMonitorPanel();
        this.centerPanel.add(panel_2);
        JServerMonitorPanel panel_3 = new JServerMonitorPanel();
        this.centerPanel.add(panel_3);
        JServerMonitorPanel panel_4 = new JServerMonitorPanel();
        this.centerPanel.add(panel_4);
        JServerMonitorPanel panel_5 = new JServerMonitorPanel();
        this.centerPanel.add(panel_5);
        JServerMonitorPanel panel_6 = new JServerMonitorPanel();
        this.centerPanel.add(panel_6);
        JServerMonitorPanel panel_7 = new JServerMonitorPanel();
        this.centerPanel.add(panel_7);
        JServerMonitorPanel panel_8 = new JServerMonitorPanel();
        this.centerPanel.add(panel_8);
        JServerMonitorPanel panel_9 = new JServerMonitorPanel();
        this.centerPanel.add(panel_9);
        JServerMonitorPanel panel_10= new JServerMonitorPanel();
        this.centerPanel.add(panel_10);
        
        // JScrollPane wird dem Dialog hinzugefügt
        frame.getContentPane().add(centerScroll, BorderLayout.CENTER);
        // Wir lassen unseren Dialog anzeigen
        
        // JPanel (Head) wird erstellt
     	this.footerPanel = new JPanel();
     	this.footerPanel.add(new JButton("Options"));
     	frame.getContentPane().add(this.footerPanel, BorderLayout.SOUTH);
        
        
        
        
	}
}
