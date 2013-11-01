package de.nkpmedia.jservercontrol.model.config;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;

import de.nkpmedia.jservercontrol.log.Log;
import de.nkpmedia.jservercontrol.model.elements.Host;
import de.nkpmedia.jservercontrol.model.elements.Service;
import de.nkpmedia.jservercontrol.model.elements.ServiceGroup;

public class ConfigLoader
{

	private ArrayList<ServiceGroup> serviceGroups = new ArrayList<ServiceGroup>();
	private ArrayList<Service> services = new ArrayList<Service>();
	private ArrayList<Host> hosts = new ArrayList<Host>();
	
	//Looks for the elements with the information about the elements, and starts the methods to load the informations
	public ConfigLoader(Document doc)
	{
		Element rootNode = doc.getRootElement();
		List<Element> rootNoteList = rootNode.getChildren();
	    Log.log("Loading the root element of the config");
	    // simple iteration to see the result on console
	    for(int i=0;i<=rootNoteList.size()-1;i++){
	    	Element element = rootNoteList.get(i);
	    	Log.log("Loading the "+element.getName());
	    	if(element.getName().equals("hosts"))
	    	{
	    		this.loadHosts(element);
	    	}
	    	else if(element.getName().equals("services"))
	    	{
	    	this.loadServices(element);
	    	}
	    	else if(element.getName().equals("servicegroups"))
	    	{
	    	this.loadServiceGroups(element);
	    	}
	    }
	    
	}
	//Loads the servicgropus
	private void loadServiceGroups(Element element)
	{
		List<Element> servicesGroupNoteList = element.getChildren();
		for(int i=0;i<=servicesGroupNoteList.size()-1;i++){
	    	Element serviceGroup = servicesGroupNoteList.get(i);
	    	Log.log("Loading servicegroup: "+serviceGroup.getAttributeValue("name"));
	    	ServiceGroup newServiceGroup = new ServiceGroup();
	    	newServiceGroup.name = serviceGroup.getAttributeValue("name");
	    	
	    	this.serviceGroups.add(newServiceGroup);
	    }
		
	}
	//Loads the serivces
	private void loadServices(Element element)
	{
		List<Element> servicesGroupNoteList = element.getChildren();
		for(int i=0;i<=servicesGroupNoteList.size()-1;i++){
	    	Element service = servicesGroupNoteList.get(i);
	    	Log.log("Loading service: "+service.getAttributeValue("name"));
	    	Service newService = new Service();
	    	newService.name = service.getAttributeValue("name");
	    	
	    	this.services.add(newService);
	    }
		
	}
	//Loads all the hosts
	private void loadHosts(Element element)
	{
		List<Element> hostsNoteList = element.getChildren();
		for(int i=0;i<=hostsNoteList.size()-1;i++){
	    	Element host = hostsNoteList.get(i);
	    	Log.log("Loading host: "+host.getAttributeValue("name"));
	    	Host newHost = new Host();
	    	newHost.name = host.getAttributeValue("name");
	    	newHost.ip = host.getChild("data").getChild("ip").getText();
	    	newHost.port = host.getChild("data").getChild("port").getText();
	    	newHost.passwd = host.getChild("data").getChild("passwd").getText();
	    	
	    	this.hosts.add(newHost);
	    }
	}

}
