package com;

import java.lang.RuntimeException;

/**
 * 플레이어 객체 모델
 * @author Se-Ok Jeon
 * @deprecated for now
 * @version 1.0
 */
public class Validator {
    public static boolean isValidForProperty(Object property) throws RuntimeException{
        final int MAX_PROPERTY = 99;
        if(property instanceof Integer){
            if ((Integer)property >= 0 && (Integer) property < MAX_PROPERTY){
                return true;
            }
        }
        throw new RuntimeException("잘못된 값이 입력되었습니다: " + property);
    }
}
