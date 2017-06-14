package ua.com.foxminded.serviceacc.controller;

import javax.faces.context.FacesContext;

public class JSFUtils {
    public static <T> T getBean(final Class<T> clazz) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        T bean = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{" + getBeanName(clazz) + "}", clazz);
        
        return bean;
    }
    
    private static <T> String getBeanName(final Class<T> clazz) {
        String beanName = clazz.getSimpleName();
        beanName = Character.toLowerCase(beanName.charAt(0)) + beanName.substring(1);
        
        return beanName;
    }
}
