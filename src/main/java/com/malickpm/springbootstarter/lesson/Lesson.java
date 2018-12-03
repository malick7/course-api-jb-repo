package com.malickpm.springbootstarter.lesson;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.malickpm.springbootstarter.course.Course;

@Entity
public class Lesson {
	
	@Id
	private String id; //primary key
	private String name;
	private String description;
	
	//A Lesson will belong to a Course, a Course can have many lessons.
	@ManyToOne
	private Course course;	
	
	public Lesson() {
	
	}
	
	public Lesson(String id, String name, String description, String topicId, String courseId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.course = new Course(courseId, "", "", topicId);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
