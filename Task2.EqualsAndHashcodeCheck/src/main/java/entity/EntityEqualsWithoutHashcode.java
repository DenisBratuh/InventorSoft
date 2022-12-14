package entity;

import java.util.Objects;

public class EntityEqualsWithoutHashcode {
    private int id;
    private String name;
    private int age;

    public EntityEqualsWithoutHashcode(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "EntityWithoutEqualsAndHash{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityEqualsWithoutHashcode that = (EntityEqualsWithoutHashcode) o;
        return getId() == that.getId() && getAge() == that.getAge() && getName().equals(that.getName());
    }

  /*  @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge());
    }*/
}

