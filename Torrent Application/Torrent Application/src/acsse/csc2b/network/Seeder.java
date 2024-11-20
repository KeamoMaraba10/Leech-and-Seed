/**
 * 
 */
package acsse.csc2b.network;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.StringTokenizer;

import acsse.csc2b.gui.SeederGui;

/**
 * 
 */
public class Seeder {
	
	private int port = 2222;
	private DatagramSocket seederSock;
	private DatagramPacket sendPack;
	private DatagramPacket pack;
	private ArrayList<String> listOfFiles;
	//private int clientsPort;
	
	
	//every server must be binded to a port
	public Seeder(int port) {
		
		this.port = port;
		setUpConnection();
	}
	
	
	
	
	
	

	
	
	
	
	//this is to initialise the server connection
	private void setUpConnection() {
		
		try {
			while(true) {
				
			
			seederSock = new DatagramSocket(this.port);
			byte[] recieveData = new byte[1024];
			pack = new DatagramPacket(recieveData, recieveData.length);
			seederSock.receive(pack);
	
			String recieveStr = new String(pack.getData());//to convert the data we got back into a string
			
			   InetAddress seedIP = pack.getAddress();
	            int seedPort = pack.getPort();
			
			
			
			
			if(recieveStr.equalsIgnoreCase("LIST")) {
				//send multiple files
				sendListOfFiles();
				
			} else if (recieveStr.equalsIgnoreCase("FILE")) {
				
				
				//only send one file
				StringTokenizer token = new StringTokenizer(recieveStr);
				sendFileAtIndex(Integer.parseInt(token.nextToken()),seedIP,seedPort);
			}
			
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendFileAtIndex(int index, InetAddress ip, int port) {
	
		File fileToSend = new File("/data/"+listOfFiles.get(index));
		try {
			byte[] data = Files.readAllBytes(fileToSend.toPath());
			
			 sendPack = new DatagramPacket(data, data.length, ip, port);
			 seederSock.send(sendPack);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void sendListOfFiles() {
		
		for(String f : listOfFiles) {
			byte[] sendData = f.getBytes();
			pack = new DatagramPacket(sendData,sendData.length);
			
			try {
				seederSock.send(pack);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	 
	
		
	}
	
	
	

}
