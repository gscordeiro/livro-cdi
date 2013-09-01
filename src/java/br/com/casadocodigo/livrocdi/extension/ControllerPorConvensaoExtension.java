/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.livrocdi.extension;

import br.com.casadocodigo.livrocdi.estereotipo.Controller;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import javax.enterprise.util.AnnotationLiteral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author gilliard
 */
public class ControllerPorConvensaoExtension implements Extension {

    private Logger logger = LoggerFactory.getLogger(ControllerPorConvensaoExtension.class);
    
    void configuraControllers(@Observes ProcessAnnotatedType pat) {

        AnnotatedType at = pat.getAnnotatedType();
        Class classe = at.getJavaClass();

        if (classe.getPackage().getName().endsWith("controllers")
                || classe.getSimpleName().endsWith("Controller")) {

            pat.setAnnotatedType(new AnnotatedTypeControllerWrapper(at));
            logger.info("Controlador encontrado: {}", classe);
        }

    }

    class AnnotatedTypeControllerWrapper implements AnnotatedType {

        private AnnotatedType wrapped;

        AnnotatedTypeControllerWrapper(AnnotatedType orginal) {
            this.wrapped = orginal;
        }
        
        @Override
        public Set<Annotation> getAnnotations() {
            Set<Annotation> annotations = new HashSet<>(wrapped.getAnnotations());
            annotations.add(new AnnotationLiteral<Controller>(){});
            return annotations;
        }

        @Override
        public Class getJavaClass() {
            return wrapped.getJavaClass();
        }

        @Override
        public Set getConstructors() {
            return wrapped.getConstructors();
        }

        @Override
        public Set getMethods() {
            return wrapped.getMethods();
        }

        @Override
        public Set getFields() {
            return wrapped.getFields();
        }

        @Override
        public Type getBaseType() {
            return wrapped.getBaseType();
        }

        @Override
        public Set<Type> getTypeClosure() {
            return wrapped.getTypeClosure();
        }

        @Override
        public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
            return wrapped.getAnnotation(annotationType);
        }

        @Override
        public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
            return wrapped.isAnnotationPresent(annotationType);
        }
        
    }
}
