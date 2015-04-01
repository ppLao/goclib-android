package org.goclib.android.entity;

import java.util.Map;

public class GoclPersonInfoEntity extends GoclBaseEntity {
	public static final String GENDER="gender";
	public static final String BIRTHDAY="birthday";
	public static final String PROFESSION="profession";
	public static final String INCOME="income";
	public static final String PHONE="phone";
	public static final String QQ="qq";
	public static final String WEIXIN="weixin";
	public static final String EMAIL="email";
	public static final String USER_NAME="userName";
	public static final String ID_CARD="IDCard";
	public static final String PASSWORD="password";
	
	public GoclPersonInfoEntity(){
		super();
	}
	public GoclPersonInfoEntity(Map<String, Object>keys){
		super(keys);
	}
	@Override
	protected void init(Map<String, Object> attrs) {
		// TODO Auto-generated method stub
		super.init(attrs);
		addKeys(new String[]{GENDER,BIRTHDAY,PROFESSION,INCOME,PHONE,QQ,WEIXIN,EMAIL,USER_NAME,ID_CARD,PASSWORD});
	}
	public GoclPersonInfoEntity setPassword(String value){
		setValue(PASSWORD, value);
		return this;
	}
	public String getPassword(){
		Object _result=getValue(PASSWORD);
		return _result==null?null:_result.toString();
	}
	public GoclPersonInfoEntity setIDCard(String value){
		setValue(ID_CARD, value);
		return this;
	}
	public String getIDCard(){
		Object _result=getValue(ID_CARD);
		return _result==null?null:_result.toString();
	}
	public GoclPersonInfoEntity setEmail(String value){
		setValue(EMAIL, value);
		return this;
	}
	public String getEmail(){
		Object _result=getValue(EMAIL);
		return _result==null?null:_result.toString();
	}
	public GoclPersonInfoEntity setWeixin(String value){
		setValue(GENDER, value);
		return this;
	}
	public String getWeixin(){
		Object _result=getValue(GENDER);
		return _result==null?null:_result.toString();
	}
	public GoclPersonInfoEntity setQQ(String value){
		setValue(QQ, value);
		return this;
	}
	public String getQQ(){
		Object _result=getValue(QQ);
		return _result==null?null:_result.toString();
	}
	public GoclPersonInfoEntity setPhone(String value){
		setValue(PHONE, value);
		return this;
	}
	public String getPhone(){
		Object _result=getValue(PHONE);
		return _result==null?null:_result.toString();
	}
	public GoclPersonInfoEntity setIncome(String value){
		setValue(INCOME, value);
		return this;
	}
	public String getIncome(){
		Object _result=getValue(INCOME);
		return _result==null?null:_result.toString();
	}
	public GoclPersonInfoEntity setProfession(String value){
		setValue(PROFESSION, value);
		return this;
	}
	public String getProfession(){
		Object _result=getValue(PROFESSION);
		return _result==null?null:_result.toString();
	}
	public GoclPersonInfoEntity setGender(String value){
		setValue(GENDER, value);
		return this;
	}
	public String getGender(){
		Object _result=getValue(GENDER);
		return _result==null?null:_result.toString();
	}
	public GoclPersonInfoEntity setBirthday(String value){
		setValue(BIRTHDAY, value);
		return this;
	}
	public String getBirthday(){
		Object _result=getValue(BIRTHDAY);
		return _result==null?null:_result.toString();
	}
	public GoclPersonInfoEntity setUserName(String value){
		setValue(USER_NAME, value);
		return this;
	}
	public String getUserName(){
		Object _result=getValue(USER_NAME);
		return _result==null?null:_result.toString();
	}
}
