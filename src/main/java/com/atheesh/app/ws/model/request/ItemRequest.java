package com.atheesh.app.ws.model.request;

import com.atheesh.app.ws.shared.enums.ItemStatus;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemRequest {

    private String name;
    private ItemStatus status;
}
