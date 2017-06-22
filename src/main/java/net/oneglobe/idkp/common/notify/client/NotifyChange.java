package net.oneglobe.idkp.common.notify.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NotifyChange {

    public enum Type {
        CREATED,
        REMOVED,
        UPDATED
    }

    Type type();
}
