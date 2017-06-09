package net.oneglobe.idkp.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.oneglobe.idkp.common.types.ChangeType;
import net.oneglobe.idkp.common.types.ChangeType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Notifyable {

    ChangeType changeType();
}
