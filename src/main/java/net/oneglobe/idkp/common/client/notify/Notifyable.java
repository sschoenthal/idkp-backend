package net.oneglobe.idkp.common.client.notify;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Notifyable {

    public enum ChangeType{
        CREATED,
        REMOVED,
        UPDATED
    }
    
    ChangeType changeType();
}
