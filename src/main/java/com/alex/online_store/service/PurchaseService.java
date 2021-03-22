package com.alex.online_store.service;

import com.alex.online_store.controller.dto.FinishPurchaseRequest;

public interface PurchaseService {

    Integer finishPurchase(FinishPurchaseRequest request);
}
