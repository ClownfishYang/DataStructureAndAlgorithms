package io.clownfishyang.datastructure.graph;

import lombok.Data;
import lombok.Getter;

/**
 * Copyright (C), 2015-2019, 深圳市环球易购电子商务有限公司<br>
 * 图元素类型<br>
 *
 * @author ClownfishYang<br>
 * created on 2019/12/1 10:30<br>
 */
public enum GraphElementType {
    V(0, "顶点"),
    E(1, "连接"),;
    @Getter
    private int type;
    @Getter
    private String remark;

    GraphElementType(int type, String remark) {
        this.type = type;
        this.remark = remark;
    }
}
