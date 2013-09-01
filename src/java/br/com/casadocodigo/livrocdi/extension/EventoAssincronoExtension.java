/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.extension;

import br.com.casadocodigo.livrocdi.events.Assincrono;
import java.lang.reflect.Method;
import java.util.List;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ObserverMethod;
import org.jboss.weld.bean.builtin.BeanManagerProxy;
import org.jboss.weld.event.ObserverMethodImpl;
import org.jboss.weld.injection.MethodInjectionPoint;
import org.jboss.weld.manager.BeanManagerImpl;

/**
 *
 * @author gilliard
 */
public class EventoAssincronoExtension implements Extension {

    void afterBeanDiscovery(@Observes AfterBeanDiscovery abd, BeanManager bm) {

        BeanManagerImpl manager = ((BeanManagerProxy) bm).delegate();

        List<ObserverMethod<?>> observers = manager.getObservers();

        for (ObserverMethod<?> observerMethod : observers) {
            ObserverMethodImpl observerMethodImpl = (ObserverMethodImpl) observerMethod;

            MethodInjectionPoint methodInjectionPoint = observerMethodImpl.getMethod();

            AnnotatedMethod annotatedMethod = methodInjectionPoint.getAnnotated();
            Method method = annotatedMethod.getJavaMember();

            if (method.isAnnotationPresent(Assincrono.class)) {

                ObserverMethod observerMethodWrapper = new ObserverMethodWrapper(observerMethodImpl);

                observers.remove(observerMethodImpl);
                abd.addObserverMethod(observerMethodWrapper);
            }
        }
    }
}
