package com.atheesh.app.ws.model.response;

import com.atheesh.app.ws.shared.enums.ItemStatus;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class ItemResponse {

    private int id;
    private String name;
    private Date createdDate;
    private Date updatedDate;
    private ItemStatus status;
}
