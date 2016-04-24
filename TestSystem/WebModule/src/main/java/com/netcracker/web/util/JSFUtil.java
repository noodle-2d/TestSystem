package com.netcracker.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class JSFUtil {
    
    public static void addMessage(String summary, String detail, Severity severity) {
        FacesMessage facesMessage = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    
    public static void addErrorMessage(String summary, String detail) {
        addMessage(summary, detail, FacesMessage.SEVERITY_ERROR);
    }
    
    public static void addInfoMessage(String summary, String detail) {
        addMessage(summary, detail, FacesMessage.SEVERITY_INFO);
    }
    
    private JSFUtil() { }
    
}