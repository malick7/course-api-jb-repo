package com.malickpm.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


//Spring Data JPA
public interface CourseRepository extends CrudRepository<Course, String>{
	
	//public List<Course> getCoursesByTopicId(String topicId);
	
	//we dont have to provide implementation
	//public List<Course> getCoursesByName(String name);
	//find+By+Field => FindByProperty 
	public List<Course> findByName(String name); //method names are specified in such a way that CrudRepository gives this method implementation
	
	public List<Course> findByDescription(String name);
	
	//we need to filter by topicId -> Object + Property!!!! Id of Topic
	public List<Course> findByTopicId(String name);
	
}
