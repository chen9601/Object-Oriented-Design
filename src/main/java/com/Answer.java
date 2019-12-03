package com;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
public class Answer{
    @NonNull
    private String message;
    @NonNull
    private String tag;
    @Builder.Default
    private ItemType item=null;

    Answer(String message, String tag)
    {
        this.message=message;
        this.tag=tag;
    }

    Answer(ItemType item, String message, String tag)
    {
        this.message=message;
        this.item=item;
        this.tag=tag;
    }
}