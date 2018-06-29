package com.dxf.dao;

import com.dxf.model.Student;

public interface StuDao {
	boolean insert(Student student);
	
	Student select(int stu_number);
	
	boolean update(Student st);
	
	boolean delect(int stu_number);
	
}
