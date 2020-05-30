package com.example.demo.controllers;

import com.example.demo.domain.Topic;
import com.example.demo.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private TopicService topicService;

    @RequestMapping("/hello")
    public String hi() {
        return "Hello";
    }

    @RequestMapping("/topics")
    public List<Topic> getTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable("id") String topicId) {
        System.out.println(topicId);
        return topicService.getTopic(topicId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {

        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void putTopic(@RequestBody Topic topic, @PathVariable String id) {
        System.out.println(topic.getId());
        topicService.putTopic(topic, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        System.out.println(id);
        topicService.deleteTopic(id);
    }
}
