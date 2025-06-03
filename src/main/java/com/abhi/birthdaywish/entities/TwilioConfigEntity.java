package com.abhi.birthdaywish.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "twilio_config")
public class TwilioConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_sid")
    private String accountSid;

    @Column(name = "auth_token")
    private String authToken;

    @Column(name = "whatsapp_from_number")
    private String fromNumber;

    // Getters & Setters

    public TwilioConfigEntity() {
    }

    public TwilioConfigEntity(Integer id, String accountSid, String authToken, String fromNumber) {
        this.id = id;
        this.accountSid = accountSid;
        this.authToken = authToken;
        this.fromNumber = fromNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getFromNumber() {
        return fromNumber;
    }

    public void setFromNumber(String fromNumber) {
        this.fromNumber = fromNumber;
    }
}
