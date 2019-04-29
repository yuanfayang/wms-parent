package org.flowable.ui.common.security;

import org.flowable.idm.api.User;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Iterator;

/**
 * SecurityUtils
 *
 * @author luxin.yan
 * @date 2019/1/30
 **/
//
public class SecurityUtils {
    private static User assumeUser;

    private SecurityUtils() {
    }

    public static String getCurrentUserId() {
        User user = getCurrentUserObject();
        return user != null ? user.getId() : null;
    }

    public static User getCurrentUserObject() {
        if (assumeUser != null) {
            return assumeUser;
        } else {
            User user = null;
            FlowableAppUser appUser = getCurrentFlowableAppUser();
            if (appUser != null) {
                user = appUser.getUserObject();
            }
            if (user == null) {
                user = new UserEntityImpl();
                user.setId("1");
                user.setDisplayName("yanluxin");
                user.setFirstName("yan");
                user.setLastName("luxin");
            }
            return user;
        }
    }

    public static FlowableAppUser getCurrentFlowableAppUser() {
        FlowableAppUser user = null;
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (securityContext != null && securityContext.getAuthentication() != null) {
            Object principal = securityContext.getAuthentication().getPrincipal();
            if (principal instanceof FlowableAppUser) {
                user = (FlowableAppUser) principal;
            }
        }

        return user;
    }

    public static boolean currentUserHasCapability(String capability) {
        FlowableAppUser user = getCurrentFlowableAppUser();
        Iterator var2 = user.getAuthorities().iterator();

        GrantedAuthority grantedAuthority;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            grantedAuthority = (GrantedAuthority) var2.next();
        } while (!capability.equals(grantedAuthority.getAuthority()));

        return true;
    }

    public static void assumeUser(User user) {
        assumeUser = user;
    }

    public static void clearAssumeUser() {
        assumeUser = null;
    }
}
