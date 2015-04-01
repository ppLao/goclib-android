package org.goclib.android.entity;

import java.util.Map;

public class GoclAreaEntity extends GoclBaseEntity {
	public static final String PROVINCE="province";
	public static final String CITY="city";
	public static final String STREET="street";
	public static final String COUNTRY="country";
	public static enum Category{Country,City,Province,Street};
	
	public GoclAreaEntity() {
		// TODO Auto-generated constructor stub
		super();
		
	}
	public GoclAreaEntity(Map<String,Object>attrs){
		super(attrs);
	}
	
	@Override
	protected void init(Map<String, Object> attrs) {
		// TODO Auto-generated method stub
		addKeys(new String[]{COUNTRY,PROVINCE,CITY,STREET});
		super.init(attrs);
		
	}
	public String getCountry() {
		return getValue(COUNTRY)+"";
	}

	public GoclAreaEntity setCountry(String value) {
		setValue(COUNTRY, value);
		return this;
	}
	
	public String getProvince() {
		return getValue(PROVINCE)+"";
	}

	public GoclAreaEntity setProvince(String value) {
		setValue(PROVINCE, value);
		return this;
	}

	public String getCity() {
		return getValue(CITY)+"";
	}

	public GoclAreaEntity setCity(String value) {
		setValue(CITY, value);
		return this;
	}
	

	public String getStreet() {
		return getValue(STREET)+"";
	}

	public GoclAreaEntity setStreet(String value) {
		setValue(STREET, value);
		return this;
	}
	
	public String getContent(Category category){
		String _result=null;
		switch (category) {
		case Country:
			_result=getCountry();
			break;
		case Province:
			_result=getProvince();
			break;
		case City:
			_result=getCity();
			break;
		case Street:
			_result=getStreet();
			break;
		default:
			break;
		}
		return _result;
	}
}
