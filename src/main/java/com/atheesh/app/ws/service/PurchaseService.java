package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.PurchaseDTO;

import java.util.List;

public interface PurchaseService {

    List<PurchaseDTO> purchase(PurchaseDTO purchaseDTO);

}
