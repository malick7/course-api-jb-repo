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

	private List<Topic> topics = new ArrayList<Topic>(
									//Arrays.asList returns a immutable list
									Arrays.asList(
									new Topic("spring", "Spring Fw", "Spring FW desc"),
									new Topic("java", "Core Java", "Core Java desc"),
									new Topic("javascript", "Javascript", "Javascript desc")
									)
								);	
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<Topic>();
		
		topicRepository.findAll() //returns Iterable
			.forEach(topics::add);
		
		return topics;
	}
	
	public Topic getTopicById(String id){
		//return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
		
		return topicRepository.findOne(id);
	}
	public void addTopic(Topic topic){
		//topics.add(topic);
		
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		/*for(int i=0; i< topics.size(); i++)	{
			Topic tempTopic = topics.get(i);
			if(tempTopic.getId().equals(id)){
				//topic.setDescription(topic.getDescription());
				//topic.setName(topic.getName());				
				topics.set(i, topic);
				return;
			}
		}*/
		
		//topics.stream().filter(t->t.getId().equals(id))
		//  .map(t->topics.set(topics.indexOf(t), topic))
		//  .collect(Collectors.toList());﻿
		
		topicRepository.save(topic); // same as add! does update or add based on ID at runtime!!!

	}

	public void deleteTopicById(String id) {
		topicRepository.delete(id);
	}
}
