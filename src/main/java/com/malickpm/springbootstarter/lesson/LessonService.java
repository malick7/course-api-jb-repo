package com.malickpm.springbootstarter.lesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;

	public List<Lesson> getAllLessons(String topicId, String courseId){
		List<Lesson> lessons = new ArrayList<Lesson>();
		
		//courseRepository.findAll() //returns Iterable
		//	.forEach(courses::add);
		
		lessonRepository.findByCourseId(courseId)
			.forEach(lessons::add);
		
		return lessons;
	}
	
	public Lesson getLessonById(String id){		
		return lessonRepository.findOne(id);
	}
	
	public void addLesson(Lesson lesson){
		lessonRepository.save(lesson);
	}

	public void updateLesson(Lesson course) {
		lessonRepository.save(course); // same as add! does update or add based on ID at runtime!!!
	}

	public void deleteLessonById(String id) {
		lessonRepository.delete(id);
	}
}
