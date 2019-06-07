package org.flowable.ui.modeler.rest.remote;


import org.flowable.ui.common.model.GroupRepresentation;
import org.flowable.ui.common.model.RemoteGroup;
import org.flowable.ui.common.model.RemoteUser;
import org.flowable.ui.common.model.UserRepresentation;
import org.flowable.ui.common.security.SecurityUtils;
import org.flowable.ui.common.service.exception.NotFoundException;
import org.flowable.ui.common.service.idm.RemoteIdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * RemoteAccountResource
 *
 * @author luxin.yan
 * @date 2019/1/30
 **/

@RestController
@RequestMapping({"/app"})
public class MyRemoteAccountResource {
    @Autowired
    private RemoteIdmService remoteIdmService;

    public MyRemoteAccountResource() {
    }

    @RequestMapping(
            value = {"/my/account"},
            method = {RequestMethod.GET},
            produces = {"application/json"}
    )
    public UserRepresentation getAccount() {
        UserRepresentation userRepresentation = null;
        String currentUserId = SecurityUtils.getCurrentUserId();
//        if (currentUserId != null) {
//            RemoteUser remoteUser = this.remoteIdmService.getUser(currentUserId);
//            if (remoteUser != null) {
//                userRepresentation = new UserRepresentation(remoteUser);
//                if (remoteUser.getGroups() != null && remoteUser.getGroups().size() > 0) {
//                    List<GroupRepresentation> groups = new ArrayList();
//                    Iterator var5 = remoteUser.getGroups().iterator();
//
//                    while(var5.hasNext()) {
//                        RemoteGroup remoteGroup = (RemoteGroup)var5.next();
//                        groups.add(new GroupRepresentation(remoteGroup));
//                    }
//
//                    userRepresentation.setGroups(groups);
//                }
//
//                if (remoteUser.getPrivileges() != null && remoteUser.getPrivileges().size() > 0) {
//                    userRepresentation.setPrivileges(remoteUser.getPrivileges());
//                }
//            }
//        }
        userRepresentation = new UserRepresentation(SecurityUtils.getCurrentUserObject());
        if (userRepresentation != null) {
            return userRepresentation;
        } else {
            throw new NotFoundException();
        }
    }
}
