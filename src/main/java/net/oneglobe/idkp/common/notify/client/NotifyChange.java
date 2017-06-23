package net.oneglobe.idkp.common.notify.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to be used in order to trigger the NotifyAspect. The annotation
 * expects the notification type to be selected.
 *
 * @author Stefan Schönthal
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NotifyChange {

    /**
     * Notification type
     */
    public enum Type {

        /**
         * The element marked by the notifyable interfaces was created
         */
        CREATED,
        /**
         * The element marked by the notifyable interfaces was deleted
         */
        REMOVED,
        /**
         * The element marked by the notifyable interfaces was updated
         */
        UPDATED
    }

    /**
     * The selected notification type
     *
     * @return
     */
    Type type();
}
