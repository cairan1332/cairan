package com.caiRanSystem.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {


    @Override
    public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {
        ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/error/error400Page");
        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/error401Page");
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/error404Page");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/error500Page");
        errorPageRegistry.addErrorPages(error400Page, error401Page, error404Page, error500Page);
    }
}
