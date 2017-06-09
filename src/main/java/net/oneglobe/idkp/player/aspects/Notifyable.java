package net.oneglobe.idkp.player.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.oneglobe.idkp.player.service.ChangeType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Notifyable {

    ChangeType changeType();
}
