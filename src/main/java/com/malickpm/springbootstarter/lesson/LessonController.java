package com.malickpm.springbootstarter.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.malickpm.springbootstarter.course.Course;

@RestController
public class LessonController {

	@Autowired
	private LessonService lessonService;
	
	//Get all lessons of a particular Course
	//topics/java/courses/streams/lessons -> map, lambda etc
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllCourses(@PathVariable String topicId, @PathVariable String courseId){
		return lessonService.getAllLessons(topicId, courseId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public Lesson getLessonById(@PathVariable String lessonId){
		return lessonService.getLessonById(lessonId);		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addTopic(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId){
		lesson.setCourse(new Course(courseId, "", "", topicId)); //this doesn't update the actual topic to empty values!
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void updateTopic(@PathVariable String topicId, @PathVariable String courseId, @RequestBody Lesson lesson){ // @PathVariable String courseId, 
		
		//making a course from one topic point to another
		lesson.setCourse(new Course(courseId, "", "", topicId)); //this doesn't update the actual topic to empty values!
		
		lessonService.updateLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void deleteCourseById(@PathVariable String lessonId){
		lessonService.deleteLessonById(lessonId);		
	}
}
