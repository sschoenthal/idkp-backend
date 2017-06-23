package net.oneglobe.idkp.common.notify.client;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

/**
 * ApplicationEvent to notify changes of notifyable elements. This event is
 * published using an ApplicationEventPublisher. Services using the notification
 * facilities are required to implement an EventListener (matching
 * ChangeEvent<T>) in order to receive the respective events.
 *
 * @author Stefan Schönthal
 * @param <T> Type of element
 */
public class ChangeEvent<T extends Notifyable> extends ApplicationEvent implements ResolvableTypeProvider {

    private final T notifyable;
    private final NotifyChange.Type type;

    /**
     * Constructs a new ChangeEvent using provided event source, notifyable
     * element and the respective change type.
     *
     * @param source
     * @param notifyable
     * @param type
     */
    public ChangeEvent(Object source, T notifyable, NotifyChange.Type type) {
        super(source);
        this.notifyable = notifyable;
        this.type = type;
    }

    /**
     * The type of change which happened to the notifyable element.
     *
     * @return
     */
    public NotifyChange.Type getType() {
        return (type);
    }

    /**
     * The notifyable element for which a change has happened.
     *
     * @return
     */
    public T getNotifyable() {
        return (notifyable);
    }

    /**
     * Type resolving helper method so spring can determing runtime types for
     * classes with generics.
     *
     * @return
     */
    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(),
                ResolvableType.forInstance(notifyable));
    }

}
