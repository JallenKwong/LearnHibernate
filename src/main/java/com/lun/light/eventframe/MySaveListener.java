package com.lun.light.eventframe;

import java.io.Serializable;

import org.hibernate.event.internal.DefaultSaveEventListener;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.LoadEventListener;


// Hibernate的默认事件监听器类都被声明成non-final的了。
public class MySaveListener extends DefaultSaveEventListener
{
	public Serializable performSaveOrUpdate(SaveOrUpdateEvent event)
	{
		System.out.println("自定义的save事件");
		System.out.println(event.getObject());
		return super.performSaveOrUpdate(event);
	}
}