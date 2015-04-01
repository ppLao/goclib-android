package org.goclib.android.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.goclib.android.entity.GoclBaseEntity;

public final class ListUtil {
	public static Map<String, Object>getValueByKey(List<Map<String,Object>> source,String key,Object value){
		List<Map<String, Object>> _result=getValuesByKey(source,key,value,true);
		return _result.size() == 0?null:_result.get(0);
	}
	public static List<Map<String, Object>>getValuesByKey(List<Map<String,Object>> source,String key,Object value){
		return getValuesByKey(source, key, value,false);
	}
	public static List<Map<String, Object>>getValuesByKey(List<Map<String,Object>> source,String key,Object value,boolean getOne){
		List<Map<String, Object>>_result=new ArrayList<Map<String,Object>>();
		if(source == null || source.size() == 0)
			return null;
		boolean _flag=false;
		for(int i=0;i<source.size();i++){
			Map<String, Object>_map=source.get(i);
			if(_map.containsKey(key)){
				Object _value=_map.get(key);
				if(_value!=null){
					if(_value.equals(value)){
						_result.add(_map);
						_flag=true;
					}
				}else if(_value == null && value ==null){
					_result.add(_map);
					_flag=true;
				}
				if(_flag && getOne)
					break;
			}
		}
		return _result;
	}
	
	public static GoclBaseEntity getEntityByKey(List<? extends GoclBaseEntity> source,String key,Object value){
		List<? extends GoclBaseEntity> _result=getEntitysByKey(source,key,value,true);
		return _result.size() == 0?null:_result.get(0);
	}
	
	public static List<? extends GoclBaseEntity> getEntitysByKey(List<? extends GoclBaseEntity>source,String key,Object value){
		return getEntitysByKey(source, key, value, false);
	}
	public static List<? extends GoclBaseEntity> getEntitysByKey(List<? extends GoclBaseEntity>source,String key,Object value,boolean getOne){
		List<GoclBaseEntity>_result=new ArrayList<GoclBaseEntity>();
		boolean _flag=false;
		for(GoclBaseEntity entity :source){
			Object _value=entity.getValue(key);
			if(_value!=null){
				if(_value.equals(value)){
					_result.add(entity);
					_flag=true;
				}
			}else if(_value == null && value ==null){
				_result.add(entity);
				_flag=true;
			}
			if(_flag && getOne)
				break;
		}
		return _result;
	}
}
