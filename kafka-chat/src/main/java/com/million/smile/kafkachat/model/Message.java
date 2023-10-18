package com.million.smile.kafkachat.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class Message {
    private String author;
    private String content;
    private String timestamp;

    @Override
    public String toString() {
        return "Message{" +
                "author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
