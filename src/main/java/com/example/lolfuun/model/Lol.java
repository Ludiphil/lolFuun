package com.example.lolfuun.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="lol")
public class Lol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    @Column(name = "idUser")
    private int idUser;

    @Column(name = "idPost")
    private int idPost;

    @CreationTimestamp
    @Column(name = "dateLol")
    private Timestamp dateLol;

    public int getIdPost() {
        return idPost;
    }

    public Timestamp getDateLol() {
        return dateLol;
    }

    public long getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public Lol() {

    }

    public Lol(int idUser,int idPost) {
        this.idUser = idUser;
        this.idPost= idPost;
    }
}
