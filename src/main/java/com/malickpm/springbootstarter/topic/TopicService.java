package com.malickpm.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<Topic>();
		
		topicRepository.findAll() //returns Iterable
			.forEach(topics::add);
		
		return topics;
	}
	
	public Topic getTopicById(String id){
		
		return topicRepository.findOne(id);
	}
	public void addTopic(Topic topic){
		
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic); // same as add! does update or add based on ID at runtime!!!
	}

	public void deleteTopicById(String id) {
		topicRepository.delete(id);
	}
}
