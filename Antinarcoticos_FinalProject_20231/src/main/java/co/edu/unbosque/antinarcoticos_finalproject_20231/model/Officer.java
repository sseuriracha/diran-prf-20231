package co.edu.unbosque.antinarcoticos_finalproject_20231.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Officer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length=60, nullable = false)
    private String name;
    @Column
    private Integer age;
    @Column
    private Date incorporation;
    @Column
    private String rank;
    @Column
    private Integer raids;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getIncorporation() {
        return incorporation;
    }

    public void setIncorporation(Date incorporation) {
        this.incorporation = incorporation;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Integer getRaids() {
        return raids;
    }

    public void setRaids(Integer raids) {
        this.raids = raids;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", incorporation=" + incorporation +
                ", rank='" + rank + '\'' +
                ", raids=" + raids +
                '}';
    }
}
