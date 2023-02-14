package mngwserc.cn.cna;

import java.util.Iterator;
import java.util.Set;

import emf.core.vo.EmfMap;

public class GetAllMapValue {

	public static void getMapValue(EmfMap data) {
		
		Set<String> keySet = data.keySet();
		Iterator<String> iter = keySet.iterator();
		
		System.out.println("Map data start---------------------------");
		while(iter.hasNext()) {
			String key = iter.next();
			Object value = data.get(key);
			
			System.out.println(key + " : [" + value + "]");
		}
		System.out.println("Map data end---------------------------");
	}
}
