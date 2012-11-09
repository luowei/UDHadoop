package org.tsxuehu.Hadoop.HostIPRegister;

import org.apache.hadoop.conf.Configuration;

public class Configure {

	private static Configuration conf;
	static {
		conf=new Configuration(false);
		conf.addResource("HostIPRegister.xml");
	}

	public String get(String name) {
		return conf.get(name);
	}
	public void reload(){
		conf.reloadConfiguration();
	}
}
