package com.base.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.base.model.User;



public class BeanHelper {

	
	public static Object mapToObject(Map<String,Object> map ,Class<?> beanClass){
		if(map == null)
			return null;
		Object obj = null;
		try {
			obj = beanClass.newInstance();
			BeanUtils.populate(obj, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static Object mapToObjectReflect(Map<String,Object> map,Class<?> beanClass){
		Object obj = null;
		try {
			if(map == null) return null;
			obj = beanClass.newInstance();
			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field : fields){
				int mod = field.getModifiers();
				if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
					continue;
				}
				field.setAccessible(true);
				field.set(obj, map.get(field.getName()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	public static Map<String,Object> objectToMap(Object obj){
		if(obj == null) return null;
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field : fields){
				field.setAccessible(true);
				map.put(field.getName(), field.get(obj));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
