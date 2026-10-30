package security;

import io.jsonwebtoken.Claims;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/graphql")
public class JWTAuthenticationFilter implements Filter {

    private static final String AUTHENTICATION_SCHEME = "Bearer";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        HttpServletResponse httpResponse =
                (HttpServletResponse) response;

        String authorizationHeader =
                httpRequest.getHeader("Authorization");

        if (authorizationHeader == null ||
                !authorizationHeader.startsWith(
                        AUTHENTICATION_SCHEME + " "
                )) {

            httpResponse.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED
            );

            httpResponse.getWriter().write(
                    "JWT token required"
            );

            return;
        }

        String token =
                authorizationHeader.substring(
                        AUTHENTICATION_SCHEME.length()
                ).trim();

        try {

            Claims claims =
                    JWTUtil.validateToken(token);

            String username =
                    claims.getSubject();

            request.setAttribute(
                    "authenticatedUser",
                    username
            );

            chain.doFilter(request, response);

        } catch (Exception e) {

            httpResponse.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED
            );

            httpResponse.getWriter().write(
                    "Invalid or expired JWT token"
            );
        }
    }

    @Override
    public void destroy() {

    }
}