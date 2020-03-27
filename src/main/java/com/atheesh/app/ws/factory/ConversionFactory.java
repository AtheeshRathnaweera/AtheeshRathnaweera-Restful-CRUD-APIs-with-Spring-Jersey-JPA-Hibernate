package com.atheesh.app.ws.factory;

import org.springframework.beans.BeanUtils;

public class ConversionFactory {

    public static Object conversion(Object recObj, Object toConvertObject){

        if(recObj != null){
            BeanUtils.copyProperties(recObj, toConvertObject);
            return toConvertObject;
        }else{
            return null;
        }

    }
}
