package net.oneglobe.idkp.common.notify.client;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Aspect definition for notification. This aspect is active for all service
 * methods which return an element that implements the Notifyable marker
 * interface and are annotated with NotifyChange. If the aspect is triggered, it
 * will publish a ChangeEvent containing the element and change type using an
 * ApplicationEventPublisher.
 *
 * @author Stefan Schönthal
 */
@Aspect
@Component//[TODO] not sure why this one is required. If it's not present, the aspect seems to be ignored
public class NotifyAspect {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * Pointcut definition for NotifyChange annotation.
     */
    @Pointcut("@annotation(NotifyChange)")
    public void notifyChangePointcut() {
    }

    /**
     * Aspect execution including further pointcut definitions restricting this
     * aspect to trigger for service methods returning an element which
     * implements the notification marker interface only.
     *
     * @param notifyChange
     * @param notifyable
     */
    @AfterReturning(pointcut = "execution(public Notifyable+ net.oneglobe.idkp.*.service.*.*(..)) && notifyChangePointcut() && @annotation(notifyChange)", returning = "notifyable")
    public void notify(NotifyChange notifyChange, Notifyable notifyable) {
        applicationEventPublisher.publishEvent(new ChangeEvent(this, notifyable, notifyChange.type()));
    }

}
