package net.oneglobe.idkp.common.notify.client;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Aspect
@Component//[TODO] not sure why this one is required. If it's not present, the aspect seems to be ignored
public class NotifyAspect {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Pointcut("@annotation(NotifyChange)")
    public void notifyPointcut() {
    }

    @AfterReturning(pointcut = "execution(public Notifyable+ net.oneglobe.idkp.*.service.*.*(..)) && notifyPointcut() && @annotation(notifyChange)", returning = "notifyable")
    public void notify(NotifyChange notifyChange, Notifyable notifyable) {
        applicationEventPublisher.publishEvent(new ChangeEvent(this, notifyable, notifyChange.type()));
    }

}
