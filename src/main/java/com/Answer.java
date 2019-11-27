package com;

public class Answer{
    private String message;
    private String tag;
    private ItemType item=null;

    Answer(String message, String tag)
    {
        this.message=message;
        this.tag=tag;
    }

    Answer(ItemType item)
    {
        this.item=item;
    }

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }
    public ItemType getItem(){return item;}
}