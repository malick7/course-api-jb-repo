package com.malickpm.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId){
		List<Course> courses = new ArrayList<Course>();
		
		//courseRepository.findAll() //returns Iterable
		//	.forEach(courses::add);
		
		courseRepository.findByTopicId(topicId)
			.forEach(courses::add);
		
		return courses;
	}
	
	public Course getCourseById(String id){
		
		return courseRepository.findOne(id);
	}
	public void addCourse(Course course){
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course); // same as add! does update or add based on ID at runtime!!!
	}

	public void deleteCourseById(String id) {
		courseRepository.delete(id);
	}
}
