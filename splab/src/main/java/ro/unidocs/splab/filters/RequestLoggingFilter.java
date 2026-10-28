package ro.unidocs.splab.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Filter ce demonstreaza sablonul Chain of Responsibility.
 * Intercepteaza fiecare cerere HTTP inainte si dupa procesarea efectiva din controller.
 */
@Component
@Order(1)
public class RequestLoggingFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        logger.info("[Chain of Responsibility] >>> Inainte de procesare: {} {}",
                httpRequest.getMethod(), httpRequest.getRequestURI());

        long startTime = System.currentTimeMillis();

        // Propagam cererea mai departe in lant (Chain of Responsibility)
        chain.doFilter(request, response);

        long duration = System.currentTimeMillis() - startTime;
        logger.info("[Chain of Responsibility] <<< Dupa procesare: {} {} -> status {} (durata: {} ms)",
                httpRequest.getMethod(), httpRequest.getRequestURI(), httpResponse.getStatus(), duration);
    }
}
