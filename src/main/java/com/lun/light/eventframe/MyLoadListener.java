package com.lun.light.eventframe;

import org.hibernate.event.internal.DefaultLoadEventListener;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;


public class MyLoadListener extends DefaultLoadEventListener
{
	// 在LoadEventListener接口仅仅定义了这个方法
	public void onLoad(LoadEvent event,
		LoadEventListener.LoadType loadType)
		throws HibernateException
	{
		System.out.println("自定义的load事件");
		System.out.println(event.getEntityClassName()
			+ "==========" + event.getEntityId());
		super.onLoad(event, loadType);
	}
}