package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "remote", ignoreUnknownFields = false)
@PropertySource(value ={"file:${user.dir}/config/remote.properties"}, ignoreResourceNotFound = true)  
public class ConfigProperties {
	private String port;
	private String bossThreadNum;
	private String workerThreadNum;
	private String businessThreadNum;
	private String clientThreadNum;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getBossThreadNum() {
		return bossThreadNum;
	}

	public void setBossThreadNum(String bossThreadNum) {
		this.bossThreadNum = bossThreadNum;
	}

	public String getWorkerThreadNum() {
		return workerThreadNum;
	}

	public void setWorkerThreadNum(String workerThreadNum) {
		this.workerThreadNum = workerThreadNum;
	}

	public String getBusinessThreadNum() {
		return businessThreadNum;
	}

	public void setBusinessThreadNum(String businessThreadNum) {
		this.businessThreadNum = businessThreadNum;
	}

	public String getClientThreadNum() {
		return clientThreadNum;
	}

	public void setClientThreadNum(String clientThreadNum) {
		this.clientThreadNum = clientThreadNum;
	}
}
