package org.cnu.realcoding.vo;
import org.cnu.realcoding.domain.Dog;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

    @Data
    @Getter
    @Setter
    @Builder
    public class PatchDog
    {
        private String name;
        private String kind;
        private String ownerName;
        private String ownerPhoneNumber;

    }




