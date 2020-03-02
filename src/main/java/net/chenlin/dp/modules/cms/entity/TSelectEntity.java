package net.chenlin.dp.modules.cms.entity;

import java.io.Serializable;

/**
 * (描述用途)
 *
 * @author Sum
 * @date 2018-08-22 下午 16:28
 */
public class TSelectEntity implements Serializable {

    private String text;

    private String value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
