package org.tsxuehu.Hadoop.HostIPRegister;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class HostIPReporter {
	static{
		try {
			broadcastAddr=InetAddress.getByName("10.3.11.255");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static InetAddress broadcastAddr;
	int sent2port;
	DatagramSocket sender;
	DatagramPacket sendpacket;
	
	public HostIPReporter(int sendToPort) {
		try {
			sender=new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sent2port=sendToPort;
		
	}
	public void broadcast(byte[] data){
		sendpacket=new DatagramPacket(data, data.length,broadcastAddr,sent2port);
		
		try {
			sender.send(sendpacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		new HostIPReporter(3927).broadcast(new Host("ts", "addfasdf", "10.3.4.50").tobytes());
	}

}
