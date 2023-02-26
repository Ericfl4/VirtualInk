package com.example.virtualink.d1;


public class Tatuador {
    String name;
    String style;
    int image;

    public Tatuador(String name, String style, int image) {
        this.name = name;
        this.style = style;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
