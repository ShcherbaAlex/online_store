package com.alex.online_store.controller.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
@ToString(exclude = "password")
public class FinishPurchaseRequest {

    @NotNull
    private Map<Integer,Integer> productIdProductCount;
    @NotEmpty
    private String userName;
    private String userSurname;
    @NotEmpty
    private String email;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String address;
    private String comment;
    private String password;
}
