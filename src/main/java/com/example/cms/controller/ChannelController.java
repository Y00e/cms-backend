package com.example.cms.controller;

import com.example.cms.model.Channel;
import com.example.cms.model.Message;
import com.example.cms.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    // http://localhost:8080/api/v1/channels

@RestController
@RequestMapping("/api/v1/channels")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    // GET http://localhost:8080/api/v1/channels
    @GetMapping
    public List<Channel> getAllChannels(){
        return channelService.getAll();
    }

    // GET http://localhost:8080/api/v1/channels/search/{title}
    @GetMapping("search/{title}")
    public Channel getChannelByTitle (@PathVariable String title) {
        return channelService.getChannelByTitle(title);
    }

    // POST http://localhost:8080/api/v1/channels
    @PostMapping
    public String createNewChannel(@RequestBody Channel channel) {
        channelService.create(channel);

        return "Success";
    }

    // DELETE http://localhost:8080/api/v1/channels/{id}
    @DeleteMapping("/{id}")
    public void deleteChannel(@PathVariable Long id) {
        channelService.delete(id);
    }

    // PATCH http://localhost:8080/api/v1/channels/{id}
    @PatchMapping("/{id}")
    public Channel updateChannelTitle(@PathVariable Long id, @RequestBody Channel newTitle) {
        return channelService.updateTitle(id, newTitle.getTitle());

    }


    // PUT http://localhost:8080/api/v1/channels/{id}
    @PutMapping("/{id}")
    public Message createMessage(@PathVariable Long id, @RequestBody Message message) {
        return channelService.createMessage(id, message);
    }

    // GET http://localhost:8080/api/v1/channels/{id}
    @GetMapping("/{id}")
    public List<Message> getChannelAllMessages(@PathVariable Long id) {
        return channelService.getMessages(id);
    }

    // PUT http://localhost:8080/api/v1/channels/message/{id}
    @PutMapping("message/{id}")
    public Message updateMessage(@PathVariable Long id, @RequestBody Message newText) {
       return channelService.updateMessage(id, newText.getText());
    }

    // DELETE http://localhost:8080/api/v1/channels/message/{id}
    @DeleteMapping("message/{id}")
    public void deleteMessage(@PathVariable Long id) {
        channelService.delete(id);
    }


}
