/**
 * @author tsxuehu (Email: tsxuehu@qq.com)
 *
 *
 *
 */
package org.tsxuehu.Hadoop.HostIPRegister;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author roy
 * 
 */
public class Host implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	private String mac;
	private String ip;

	public Host(String name, String mac, String ip) {
		this.name = name;
		this.mac = mac;
		this.ip = ip;
	}

	public byte[] tobytes() throws IOException {
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(this);
		byte[] temp=bos.toByteArray();
		oos.close();
		bos.close();
		return temp;
	}
	public static Host read(byte[] hostserialize) throws IOException, ClassNotFoundException{
		ByteArrayInputStream bis=new ByteArrayInputStream(hostserialize);
		ObjectInputStream ois=new ObjectInputStream(bis);
		Host temp=(Host) ois.readObject();
		ois.close();
		bis.close();		
		return temp;
	}
	@Override
	public String toString(){
		return String.format("Name: %s\tMac: %s\tIP: %s\n", name,mac,ip);
	}
}
