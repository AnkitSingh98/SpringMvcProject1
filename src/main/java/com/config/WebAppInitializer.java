package com.config;

import com.entities.Todo;
import jakarta.servlet.ServletContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.util.ArrayList;
import java.util.List;

/*

This class is replacement for web.xml
And used to configure Dispatcher Servlet

web.xml code:
<web-app>
  <display-name>Archetype Created Web Application</display-name>

  <servlet>
    <servlet-name>app</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>

  <servlet-mapping>
    <servlet-name>app</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
</web-app>

 */

public class WebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // No root context
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/" };
    }

    @Override
    public void onStartup(ServletContext servletContext) throws jakarta.servlet.ServletException {

        System.out.println("Context created!!");

        List<Todo> list = new ArrayList<>();
        servletContext.setAttribute("list", list);

        // IMPORTANT: must call super
        super.onStartup(servletContext);
    }
}
