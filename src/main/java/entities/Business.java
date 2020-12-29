package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Business {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    public Business() {
    }

    public Business(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
