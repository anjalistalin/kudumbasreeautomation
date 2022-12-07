package com.example.kudumbasree;

public class PDFADSModelClass {

    String name,url;

    public PDFADSModelClass() {
    }

    public PDFADSModelClass(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
