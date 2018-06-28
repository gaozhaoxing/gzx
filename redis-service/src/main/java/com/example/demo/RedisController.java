package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ys.protocol.redis.api.RedisServiceCloud;

@RestController
public class RedisController implements RedisServiceCloud {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	@Autowired
	private DiscoveryClient client;

	/**
	 * 根据指定key获取Stsring
	 */
	@Override
	@RequestMapping("/getStr")
	public String getStr(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}

	/**
	 * 设置Str缓存
	 */
	@Override
	@RequestMapping("/setStr")
	public void setStr(String key, String val) {
		stringRedisTemplate.opsForValue().set(key, val);
	}

	/**
	 * 删除指定key
	 */
	@Override
	@RequestMapping("/del")
	public void del(String key) {
		stringRedisTemplate.delete(key);
	}

	/**
	 * 设置obj缓存
	 */
	@Override
	@RequestMapping("/setObj")
	public void setObj(String o1, Object o2) {
		redisTemplate.opsForValue().set(o1, o2);
	}

	/**
	 * 删除Obj缓存
	 */
	@Override
	@RequestMapping("/delObj")
	public void delObj(Object o) {
		redisTemplate.delete(o);
	}

	/**
	 * 如果key已经存在并且是一个字符串，则该命令将该值追加到字符串的末尾
	 */
	@Override
	@RequestMapping("/appendStr")
	public void appendStr(String key, String val) {
		stringRedisTemplate.opsForValue().append(key, val);
	}

	@Override
	@RequestMapping("/increment")
	public String increment() {
		String sss = "host:" + client.getLocalServiceInstance().getHost() + "   -----port:" + client.getLocalServiceInstance().getPort() + "   -----serviceId:" + client.getLocalServiceInstance().getServiceId() + "   -----uri:" + client.getLocalServiceInstance().getUri();
		return sss + "------------>>>" + String.valueOf(redisTemplate.opsForValue().increment("increlong", 1));
	}

	/**
	 * 获取Object
	 */
	@Override
	@RequestMapping("/getObj")
	public Object getObj(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	@RequestMapping("/expire")
	public Boolean expire(String key, String seconds) {
		return stringRedisTemplate.expire(key, Integer.parseInt(seconds), TimeUnit.SECONDS);
	}

	@Override
	@RequestMapping("/expireObj")
	public Boolean expireObj(Object key, String seconds) {
		return redisTemplate.expire(key, Integer.parseInt(seconds), TimeUnit.SECONDS);
	}
}
