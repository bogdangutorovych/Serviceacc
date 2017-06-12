package ua.com.foxminded.serviceacc.controller;

import javax.faces.context.FacesContext;

public class JSFUtils {
    public static <T> T getBean(final String beanName, final Class<T> clazz) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        T bean = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{" + beanName + "}", clazz);
        
        return bean;
    }
}
