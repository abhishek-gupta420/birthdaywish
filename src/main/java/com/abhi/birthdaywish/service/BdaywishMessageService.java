package com.abhi.birthdaywish.service;

import com.abhi.birthdaywish.entities.BdaywishMessage;

public interface BdaywishMessageService {
    public BdaywishMessage updateMessage(Long id, String newMessage);
}
