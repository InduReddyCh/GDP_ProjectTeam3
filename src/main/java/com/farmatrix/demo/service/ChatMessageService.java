package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChatMessage;
import com.example.demo.repository.ChatMessageRepository;

@Service
public class ChatMessageService {

	@Autowired
	private ChatMessageRepository repo;
	
	public ChatMessage save(ChatMessage chatMessage)
	{
		return repo.save(chatMessage);
	}
	
	public List<ChatMessage> findAllInbox(String username)
	{
		List<ChatMessage> chatMessages=new ArrayList<ChatMessage>();
		
		for(ChatMessage chatMessage : repo.findAll())
		{
			if(chatMessage.getReceiver().equals(username))
			{
				chatMessages.add(chatMessage);
			}
		}
		
		return chatMessages;
	}
	
	public ChatMessage findById(int id)
	{
		return repo.findById(id).get();
	}
	
	public void delete(int id)
	{
		repo.deleteById(id);
	}	
	
	public boolean isExist(int id)
	{
		return repo.existsById(id);
	}
}
