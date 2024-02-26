package org.example.saas.core.domain.enums;

import com.chia.multienty.core.domain.enums.HttpResultEnum;
import com.chia.multienty.core.exception.KutaRuntimeException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderSubmitMode {

    SHOPPING_CART(1, "购物车"),
    IMMEDIATE(2, "直接购买");

    @JsonValue
    private Integer value;
    private String describe;

    @JsonCreator
    public static OrderSubmitMode valueOf(Integer value) {
        if(value == null) {
            return null;
        }
        for (OrderSubmitMode mode : values()) {
            if(mode.getValue().equals(value)) {
                return mode;
            }
        }
        throw new KutaRuntimeException(HttpResultEnum.ENUM_ITEM_NOT_FOUND);
    }
}
