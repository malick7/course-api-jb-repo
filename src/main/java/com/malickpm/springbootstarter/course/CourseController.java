package com.malickpm.springbootstarter.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.malickpm.springbootstarter.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	//Get all courses of a particular Topic
	//topics/java/courses -> collection, threading etc
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId){
		//return courseService.getAllCourses(id);
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourseById(@PathVariable String courseId){
		return courseService.getCourseById(courseId);		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addTopic(@RequestBody Course course, @PathVariable String topicId){
		course.setTopic(new Topic(topicId, "", "")); //this doesn't update the actual topic to empty values!
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}")
	public void updateTopic(@PathVariable String topicId, @RequestBody Course course){ // @PathVariable String courseId, 
		
		//making a course from one topic point to another
		course.setTopic(new Topic(topicId, "", "")); //this doesn't update the actual topic to empty values!
		
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}")
	public void deleteCourseById(@PathVariable String courseId){
		courseService.deleteCourseById(courseId);		
	}
}
