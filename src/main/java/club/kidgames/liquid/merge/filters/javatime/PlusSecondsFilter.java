package club.kidgames.liquid.merge.filters.javatime;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import liqp.filters.Filter;

public class PlusSecondsFilter extends Filter {

    public PlusSecondsFilter() {
        super("plus_seconds");
    }

    public Object apply(Object value, Object... params) {
        final long num = params.length == 1 ? (long) params[0] : 0;

        Object ret;

        if (value instanceof ZonedDateTime) {
            ret = ((ZonedDateTime) value).plusSeconds(num);

        } else if (value instanceof LocalTime) {
            ret = ((LocalTime) value).plusSeconds(num);

        } else {
            ret = value;
        }

        return ret;
    }

}
