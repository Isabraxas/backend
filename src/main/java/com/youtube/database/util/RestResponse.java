package com.youtube.database.util;

public class RestResponse {

    private Integer reponseCode;

    private String menssage;

    public RestResponse(Integer reponseCode) {
        super();
        this.reponseCode = reponseCode;
    }

    public RestResponse(Integer reponseCode, String menssage) {
        super();
        this.reponseCode = reponseCode;
        this.menssage = menssage;
    }

    public Integer getReponseCode() {
        return reponseCode;
    }

    public void setReponseCode(Integer reponseCode) {
        this.reponseCode = reponseCode;
    }

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }




}
