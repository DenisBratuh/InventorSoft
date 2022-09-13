import entity.*;
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
        Entity e1 = new Entity(12, "Oleg", 22);
        Entity e2 = new Entity(12, "Oleg", 22);
        Entity e3 = new Entity(12, "Oleg", 22);
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
        EntityWithoutEqualsAndHash e1 = new EntityWithoutEqualsAndHash(12, "Oleg", 22);
        EntityWithoutEqualsAndHash e2 = new EntityWithoutEqualsAndHash(12, "Oleg", 22);
        EntityWithoutEqualsAndHash e3 = new EntityWithoutEqualsAndHash(12, "Oleg", 22);
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
        EntityEqualsWithoutHashcode e1 = new EntityEqualsWithoutHashcode(12, "Oleg", 22);
        EntityEqualsWithoutHashcode e2 = new EntityEqualsWithoutHashcode(12, "Oleg", 22);
        EntityEqualsWithoutHashcode e3 = new EntityEqualsWithoutHashcode(12, "Oleg", 22);
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
        EntityHashcodeWithoutEquals e1 = new EntityHashcodeWithoutEquals(12, "Oleg", 22);
        EntityHashcodeWithoutEquals e2 = new EntityHashcodeWithoutEquals(12, "Oleg", 22);
        EntityHashcodeWithoutEquals e3 = new EntityHashcodeWithoutEquals(12, "Oleg", 22);
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

    /**
     * In this test we broke reflexive  for equals method
     * As we can see
     * 3 identical object was added to set despite they are identical
     */
    @Test
    public void HashSetBrokenReflexive() {
        EntityBrokenReflexive e1 = new EntityBrokenReflexive(12, "Oleg", 22);
        EntityBrokenReflexive e2 = new EntityBrokenReflexive(12, "Oleg", 22);
        EntityBrokenReflexive e3 = new EntityBrokenReflexive(12, "Oleg", 22);
        Set<EntityBrokenReflexive> set = new HashSet<>();
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
     * In this test we can see that e1.equals(e2) - true but e2.equals(e1) - false;
     */
    @Test
    public void HashSetBrokenSymmetric() {
        EntityBrokenSymmetric e1 = new EntityBrokenSymmetric(12, "Oleg", 22);
        EntityBrokenSymmetric2 e2 = new EntityBrokenSymmetric2(12, "Oleg", 22);
        EntityBrokenSymmetric e3 = new EntityBrokenSymmetric2(12, "Oleg", 22);
        Set<EntityBrokenSymmetric> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        System.out.println("e1 equals e2 - " + e1.equals(e2));
        System.out.println("e2 equals e1 - " + e2.equals(e1));
        System.out.println("//////");
        System.out.println("e1 equals e3 - " + e1.equals(e3));
        System.out.println("e3 equals e1 - " + e3.equals(e1));
        Assert.assertEquals(1, set.size());
        System.out.println(set);
    }

    /**
     * In this case Transitive and Consistent are broken
     * as we can see e1 equals e2 and e2 equals e3, but e1 not equal e3
     * and also if we want to compare for example e1 and e2
     * sometimes we will get false;
     * Also if we want to compare object with null
     * equls will return true;
     */
    @Test
    public void HashSetBrokenTransitiveAndConsistent() {
        EntityTransitive e1 = new EntityTransitive(12, "Oleg", 22);
        EntityTransitive e2 = new EntityTransitive(12, "Oleg", 22);
        EntityTransitive e3 = new EntityTransitive(12, "Oleg", 22);
        Set<EntityTransitive> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        System.out.println("e1 equals e2 - " + e1.equals(e2));
        System.out.println("e2 equals e3 - " + e2.equals(e3));
        System.out.println("e1 equals e3 - " + e1.equals(e3));

        System.out.println("//////");

        System.out.println("e1 equals e2 - " + e1.equals(e2));
        System.out.println("e1 equals e2 - " + e1.equals(e2));
        System.out.println("e1 equals e2 - " + e1.equals(e2));

        System.out.println("e1 equals null - " + e1.equals(null));
        Assert.assertEquals(1, set.size());
        System.out.println(set);
    }
}
