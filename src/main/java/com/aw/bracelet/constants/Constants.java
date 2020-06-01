package com.aw.bracelet.constants;

/**系统常用常量*/
public final class Constants {
	public static final long USERID = 33845;
	public static final String PUSHTIMEFILE = ".pushtime";

	/**
	 * 服务ID
	 */
	public static final String SERVICEID = "NBWatch";

	/**
	 * 命令方法
	 */
	public enum METHOD {
		UPLOAD, SEND_NOTICE, DEVICE_MANAGE, DEVSOS
	}

	/**
	 * 用户设备表状态
	 */
	public interface USERDEVICESTATUS {
		int BIND = 1;
		int UNBIND = 2;
	}

	public enum DeviceStatus {
		OFFLINE(0, "OFFLINE"),
		ONLINE(1, "ONLINE"),
		ABNORMA(2, "ABNORMA");

		private int code;
		private String value;

		DeviceStatus(int code, String value) {
			this.code = code;
			this.value = value;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	/**
	 * 客户主动获取的推送信息类型
	 */
	public enum PushInfoType {
		UPLOAD(0, "UPLOAD"),
		DEVSOS(1, "DEVSOS");

		private int code;
		private String value;

		PushInfoType(int code, String value) {
			this.code = code;
			this.value = value;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}




	public static final String SerialNumber = "SerialNumber";
	public static final String Token = "Token";
	public static final String DeviceId = "DeviceId";
	public static final String Model = "Model";
	public static final String NeedPhone = "NeedPhone";
	public static final String Icon = "Icon";
	public static final String GroupId = "GroupId";
	public static final String UserDeviceId = "UserDeviceId";
	public static final String LoginName = "LoginName";
	public static final String Username = "Username";
	public static final String pwd = "pwd";
	public static final String State = "State";
	public static final String UserId = "UserId";
	public static final String Id = "Id";
	public static final String AccessToken = "AccessToken";
	public static final String Message = "Message";
	public static final String GroupName = "GroupName";
	public static final String Weight = "Weight";
	public static final String Height = "Height";
	public static String DeviceCount = "DeviceCount";
	public static String UserType = "UserType";
	public static String CodeUrl = "CodeUrl";
	public static String Email = "Email";
	public static String Timezone = "Timezone";
	public static String User = "User";
	public static String Item = "Item";
	public static String MSG = "msg";

	public static String SubUsersCount = "SubUsersCount";
	public static String Avatar = "Avatar";
	public static String ThirdID = "ThirdID";
	public static String ThirdType = "ThirdType";
	public static final String Password = "Password";
	public static String CellPhone = "CellPhone";

	public static final String Address = "Address";
	/**电量*/
	public static final String Battery = "Battery";
	/**气压*/
	public static final String Atmosphere = "Atmosphere";
	public static String Gender = "Gender";
	public static String Sex = "Sex";
	public static String LoginType = "LoginType";
	public static String OldPass = "OldPass";
	public static String NewPass = "NewPass";
	public static String SubGroups = "SubGroups";
	public static String Items = "Items";
	public static String MapType = "MapType";

	public static String Latitude = "Latitude";
	public static String Longitude = "Longitude";
	public static String OLat = "OLat";
	public static String OLng = "OLng";

	public static String Radius = "Radius";
	public static String FenceType = "FenceType";
	public static String AlarmType = "AlarmType";
	public static String FenceName = "FenceName";
	public static String Name = "Name";
	public static String NickName = "NickName";
	public static String Status = "Status";
	public static String DeviceUtcTime = "DeviceUtcTime";
	public static String PositionType = "PositionType";
	public static String StartTime = "StartTime";
	public static String EndTime = "EndTime";

	public static String StepCount = "StepCount";
	public static String SleepRatio = "SleepRatio";
	public static String HeartItems = "HeartItems";
	public static String BloodPressureItems = "BloodPressureItems";
	public static String BloodSugarItems = "BloodSugarItems";
	public static String TemperatureItems = "TemperatureItems";

	public static String Diastolic = "Diastolic";
	public static String Shrink = "Shrink";
	public static String LastUpdate = "LastUpdate";
	public static String IMEI = "IMEI";
	public static String BloodSugar = "BloodSugar";
	public static String Steps = "Steps";
	public static String Heartbeat = "Heartbeat";
	public static String BloodPressure = "BloodPressure";
	public static String BodyTemperature = "BodyTemperature";

	public static String SelectCount = "SelectCount";
	public static String LastLocationId = "LastLocationId";
	public static String LastDeviceUtcDate = "LastDeviceUtcDate";
	public static String Altitude = "Altitude";//海拔


	public static String CODE = "code";
	public static interface state {
		int success =0;
	}
	
	public static String Success = "Success";
	/**
	 * 保存用户到SESSION
	 */
	public static String USER_SESSION = "USER_SESSION";
	
	public static String USER_DIARY_ = "USER_DIARY_";
	
	public static String ANCIENT_LIST = "ANCIENT_LIST";
	
	public static String ANCIENT_TYPE = "ANCIENT_TYPE";
	
	public static String ANCIENT_RIGHT = "ANCIENT_RIGHT";
	
	public static String LOGIN_TIME = "LOGIN_TIME";
	
	public static String IS_WEB = "IS_WEB";
	
	public static String CREATE_USER = "createUser";
	
	/**标题*/
	public static String TITLE = "title";
	/**总记录数*/
	public static String TOTAL = "total";
	/**作者*/
	public static String AUTHOR = "author";
	/**类型*/
	public static String TYPE = "type";
	
	/**操作符*/
	public static String OP = "op";
	
	/**当前页*/
	public static String CURRENT_PAGE = "curentPage";
	/**总页数*/
	public static String TOTAL_PAGE = "totalPage";
	
	/**开始行*/
	public static String BEGIN_ROW = "beginRow";
	
	/**每页条数*/
	public static String PAGE_SIZE = "pageSize";
	
	/**排序语句*/
	public static String ORDERBY_CLAUSE = "orderByClause";
	/**按日期排序*/
	public static String CREATE_TIME_DESC= "CREATE_TIME DESC";
	
	
	public static String FILE_DIR = "/home/tianwen/file/pic/"; //服务器文件存放路径
	public static String RES_URL = "http://47.111.30.104:86/res/pic/"; //文件访问路径
	
	
	/**操作符*/
	
	/**操作符*/
	public static String FAILURE = "1";
	/**
	 * 字符集
	 */
	public  interface CHARSET {
		String GBK = "GBK";
		String UTF8 = "UTF-8";
	}
}
