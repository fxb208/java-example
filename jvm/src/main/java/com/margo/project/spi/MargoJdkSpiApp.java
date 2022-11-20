package com.margo.project.spi;

import java.util.ServiceLoader;

/**
 * 	https://www.jianshu.com/p/99f568df0f05
 * 	https://www.jianshu.com/p/e7446cdc7161
 * spi   Service Provider Interface
 * @author fangxingbang
 *
 */
public class MargoJdkSpiApp {
	public static void main(String[] args) {
		ServiceLoader<MargoGirlService> serviceLoader= ServiceLoader.load(MargoGirlService.class);
		for(MargoGirlService margoGirlService:serviceLoader) {
			margoGirlService.feature();
		}
	}
}
