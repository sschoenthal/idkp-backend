package net.oneglobe.idkp.player.aspects;

import net.oneglobe.idkp.common.annotations.Notifyable;
import net.oneglobe.idkp.player.service.PlayerChangeEvent;
import net.oneglobe.idkp.player.service.PlayerDto;
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

    @Pointcut("@annotation(net.oneglobe.idkp.common.annotations.Notifyable)")
    public void notifyPointcut() {
    }

    @AfterReturning(pointcut = "notifyPointcut() && @annotation(notifyable)", returning = "playerDto")
    public void notify(Notifyable notifyable, PlayerDto playerDto) {
        applicationEventPublisher.publishEvent(new PlayerChangeEvent(this, playerDto, notifyable.changeType()));
    }

}
