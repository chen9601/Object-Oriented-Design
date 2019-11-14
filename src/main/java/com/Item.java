package com;

import lombok.Builder;
import lombok.Data;

/**
 * 아이템 객체 모델
 * @author Se-Ok Jeon
 * @version 1.0
 */
@Data
@Builder
public class Item {

    private int price;

}
