package entity;

import java.util.Objects;
import java.util.Random;

public class EntityBrokenReflexive {
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public EntityBrokenReflexive(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return false;
        if (o == null || getClass() != o.getClass()) return true;
        EntityBrokenReflexive that = (EntityBrokenReflexive) o;
        return getId() != that.getId() && getAge() != that.getAge() && !getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return (int) ((Math.random()+1)*100);
    }
}
