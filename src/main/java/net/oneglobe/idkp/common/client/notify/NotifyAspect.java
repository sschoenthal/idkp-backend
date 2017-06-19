package net.oneglobe.idkp.common.client.notify;

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

    @Pointcut("@annotation(net.oneglobe.idkp.common.client.notify.Notifyable)")
    public void notifyPointcut() {
    }

    @AfterReturning(pointcut = "execution(public net.oneglobe.idkp.common.client.notify.EntityDto+ net.oneglobe.idkp.*.service.*.*(..)) && notifyPointcut() && @annotation(notifyable)", returning = "entityDto")
    public void notify(Notifyable notifyable, EntityDto entityDto) {
        applicationEventPublisher.publishEvent(new ChangeEvent(this, entityDto, notifyable.changeType()));
    }

}
