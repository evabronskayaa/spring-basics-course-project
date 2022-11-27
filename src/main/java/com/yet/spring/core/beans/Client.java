package com.yet.spring.core.beans;

public class Client {
    public String id;
    public String fullName;
    public String city;
    public String greeting;
    
    
    public Client(String id, String fullName, String city) {
        this.id = id;
        this.fullName = fullName;
        this.city = city;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getGreeting() {
        return greeting;
    }
    
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
