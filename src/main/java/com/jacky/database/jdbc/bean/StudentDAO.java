package com.jacky.database.jdbc.bean;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDAO {
	
	/*
	 * 设置数据源
	 */
	public void setDataSource(DataSource ds);
	
	/*
	 * 插入数据
	 */
	public void create(String name, Integer age);
	
	/*
	 * 查询单行数据
	 */
	public Student getStudent(Integer id);
	
	/*
	 * 查询表Student所有行记录
	 */
	public List<Student> listStudents();
	
	/*
	 * 根据Id删除一行记录
	 */
	public void delete(Integer id) ;
	
	/*
	 * 根据Id更新一行数据
	 */
	public void update(Integer id, Integer age);
	
	
	
	

}
