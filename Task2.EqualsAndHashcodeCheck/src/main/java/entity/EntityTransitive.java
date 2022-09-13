package entity;

import java.util.Objects;

public class EntityTransitive {
    private int id;
    private String name;
    private int age;
    private static int counter = 1;

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

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        EntityTransitive.counter = counter;
    }

    public EntityTransitive(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return true;
        }
        counter++;
        if (counter % 3 == 0) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge());
    }
}
