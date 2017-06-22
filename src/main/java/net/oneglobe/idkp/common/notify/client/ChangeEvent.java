package net.oneglobe.idkp.common.notify.client;

import org.springframework.context.ApplicationEvent;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

public class ChangeEvent<T extends Notifyable> extends ApplicationEvent implements ResolvableTypeProvider {

    private final T notifyable;
    private final NotifyChange.Type type;

    public ChangeEvent(Object source, T notifyable, NotifyChange.Type type) {
        super(source);
        this.notifyable = notifyable;
        this.type = type;
    }

    public NotifyChange.Type getType() {
        return (type);
    }

    public T getNotifyable() {
        return (notifyable);
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(),
                ResolvableType.forInstance(notifyable));
    }

}
