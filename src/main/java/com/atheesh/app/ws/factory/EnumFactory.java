package com.atheesh.app.ws.factory;

import com.atheesh.app.ws.entities.UserEntity;
import com.atheesh.app.ws.shared.enums.UserStatus;

public class EnumFactory {

    public static int getUserStatusIntValue(String status){

        switch (status) {
            case "ACTIVE":
                return UserStatus.ACTIVE.ordinal();
            case "REMOVED":
                return UserStatus.REMOVED.ordinal();
            case "BLOCKED":
                return UserStatus.BLOCKED.ordinal();
            case "INACTIVE":
                return UserStatus.INACTIVE.ordinal();
            default:
                return 100;
        }

    }
}
