package entity;

import java.util.Objects;

public class EntityBrokenSymmetric2 extends EntityBrokenSymmetric{
    public EntityBrokenSymmetric2(int id, String name, int age) {
        super(id, name, age);
    }


    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EntityBrokenSymmetric2)) return false;
        final EntityBrokenSymmetric2 other = (EntityBrokenSymmetric2) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EntityBrokenSymmetric2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge());
    }

}
