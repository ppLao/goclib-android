package org.goclib.android.entity;

import java.util.Map;

public class GoclMeasureEntity extends GoclBaseEntity {
	public static final String WIDTH="width";
	public static final String HEIGHT="height";
	public GoclMeasureEntity() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	protected void init(Map<String, Object> attrs) {
		// TODO Auto-generated method stub
		super.init(attrs);
		addKeys(new String[]{WIDTH,HEIGHT});
	}
	
	public int getWidth() {
		return Integer.valueOf(getValue(WIDTH)+"");
	}

	public GoclMeasureEntity setWidth(int width) {
		setValue(WIDTH, width);
		return this;
	}
	
	public int getHeight() {
		return Integer.valueOf(getValue(HEIGHT)+"");
	}

	public GoclMeasureEntity setHeight(int height) {
		setValue(HEIGHT, height);
		return this;
	}
}
