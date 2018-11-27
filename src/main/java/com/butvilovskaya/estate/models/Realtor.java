package com.butvilovskaya.estate.models;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Set;

@Entity
@Table(name = "REALTOR")
public class Realtor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String agency;

    private String contact;

    @Transient
    private MultipartFile userImage;

    public Realtor() {
    }

    public Realtor(String name, String agency, String contact) {
        this.name = name;
        this.agency = agency;
        this.contact = contact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public MultipartFile getUserImage() {
        return userImage;
    }
    public void setUserImage(MultipartFile userImage) {
        this.userImage = userImage;
    }
}

