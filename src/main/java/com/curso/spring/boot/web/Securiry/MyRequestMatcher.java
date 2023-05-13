package com.curso.spring.boot.web.Securiry;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class MyRequestMatcher {
    public static RequestMatcher createMatcher(String... patterns) {
        AntPathRequestMatcher[] matchers = new AntPathRequestMatcher[patterns.length];
        for (int i = 0; i < patterns.length; i++) {
            matchers[i] = new AntPathRequestMatcher(patterns[i]);
        }
        return new OrRequestMatcher(matchers);
    }
}
