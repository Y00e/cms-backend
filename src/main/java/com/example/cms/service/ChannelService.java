package com.example.cms.service;

import com.example.cms.model.Channel;
import com.example.cms.model.Message;
import com.example.cms.repository.ChannelRepository;
import com.example.cms.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private MessageRepository messageRepository;

    public List<Channel> getAll() {
        return channelRepository.findAll();
    }

    public void create(Channel channel) {
        channelRepository.save(channel);
    }

    public void delete(Long id) {
        channelRepository.deleteById(id);
    }

    public Channel updateTitle(Long id, String newTitle) {
        Channel channel = channelRepository.findById(id).orElseThrow();

        channel.setTitle(newTitle);
        return channelRepository.save(channel);
    }

    public Message createMessage(Long id, Message message) {
        Channel channel = channelRepository.findById(id).orElseThrow();
        message.setChannel(channel);

        return messageRepository.save(message);

    }

    public List<Message> getMessages(Long id) {
        return channelRepository.findById(id).orElseThrow().getMessages();
    }

    public Channel getChannelByTitle(String title) {
        return channelRepository.findChannelByTitle(title);
    }


    public Message updateMessage(Long id, String newText) {
        Message message = messageRepository.findById(id).orElseThrow();

        message.setText(newText);
        return messageRepository.save(message);

    }


    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }


}
