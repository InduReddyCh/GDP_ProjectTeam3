package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage,Integer>{

}