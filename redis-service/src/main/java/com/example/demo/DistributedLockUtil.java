package com.example.demo;

public class DistributedLockUtil {
	private DistributedLockUtil() {
	}

	public static boolean lock(String lockName) {// lockName可以为共享变量名，也可以为方法名，主要是用于模拟锁信息
		Long result = RedisPoolUtil.setnx(lockName, String.valueOf(System.currentTimeMillis() + 5000));
		return true;
	}
}
