package by.sam.apklimovich;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class PersonDto {


    @Size(min = 1)
    private String name;

    private int id;

    private String visitData;

    public String content;

    public PersonDto() {
    }

    PersonDto(String name, int id, String data) {
        this.name = name;
        this.id = id;
        this.visitData = data;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public String getVisitData() {
        return visitData;
    }

    public void setVisitData(String newVisitData) {
        this.visitData = newVisitData;
    }
}
