import entity.Entity;
import entity.EntityEqualsWithoutHashcode;
import entity.EntityHashcodeWithoutEquals;
import entity.EntityWithoutEqualsAndHash;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class HashSetTests {

    /**
     * In this test we have entity. Equals and hashcode was overridden.
     * We are trying to put 3 identical objects into set
     * We would like to get as result only one object in set.
     * If test is passed, it means we got expected result.
     */
    @Test
   public void HashSetWithHasAndEquals() {
        Entity e1 = new Entity(12,"Oleg",22);
        Entity e2 = new Entity(12,"Oleg",22);
        Entity e3 = new Entity(12,"Oleg",22);
        Set<Entity> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        Assert.assertEquals(1, set.size());
        System.out.println(set);
    }

    /**
     * The same test as previous, but without overriding equals and hashcode.
     * In this case
     * We have 3 identical objects, but because equals and hashcode are not overridden
     * set consider them as non equals objects
     */
    @Test
    public void HashSetWithoutHasAndEquals() {
        EntityWithoutEqualsAndHash e1 = new EntityWithoutEqualsAndHash(12,"Oleg",22);
        EntityWithoutEqualsAndHash e2 = new EntityWithoutEqualsAndHash(12,"Oleg",22);
        EntityWithoutEqualsAndHash e3 = new EntityWithoutEqualsAndHash(12,"Oleg",22);
        Set<EntityWithoutEqualsAndHash> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        Assert.assertEquals(1, set.size());
        System.out.println(set);
    }

    /**
     * This is the same test as previous,  but equals method is overridden.
     * So in this case we would like to see that we only have 1 object in our set.
     * When we are comparing objects by equals we have positive result, but despite that
     * These objects have different hashcode that's why we still have duplicates in our set
     */
    @Test
    public void HashSetWithEquals() {
        EntityEqualsWithoutHashcode e1 = new EntityEqualsWithoutHashcode(12,"Oleg",22);
        EntityEqualsWithoutHashcode e2 = new EntityEqualsWithoutHashcode(12,"Oleg",22);
        EntityEqualsWithoutHashcode e3 = new EntityEqualsWithoutHashcode(12,"Oleg",22);
        Set<EntityEqualsWithoutHashcode> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        System.out.println("e1 - " + e1.hashCode());
        System.out.println("e2 - " + e2.hashCode());
        System.out.println("e1 equals e2 - " + e1.equals(e2));
        System.out.println("//////");
        System.out.println("e2 - " + e2.hashCode());
        System.out.println("e3 - " + e3.hashCode());
        System.out.println("e2 equals e3 - " + e2.equals(e3));
        System.out.println("//////");
        System.out.println("e1 - " + e1.hashCode());
        System.out.println("e3 - " + e3.hashCode());
        System.out.println("e1 equals e3 - " + e1.equals(e3));
        Assert.assertEquals(1, set.size());
        System.out.println(set);
    }

    /**
     * The same test as precious but this time Hashcode method was overridden instead of Equals.
     * And we got the same result : 3 identical object in set
     */
    @Test
    public void HashSetWithHashcode() {
        EntityHashcodeWithoutEquals e1 = new EntityHashcodeWithoutEquals(12,"Oleg",22);
        EntityHashcodeWithoutEquals e2 = new EntityHashcodeWithoutEquals(12,"Oleg",22);
        EntityHashcodeWithoutEquals e3 = new EntityHashcodeWithoutEquals(12,"Oleg",22);
        Set<EntityHashcodeWithoutEquals> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        System.out.println("e1 - " + e1.hashCode());
        System.out.println("e2 - " + e2.hashCode());
        System.out.println("e1 equals e2 - " + e1.equals(e2));
        System.out.println("//////");
        System.out.println("e2 - " + e2.hashCode());
        System.out.println("e3 - " + e3.hashCode());
        System.out.println("e2 equals e3 - " + e2.equals(e3));
        System.out.println("//////");
        System.out.println("e1 - " + e1.hashCode());
        System.out.println("e3 - " + e3.hashCode());
        System.out.println("e1 equals e3 - " + e1.equals(e3));
        Assert.assertEquals(1, set.size());
        System.out.println(set);
    }
}
