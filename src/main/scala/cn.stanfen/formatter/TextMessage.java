package cn.stanfen.formatter;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class TextMessage {
    private String text;
    private TextMessage() {};
    public TextMessage(String text) {
        this.text = text;
    }

    public String toJsonString() {
        Map<String, Object> items = new HashMap<String, Object>();
        items.put("msgtype", "text");

        Map<String, String> textContent = new HashMap<String, String>();
        byte[] byt = StringUtils.getBytesUtf8(text);
        String txt = StringUtils.newStringUtf8(byt);
        textContent.put("content", txt);
        items.put("text", textContent);
        items.put("at", "onway");


        return JSON.toJSONString(items);
    }
}
