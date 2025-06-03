package com.abhi.birthdaywish.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bdaywish_message")
public class BdaywishMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "birthday_wish_message", nullable = false, length = 500)
    private String birthdayWishMessage = "Wishing you a day filled with love, joy, and unforgettable memories. Happy Birthday!";

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBirthdayWishMessage() {
        return birthdayWishMessage;
    }

    public void setBirthdayWishMessage(String birthdayWishMessage) {
        this.birthdayWishMessage = birthdayWishMessage;
    }
}