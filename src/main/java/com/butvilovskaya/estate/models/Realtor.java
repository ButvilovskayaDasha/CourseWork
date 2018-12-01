package com.butvilovskaya.estate.models;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "REALTOR")
public class Realtor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String agency;

    private String contact;

    @Column(name = "namepic")
    @JsonView(View.FileInfo.class)
    private String namepic;

    @Column(name = "mimetype")
    private String mimetype;

    @Lob
    @Column(name="pic")
    private byte[] pic;

    public Realtor() {
    }

    public Realtor(String name, String agency, String contact, String namepic, String mimetype, byte[] pic) {
        this.name = name;
        this.agency = agency;
        this.contact = contact;
        this.namepic = namepic;
        this.mimetype = mimetype;
        this.pic = pic;
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

    public String getNamepic() {
        return namepic;
    }

    public void setNamepic(String namepic) {
        this.namepic = namepic;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
}

