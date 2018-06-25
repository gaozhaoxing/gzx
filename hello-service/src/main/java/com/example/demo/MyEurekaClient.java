package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.appinfo.MyDataCenterInstanceConfig;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;

public class MyEurekaClient {
	private EurekaClient client;
	@Autowired
	private RestTemplate restTemplate;

	protected MyEurekaClient() {
		if (restTemplate == null) {
			restTemplate = new RestTemplate();
		}
		init();
	}

	protected void init() {
		DiscoveryManager.getInstance().initComponent(new MyDataCenterInstanceConfig(), new DefaultEurekaClientConfig());
		ApplicationInfoManager.getInstance().setInstanceStatus(InstanceStatus.UP);
		client = DiscoveryManager.getInstance().getEurekaClient();
	}

	/**
	 * 根据Service名称和请求的，获取返回内容！
	 * 
	 * @param serviceName
	 * @param url
	 * @return
	 */
	public <T> T request(String serviceName, String url, Class<T> returnClaz) {
		Applications apps = client.getApplications();
		Application app = apps.getRegisteredApplications(serviceName);
		if (app != null) {
			List<InstanceInfo> instances = app.getInstances();
			if (instances.size() > 0) {
				try {
					InstanceInfo instance = instances.get(0);
					String reqUrl = "http://" + instance.getIPAddr() + ":" + instance.getPort() + "/" + url;
					return restTemplate.getForEntity(reqUrl, returnClaz).getBody();
				} catch (Exception e) {
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
