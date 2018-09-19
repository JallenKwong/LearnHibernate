package com.lun.light.sql.nativesql;


public class StudentCourse
{
	private String stuName;
	private String courseName;

	// stuName的setter和getter方法
	public void setStuName(String stuName)
	{
		this.stuName = stuName;
	}
	public String getStuName()
	{
		return this.stuName;
	}

	// courseName的setter和getter方法
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	public String getCourseName()
	{
		return this.courseName;
	}
}