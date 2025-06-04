package com.abhi.birthdaywish.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "email_send_logs")
@Builder
public class EmailSendLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sent_to", nullable = false)
    private String sentTo;

    @Column(name = "sent_dttm")
    private Date sentDttm;

    @Column(name = "email_message", columnDefinition = "TEXT")
    private String emailMessage;

    @Column(name = "from_email")
    private String fromEmail;

    @Column(name = "is_successful")
    private Boolean isSuccessful = true;

    @Column(name = "error_message", columnDefinition = "TEXT")
    private String errorMessage;

    @Column(name = "inserted_date", updatable = false)
    private LocalDateTime insertedDate;

    @PrePersist
    public void prePersist() {
        this.insertedDate = LocalDateTime.now();
    }

    public EmailSendLog() {
    }

    public EmailSendLog(Long id, String sentTo, Date sentDttm, String emailMessage, String fromEmail, Boolean isSuccessful, String errorMessage, LocalDateTime insertedDate) {
        this.id = id;
        this.sentTo = sentTo;
        this.sentDttm = sentDttm;
        this.emailMessage = emailMessage;
        this.fromEmail = fromEmail;
        this.isSuccessful = isSuccessful;
        this.errorMessage = errorMessage;
        this.insertedDate = insertedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    public Date getSentDttm() {
        return sentDttm;
    }

    public void setSentDttm(Date sentDttm) {
        this.sentDttm = sentDttm;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public Boolean getSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(Boolean successful) {
        isSuccessful = successful;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getInsertedDate() {
        return insertedDate;
    }

    public void setInsertedDate(LocalDateTime insertedDate) {
        this.insertedDate = insertedDate;
    }
}
