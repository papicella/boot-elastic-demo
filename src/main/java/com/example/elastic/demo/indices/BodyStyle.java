package com.example.elastic.demo.indices;

import org.springframework.data.elasticsearch.annotations.Field;

import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

public class BodyStyle {
    @Field(type = Text)
    private String type;

    public BodyStyle(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BodyStyle{" +
                "type='" + type + '\'' +
                '}';
    }
}
