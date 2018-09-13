package com.lun.light.mapfile.generated;

import javax.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 * @version 1.0
 */
@Entity
@Table(name = "news_inf")
public class News {
	// 消息类的标识属性
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// 消息标题
	private String title;
	// 消息内容
	private String content;
	// 指定@Generated的value为ALWAYS，表明该属性的值由数据库生成，
	// Hibernate会在每次执行insert、update时执行select语句来查询获取该属性的值
	@Generated(GenerationTime.ALWAYS)
	@Column(name="full_content")
	private String fullContent;

	// id的setter和getter方法
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	// title的setter和getter方法
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	// content的setter和getter方法
	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	// fullContent的setter和getter方法
	public void setFullContent(String fullContent) {
		this.fullContent = fullContent;
	}

	public String getFullContent() {
		return this.fullContent;
	}
}