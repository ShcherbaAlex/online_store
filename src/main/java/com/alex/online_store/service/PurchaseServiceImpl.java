package com.alex.online_store.service;


import com.alex.online_store.controller.dto.FinishPurchaseRequest;
import com.alex.online_store.entity.OrderEntity;
import com.alex.online_store.entity.ProductEntity;
import com.alex.online_store.entity.PurchaseItemEntity;
import com.alex.online_store.exception.NotFoundException;
import com.alex.online_store.repository.OrderEntityRepository;
import com.alex.online_store.repository.PurchaseItemEntityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class PurchaseServiceImpl implements PurchaseService {

    private final ProductService productService;
    private final UserService userService;
    private final OrderEntityRepository orderEntityRepository;
    private final PurchaseItemEntityRepository purchaseItemEntityRepository;

    @Override
    public Integer finishPurchase(FinishPurchaseRequest request) {
        log.info("creating order entity from request: {}", request);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserEntity(userService.findOrCreateUser(request.getUserName(), request.getUserSurname(), request.getPhone(), request.getEmail(), request.getAddress()));
        orderEntity.setComment(request.getComment());
        orderEntity = orderEntityRepository.save(orderEntity);

        for (Map.Entry<Integer, Integer> entry : request.getProductIdProductCount().entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            try {
                ProductEntity productEntity = productService.findById(k);
                PurchaseItemEntity purchaseItemEntity = new PurchaseItemEntity();
                purchaseItemEntity.setProductEntity(productEntity);
                purchaseItemEntity.setCount(v);
                purchaseItemEntity.setOrderEntity(orderEntity);
                purchaseItemEntityRepository.save(purchaseItemEntity);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }

        }
        return orderEntity.getId();
    }
}
