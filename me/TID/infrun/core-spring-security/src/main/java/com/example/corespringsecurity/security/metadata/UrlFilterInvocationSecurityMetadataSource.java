package com.example.corespringsecurity.security.metadata;

import com.example.corespringsecurity.service.SecurityResourceService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class UrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private LinkedHashMap<RequestMatcher, List<ConfigAttribute>> requestMap = new LinkedHashMap<>();
    private SecurityResourceService securityResourceService;

    public UrlFilterInvocationSecurityMetadataSource(LinkedHashMap<RequestMatcher, List<ConfigAttribute>> requestMap, SecurityResourceService securityResourceService) {
        this.requestMap = requestMap;
        this.securityResourceService = securityResourceService;
    }

    public UrlFilterInvocationSecurityMetadataSource(LinkedHashMap<RequestMatcher, List<ConfigAttribute>> resourcesMap) {
        this.requestMap = resourcesMap;
    }


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        HttpServletRequest request = ((FilterInvocation) object).getRequest();

        requestMap.put(new AntPathRequestMatcher("/mypage"), Arrays.asList(new SecurityConfig("ROLE_USER")));

        if (requestMap != null) {
            for (Map.Entry<RequestMatcher, List<ConfigAttribute>> entry : requestMap.entrySet()) {
                RequestMatcher matcher = entry.getKey();
                if (matcher.matches(request)) {
                    return entry.getValue();
                }
            }
        }

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes = new HashSet<>();
        this.requestMap.values().forEach(allAttributes::addAll);
        return allAttributes;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    public void reload() {
        LinkedHashMap<RequestMatcher, List<ConfigAttribute>> reloadedMap = securityResourceService.getResourceList();
        Iterator<Map.Entry<RequestMatcher, List<ConfigAttribute>>> iterator = reloadedMap.entrySet().iterator();

        requestMap.clear();

        while (iterator.hasNext()) {
            Map.Entry<RequestMatcher, List<ConfigAttribute>> entry = iterator.next();
            reloadedMap.put(entry.getKey(), entry.getValue());
        }
    }
}
