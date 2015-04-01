package org.goclib.android.entity;

import java.util.Map;

import org.goclib.android.utils.LogUtil;

public class GoclTitleBarButtonEntity extends GoclBaseEntity {

	public static final String REFERENCE="reference";
	public static final String TEXT="text";
	public static final String TEXT_SIZE="textSize";
	public static final String TEXT_COLOR="textColor";
	public static final String ENABLED="enabled";
	
	@Override
	protected void init(Map<String, Object> attrs) {
		// TODO Auto-generated method stub
		super.init(attrs);
		addKeys(new String[]{REFERENCE,TEXT,TEXT_SIZE,TEXT_COLOR,ENABLED});
	}
	public GoclTitleBarButtonEntity setReference(int id){
		setValue(REFERENCE, id);
		return this;
	}
	public int getReference(){
		return ((Integer) getValue(REFERENCE)).intValue();
	}
	public GoclTitleBarButtonEntity setText(String text){
		setValue(TEXT, text);
		return this;
	}
	public String getText(){
		return (String)getValue(TEXT);
	}
	public GoclTitleBarButtonEntity setTextSize(float size){
		setValue(TEXT_SIZE, size);
		return this;
	}
	public float getTextSize(){
		return Float.valueOf(getValue(TEXT_SIZE)+"");
	}
	
	public GoclTitleBarButtonEntity setTextColor(int color){
		setValue(TEXT_COLOR, color);
		return this;
	}
	public int getTextColor(){
		return Integer.valueOf(getValue(TEXT_COLOR)+"");
	}
	public GoclTitleBarButtonEntity setEnabled(boolean enabled){
		setValue(ENABLED, enabled);
		return this;
	}
	public Boolean getEnabled(){
		return Boolean.valueOf(getValue(ENABLED)+"");
	}
}
