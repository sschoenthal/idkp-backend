package net.oneglobe.idkp.common.notify.client;

/**
 * A generic Dto to be used in order to notify an element along with
 * the change type.
 *
 * @author Stefan Schönthal
 * @param <T> Type of element
 */
public class ChangeDto<T> {

    private final T notifyable;
    private final NotifyChange.Type changeType;

    /**
     * Constructs a new ChangeDto using provided element and the
     * respective change type.
     *
     * @param notifyable
     * @param changeType
     */
    public ChangeDto(T notifyable, NotifyChange.Type changeType) {
        this.notifyable = notifyable;
        this.changeType = changeType;
    }

    /**
     * The element for which a change has happened.
     *
     * @return
     */
    public T getNotifyable() {
        return (notifyable);
    }

    /**
     * The type of change which happened to the element.
     *
     * @return
     */
    public NotifyChange.Type getChangeType() {
        return (changeType);
    }
}
