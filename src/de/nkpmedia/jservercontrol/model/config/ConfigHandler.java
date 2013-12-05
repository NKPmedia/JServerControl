package de.nkpmedia.jservercontrol.model.config;

import java.util.ArrayList;

import de.nkpmedia.jservercontrol.model.elements.Host;
import de.nkpmedia.jservercontrol.model.elements.Service;
import de.nkpmedia.jservercontrol.model.elements.ServiceGroup;

public class ConfigHandler
{

	private ArrayList<Host> hosts;
	private ArrayList<ServiceGroup> serviceGroups;
	private ArrayList<Service> services;

	public ConfigHandler(ConfigLoader configLoader)
	{
		this.hosts = configLoader.hosts;
		this.services = configLoader.services;
		this.serviceGroups = configLoader.serviceGroups;
	}

	public ArrayList<Host> getServerList()
	{
		this.refreshAllHosts();
		return this.hosts;
	}

	private void refreshAllHosts()
	{
		for(Host host : hosts){
			host.refreshData();
		}
		
	}

}
