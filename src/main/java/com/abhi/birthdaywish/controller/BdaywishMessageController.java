package com.abhi.birthdaywish.controller;

import com.abhi.birthdaywish.entities.BdaywishMessage;
import com.abhi.birthdaywish.service.BdaywishMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/birthday-wish")
public class BdaywishMessageController {

    @Autowired
    private BdaywishMessageService service;

    // DTO for update request
    public static class UpdateWishRequest {
        public String birthdayWishMessage;

        public String getBirthdayWishMessage() {
            return birthdayWishMessage;
        }

        public void setBirthdayWishMessage(String birthdayWishMessage) {
            this.birthdayWishMessage = birthdayWishMessage;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BdaywishMessage> updateWishMessage(
            @PathVariable Long id,
            @RequestBody UpdateWishRequest request) {
        BdaywishMessage updated = service.updateMessage(id, request.getBirthdayWishMessage());
        return ResponseEntity.ok(updated);
    }
}


