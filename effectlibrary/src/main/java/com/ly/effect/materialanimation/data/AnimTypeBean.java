package com.ly.effect.materialanimation.data;

/**
 * created by li,24/06/2018
 */
public class AnimTypeBean {

    private AnimType animType;
    private String name;
    private int textColor;

    public AnimTypeBean(AnimType animType, String name, int textColor) {
        this.animType = animType;
        this.name = name;
        this.textColor = textColor;
    }

    public AnimType getAnimType() {
        return animType;
    }

    public void setAnimType(AnimType animType) {
        this.animType = animType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
}
