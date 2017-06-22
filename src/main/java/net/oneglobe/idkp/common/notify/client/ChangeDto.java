package net.oneglobe.idkp.common.notify.client;

public class ChangeDto<T extends Notifyable> {

    private final T notifyable;
    private final NotifyChange.Type changeType;

    public ChangeDto(T notifyable, NotifyChange.Type changeType) {
        this.notifyable = notifyable;
        this.changeType = changeType;
    }

    public T getNotifyable() {
        return (notifyable);
    }

    public NotifyChange.Type getChangeType() {
        return (changeType);
    }
}
