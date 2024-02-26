package org.example.saas.core.domain.enums;

import com.chia.multienty.core.domain.enums.HttpResultEnum;
import com.chia.multienty.core.exception.KutaRuntimeException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActivityType {
    DISCOUNT(1, "限时折扣", false),
    GROUP_BUYING(2, "团购", true),
    ;
    @JsonValue
    private Integer id;
    private String describe;

    private Boolean standaloneStock;

    @JsonCreator
    public static ActivityType valueOf(Integer id) {
        if(id == null) {
            return null;
        }
        for (ActivityType type : values()) {
            if(type.getId().equals(id)) {
                return type;
            }
        }
        throw new KutaRuntimeException(HttpResultEnum.ENUM_ITEM_NOT_FOUND);
    }
}
