package org.tsxuehu.Hadoop.HostIPRegister;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class HostIPServer {

	private DatagramSocket server;
	private DatagramPacket receivePacket;

	byte[] buffer;
	private static int bufferSize = 1024;

	public HostIPServer(int port) {

		try {
			server = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}

		buffer = new byte[bufferSize];
		receivePacket = new DatagramPacket(buffer, buffer.length);
	}

	public void run() {
		while (true) {

			try {
				server.receive(receivePacket);

				byte[] receiveData = receivePacket.getData();

				System.out.println(Host.read(receiveData));

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		new HostIPServer(3927).run();
	}

}
