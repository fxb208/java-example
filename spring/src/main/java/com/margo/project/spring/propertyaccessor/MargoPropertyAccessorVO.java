package com.margo.project.spring.propertyaccessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://blog.csdn.net/f641385712/article/details/95481552
 * @author fangxingbang
 *
 */
@SuppressWarnings("unused")
public class MargoPropertyAccessorVO {

	private String color;

    // 复杂类型
    private MargoSizeVO size = new MargoSizeVO(); // 苹果的尺寸。 存在级联
    private String[] arrStr = new String[1];
    private List<String> listStr = new ArrayList<>();
    private Map<Integer, String> map = new HashMap<>();

    // 更为复杂的类型
    private List<List<String>> listList = new ArrayList<>();
    private List<Map<Integer, String>> listMap = new ArrayList<>();

    public MargoPropertyAccessorVO() {
        super();
        listList.add(new ArrayList<>());
        listMap.add(new HashMap<>());
    }

	@Override
	public String toString() {
		return "MargoPropertyAccessorVO [color=" + color + ", size=" + size + ", arrStr=" + Arrays.toString(arrStr)
				+ ", listStr=" + listStr + ", map=" + map + ", listList=" + listList + ", listMap=" + listMap + "]";
	}
}
