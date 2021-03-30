package com.durong.student_info_manager.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig {

    public void registerErrorPages(ErrorPageRegistry registry)
    {
        /* According to error type to jump! */
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/templates/common/404.html");
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/templates/common/500.html");
        registry.addErrorPages(e404, e500);
    }
}
