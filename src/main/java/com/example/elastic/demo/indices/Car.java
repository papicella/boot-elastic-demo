package com.example.elastic.demo.indices;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.MultiField;

import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.*;

@Document(indexName = "vehicle")
public class Car {
    @Id
    private String id;

    @MultiField(mainField = @Field(type = Keyword))
    private String make;
    private String model;

    @Field(type = Nested, includeInParent = true)
    private List<BodyStyle> bodystyles;

    public Car() {
    }

    public Car(String make, String model, List<BodyStyle> bodystyles) {
        this.make = make;
        this.model = model;
        this.bodystyles = bodystyles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<BodyStyle> getBodystyles() {
        return bodystyles;
    }

    public void setBodystyles(List<BodyStyle> bodystyles) {
        this.bodystyles = bodystyles;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", bodystyles=" + bodystyles +
                '}';
    }
}
