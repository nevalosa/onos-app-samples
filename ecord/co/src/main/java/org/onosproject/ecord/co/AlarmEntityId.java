package org.onosproject.ecord.co;

import static com.google.common.base.Preconditions.checkArgument;
import com.google.common.collect.ImmutableSet;
import java.net.URI;
import java.util.Objects;
import java.util.Set;

/**
 * Immutable representation of a alarm source. It is meaningful within the
 * context of a device.
 */
public final class AlarmEntityId {

    public static final AlarmEntityId NONE = new AlarmEntityId(URI.create("none:none"));
    public static final Set<String> SCHEMES = ImmutableSet.of("none", "port", "och", "other");

    private final URI uri;

    private AlarmEntityId(final URI uri) {
        this.uri = uri;
    }

    protected AlarmEntityId() {
        uri = NONE.uri;
    }

    public static AlarmEntityId alarmEntityId(final String string) {
        return alarmEntityId(URI.create(string));
    }

    public static AlarmEntityId alarmEntityId(final URI uri) {
        checkArgument(SCHEMES.contains(uri.getScheme()), "Unexpected scheme");
        return new AlarmEntityId(uri);
    }

    @Override
    public String toString() {
        return uri.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri);

    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AlarmEntityId) {
            final AlarmEntityId other = (AlarmEntityId) obj;
            return Objects.equals(this.uri, other.uri);
        }
        return false;
    }

}