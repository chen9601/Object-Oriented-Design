package com;

public class Answer{
    private String message;
    private String tag;

    Answer(String message, String tag)
    {
        this.message=message;
        this.tag=tag;
    }

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }
}