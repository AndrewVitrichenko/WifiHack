package com.wifihckppsshu.wifihack.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor(access = AccessLevel.PUBLIC,suppressConstructorProperties = true)
public class WifiEntity {

    @Getter
    @Setter
    private String info;

}
