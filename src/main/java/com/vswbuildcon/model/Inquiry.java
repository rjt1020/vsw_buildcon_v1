package com.vswbuildcon.model;

import java.time.LocalDateTime;

// [MODIFIED] All JPA annotations removed. This is now a standard POJO for form data.
public class Inquiry {

    // [MODIFIED] database identity generation removed
    private Long id;

    private String name;
    private String email;
    private String message;
    private LocalDateTime submittedAt;

    // Default constructor
    public Inquiry() {
        this.submittedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }
}