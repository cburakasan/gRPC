package com.microservice.product.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public abstract class BaseResponse implements Serializable {
    private String result;
    private String resultExp;
}
