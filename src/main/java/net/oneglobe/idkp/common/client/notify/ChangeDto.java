package net.oneglobe.idkp.common.client.notify;

public class ChangeDto<T extends EntityDto> {

    private final T entity;
    private final Notifyable.ChangeType changeType;

    public ChangeDto(T entity, Notifyable.ChangeType changeType) {
        this.entity = entity;
        this.changeType = changeType;
    }

    public T getEntity() {
        return (entity);
    }

    public Notifyable.ChangeType getChangeType() {
        return (changeType);
    }
}
