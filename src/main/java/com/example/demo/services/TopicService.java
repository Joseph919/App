package com.example.demo.services;

import com.example.demo.domain.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topicList = new ArrayList<>(Arrays.asList(
            new Topic("mvn", "maven", "install"),
            new Topic("npm", "node", "package"),
            new Topic("py", "python", "json")
    ));

    public List<Topic> getAllTopics() {
        return this.topicList;
    }

    public Topic getTopic(String id) {
        return this.topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        this.topicList.add(topic);
    }

    public void putTopic(Topic topic, String id) {
        for(int i = 0; i < this.topicList.size(); i ++) {
            if(topicList.get(i).getId().equals(id)) {
                topicList.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        for(int i = 0; i < this.topicList.size(); i ++) {
            if(topicList.get(i).getId().equals(id)) {
                topicList.remove(topicList.get(i));
            }
        }
    }
}
