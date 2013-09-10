package de.nkpmedia.jservercontrol.log;

public class Log
{
	public static void log(String log){
		System.out.println(log);
	}
	public static void logError(String log,Exception e){
		System.out.println(log);
		e.printStackTrace();
	}
	public static void logMessage(String log){
		System.out.println(log);
	}
}
