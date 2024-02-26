package org.example.saas.core.domain.enums;

import com.chia.multienty.core.domain.enums.HttpResultEnum;
import com.chia.multienty.core.exception.KutaRuntimeException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderType {

    NORMAL_ORDER(1, "普通订单"),
    GROUP_BUYING_LAUNCH(2, "发起拼团"),
    GROUP_BUYING_JOIN(3, "参与拼团");


    @JsonValue
    private Integer value;
    private String describe;

    @JsonCreator
    public static OrderType valueOf(Integer value) {
        if(value == null) {
            return null;
        }
        for (OrderType type : values()) {
            if(type.getValue().equals(value)) {
                return type;
            }
        }
        throw new KutaRuntimeException(HttpResultEnum.ENUM_ITEM_NOT_FOUND);
    }
}
