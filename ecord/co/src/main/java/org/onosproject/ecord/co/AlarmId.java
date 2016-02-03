package org.onosproject.ecord.co;

import com.google.common.annotations.Beta;

import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Alarm identifier suitable as an external key.
 * <p>
 * This class is immutable.</p>
 */
@Beta
public final class AlarmId {

    private final long id;

    /**
     * Instantiates a new Alarm id.
     *
     * @param id the id
     */
    public AlarmId(final long id) {
        this.id = id;
    }

    /**
     * Creates an alarm identifier from the specified long representation.
     *
     * @param value long value
     * @return intent identifier
     */
    public static AlarmId valueOf(final long value) {
        return new AlarmId(value);
    }

    /**
     * Returns the backing integer index.
     *
     * @return backing integer index
     */
    public long fingerprint() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AlarmId) {
            final AlarmId other = (AlarmId) obj;
            return Objects.equals(this.id, other.id);
        }
        return false;
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("id", id).toString();
    }

}