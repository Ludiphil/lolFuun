package com.example.lolfuun.payload;

public class LolPost {
    private int idUser;
    private int idPost;

    public void LolPost(int idUser, int idPost)
    {
        this.idPost = idPost;
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }
}
