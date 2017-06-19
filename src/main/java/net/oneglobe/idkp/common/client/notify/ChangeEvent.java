package net.oneglobe.idkp.common.client.notify;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

public class ChangeEvent<T extends EntityDto> extends ApplicationEvent implements ResolvableTypeProvider {

    private final T entity;
    private final Notifyable.ChangeType changeType;

    public ChangeEvent(Object source, T entity, Notifyable.ChangeType changeType) {
        super(source);
        this.entity = entity;
        this.changeType = changeType;
    }

    public Notifyable.ChangeType getChangeType() {
        return (changeType);
    }

    public T getEntity() {
        return (entity);
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(),
                ResolvableType.forInstance(entity));
    }

}
