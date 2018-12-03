package com.malickpm.springbootstarter.lesson;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


//Spring Data JPA
public interface LessonRepository extends CrudRepository<Lesson, String>{
		
	//we dont have to provide implementation
	//public List<Course> getCoursesByName(String name);
	//find+By+Field => FindByProperty 	
	
	public List<Lesson> findByCourseId(String courseId);	
}
