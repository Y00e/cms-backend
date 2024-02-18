package com.example.cms.controller;

import com.example.cms.model.Channel;
import com.example.cms.model.Message;
import com.example.cms.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Channel>> getAllChannels(){
       List<Channel> channels = channelService.getAll();

        return ResponseEntity.status(200).body(channels);
    }

    // GET http://localhost:8080/api/v1/channels/search/{title}
    @GetMapping("search/{title}")
    public ResponseEntity<Channel> getChannelByTitle (@PathVariable String title) {
         Channel channel = channelService.getChannelByTitle(title);

         if (channel != null) {
             return ResponseEntity.status(200).body(channel);
         }
        return ResponseEntity.status(404).build();
    }

    // POST http://localhost:8080/api/v1/channels
    @PostMapping
    public ResponseEntity<String> createNewChannel(@RequestBody Channel channel) {
        channelService.create(channel);

        return ResponseEntity.status(201).body("Success");
    }

    // DELETE http://localhost:8080/api/v1/channels/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChannel(@PathVariable Long id) {
        channelService.delete(id);

        return ResponseEntity.status(204).build();
    }

    // PATCH http://localhost:8080/api/v1/channels/{id}
    @PatchMapping("/{id}")
    public ResponseEntity<Channel> updateChannelTitle(@PathVariable Long id, @RequestBody Channel newTitle) {
         Channel updatedChannel = channelService.updateTitle(id, newTitle.getTitle());

         if (updatedChannel !=null) {
             return ResponseEntity.status(200).body(updatedChannel);
         } else {
             return ResponseEntity.status(404).build();
         }
    }


    // PUT http://localhost:8080/api/v1/channels/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Message> createMessage(@PathVariable Long id, @RequestBody Message message) {
        Message createdMessage = channelService.createMessage(id, message);

        if (createdMessage != null) {
            return ResponseEntity.status(201).body(createdMessage);
        } else {
            return ResponseEntity.status(400).build();
        }
    }


    // GET http://localhost:8080/api/v1/channels/{id}
    @GetMapping("/{id}")
    public ResponseEntity <List<Message>> getChannelAllMessages(@PathVariable Long id) {
        List<Message> messages = channelService.getMessages(id);

        if (messages != null && !messages.isEmpty()) {
            return ResponseEntity.status(200).body(messages);
        } else {
            return ResponseEntity.status(204).build();
        }

    }

    // PUT http://localhost:8080/api/v1/channels/message/{id}
    @PutMapping("message/{id}")
    public ResponseEntity<Message>  updateMessage(@PathVariable Long id, @RequestBody Message newText) {
       Message updatedMessage = channelService.updateMessage(id, newText.getText());

       if (updatedMessage !=null) {
           return ResponseEntity.status(200).body(updatedMessage);
       } else {
           return ResponseEntity.status(400).build();
       }

    }


    // DELETE http://localhost:8080/api/v1/channels/message/{id}
    @DeleteMapping("message/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        channelService.delete(id);

        return ResponseEntity.status(204).build();
    }
    
}
