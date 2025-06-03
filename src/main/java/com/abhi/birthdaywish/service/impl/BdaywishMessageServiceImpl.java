package com.abhi.birthdaywish.service.impl;

import com.abhi.birthdaywish.entities.BdaywishMessage;
import com.abhi.birthdaywish.repository.BdaywishMessageRepository;
import com.abhi.birthdaywish.service.BdaywishMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BdaywishMessageServiceImpl implements BdaywishMessageService {
    @Autowired
    private BdaywishMessageRepository repository;

    public BdaywishMessage updateMessage(Long id, String newMessage) {
        Optional<BdaywishMessage> optionalMsg = repository.findById(id);
        if (optionalMsg.isPresent()) {
            BdaywishMessage msg = optionalMsg.get();
            msg.setBirthdayWishMessage(newMessage);
            return repository.save(msg);
        } else {
            throw new RuntimeException("Message with id " + id + " not found");
        }
    }
}
