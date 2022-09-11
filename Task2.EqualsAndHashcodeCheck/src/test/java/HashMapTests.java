import entity.Entity;
import entity.EntityEqualsWithoutHashcode;
import entity.EntityWithoutEqualsAndHash;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTests {
    /**
     * In this test we have entity. Equals and hashcode was overridden.
     * We are trying to put 3 identical keys into map
     * We would like to get as result only one key in map.
     * If test is passed, it means we got expected result.
     */
    @Test
    public void HashMapWithEqualsAndHash(){
        Entity e1 = new Entity(12,"Oleg",22);
        Entity e2 = new Entity(12,"Oleg",22);
        Entity e3 = new Entity(12,"Oleg",22);
        Map<Entity, Integer> map = new HashMap<>();
        map.put(e1, 1);
        map.put(e2, 2);
        map.put(e3, 3);
        Assert.assertEquals(1, map.size());
        Assert.assertEquals(3, (int)map.get(e1));

    }

    /**
     * The same test as previous, but without overriding equals and hashcode.
     * In this case
     * We have 3 identical keys, but because equals and hashcode are not overridden
     * map consider keys as non equals objects
     */
    @Test
    public void HashMapWithoutHasAndEquals() {
        EntityWithoutEqualsAndHash e1 = new EntityWithoutEqualsAndHash(12,"Oleg",22);
        EntityWithoutEqualsAndHash e2 = new EntityWithoutEqualsAndHash(12,"Oleg",22);
        EntityWithoutEqualsAndHash e3 = new EntityWithoutEqualsAndHash(12,"Oleg",22);
        Map<EntityWithoutEqualsAndHash, Integer> map = new HashMap<>();
        map.put(e1, 1);
        map.put(e2, 2);
        map.put(e3, 3);
        Assert.assertEquals(1, map.size());
        Assert.assertEquals(3, (int)map.get(e1));
    }
    /**
     * This is the same test as previous, but equals method is overridden.
     * So in this case we would like to see that we only have 1 key in map.
     * When we are comparing objects by equals we have positive result, but despite that
     * These objects have different hashcode that's why we still have duplicate keys in our map
     * As we can see results in hashmap is the same as in the hashset
     */
    @Test
    public void HashMapWithEquals() {
        EntityEqualsWithoutHashcode e1 = new EntityEqualsWithoutHashcode(12,"Oleg",22);
        EntityEqualsWithoutHashcode e2 = new EntityEqualsWithoutHashcode(12,"Oleg",22);
        EntityEqualsWithoutHashcode e3 = new EntityEqualsWithoutHashcode(12,"Oleg",22);
        Map<EntityEqualsWithoutHashcode, Integer> map = new HashMap<>();
        map.put(e1, 1);
        map.put(e2, 2);
        map.put(e3, 3);
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
        Assert.assertEquals(1, map.size());
    }
}
