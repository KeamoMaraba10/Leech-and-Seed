package acsse.csc2b.network;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Leecher {
	
	private String hostname;
	private DatagramSocket leecherSock;
	private DatagramPacket pack;
	private DatagramPacket recivePack;
	private int port;
	private String messageToSeeder;
	private ArrayList<File> listOfFiles;
	
	
	
	
	public Leecher(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
		
		
	}
	
	
	
//	private void setUpLeecher() {
//		
//		
//		
//	}
//	
	
	public void retrieveByIndex(int index) {
		
		try {
			leecherSock = new DatagramSocket();
			messageToSeeder = new String("FILE "+index);
			byte[] bytesToSend = messageToSeeder.getBytes();
			
			//Get the host name
			InetAddress address = InetAddress.getByName(hostname);
			
			pack = new DatagramPacket(bytesToSend, bytesToSend.length, address, port);
			
			leecherSock.receive(pack);
			
			//this needs to return the actual file
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public ArrayList<File> requestListOfFiles() {
		listOfFiles = new ArrayList<>();
		
		
	
			
			//Get the host name
			try {

				leecherSock = new DatagramSocket();		
				//recieve the response
				
				byte[] recieveBuffer = new byte[1024];
				
				recivePack = new DatagramPacket(recieveBuffer,recieveBuffer.length);
				leecherSock.receive(recivePack);
				
				
				
				String fileListAsString = new String(recivePack.getData(),0,recivePack.getLength());
				
				StringTokenizer token = new StringTokenizer(fileListAsString," ");
				String nameOfFile;
				
			while(token.hasMoreTokens()) {
					
				nameOfFile = token.nextToken();
					File file = new File("/data/"+nameOfFile);
					listOfFiles.add(file);
					
					
				}
				
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
	
		
		
		return listOfFiles;
		
	}
	

	
	
	

}
