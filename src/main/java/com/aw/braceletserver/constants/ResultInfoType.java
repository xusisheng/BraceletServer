package com.aw.braceletserver.constants;

public enum ResultInfoType {
	RESULT_SUCCESS(0, "成功"),
	RESULT_FAIL(1, "错误"),
	RESULT_TOKEN_TIMEOUT(2, "令牌超时"),
	RESULT_HTTP_TIMEOUT(3, "请求超时"),
	RESULT_TOKEN_INCONFORMITY(4, "请求中的Token存在问题"),
	RESULT_FAIL_BLANK(5, "不能为空值"),
	RESULT_USER_NOT_EXIST(6, "用户不存在"),
	RESULT_FORMAT_ERROR(7, "数据格式化异常"),
	RESULT_NEED_REBIND(8, "你的证券帐号已在其他设备登录，如非本人操作请及时修改密码"),
	RESULT_NEED_REBIND_UPDATE(8, "请重新绑定您的证券账户"),
	RESULT_PASS_ERROR(9, "安全密码错误，你还可以输入%s次"),
	RESULT_ERROR_TRADETIME(10, "不是交易日或交易时间段"),
	RESULT_ERROR_OPERATE_TIMEOUT(11, "操作超时"),
	RESULT_NEED_LOGIN(12, "用户超时重新登录"),
	RESULT_ERROR_BIND_STATUS(13, "绑定状态错误(临时Token已发出)"),
	RESULT_ERROR_MAX_BAD_PASS_ERROR(14, "安全密码输入错误过多,请点击忘记密码进行找回或明日重试"),
	RESULT_ERROR_ACCOUNT_NOT_EXIST(15, "帐号不存在，请核对后再试"),
	RESULT_ERROR_LOGIN(16, "帐户登录失败"),
	RESULT_ERROR_ACCOUNT_STATUS(17, "您的帐户状态不正确"),
	RESULT_ERROR_ACCOUNT_LIMITATION(18, "您的登录受限制"),
	RESULT_ERROR_ACCOUNT_TRADE_PASS(19, "交易密码错误，请重新输入"),
	// 大约可买
	RESULT_ERROR_BYOND_STOCK_PRICE(20, "委托价格超过涨跌幅范围"),
	RESULT_ERROR_INPUT_WRONG(21, "本次输入无效"),
	// 大约可卖
	RESULT_ERROR_NO_BROKER_REG(22, "未登记该交易所帐号"),
	RESULT_ERROR_STOCK_NOT_EXIST(23, "此股票不存在"),
	RESULT_ERROR_NO_ENTRUST(24, "此股票不能进行此类委托"),
	RESULT_ERROR_STOCK_PINGPAI(25, "该股票已停牌，暂时无法交易"),
	RESULT_ERROR_TRADE_ACCOUNT_STATUS(26, "帐户状态不正常"),
	RESULT_ERROR_NO_ASSIGN_TRADE(27, "您未做指定交易"),
	RESULT_ERROR_INPUT_INFO(28, "本次输入无效"),
	// token失效
	RESULT_ERROR_TOKEN_INVALID(29, "该次请求token无效"),
	// 银证业务
	RESULT_ERROR_NO_BANK_TRANSFER(30, "未开通此银行转帐业务"),
	RESULT_ERROR_NO_ENOUGH_MONEY(31, "可取资金不足"),
	RESULT_ERROR_TOTAL_EXCEED_LIMIT(32, "累计转帐金额超出限制"),
	RESULT_ERROR_BANK_PASS(33, "资金密码错误"),
	RESULT_ERROR_BANK_TRANSTER(34, "周边银行转帐错误"),
	RESULT_EXCEED_LOGIN_TIMES_FAIL(35, "登录过于频繁,请5分钟后重试"),
	RESULT_ACCORD_LOGOUT_FAIL(36, "用户已正常退出，请重新登录"),
	RESULT_CURRENT_SYSTEM_NO_SUPPORT_ERROR(37, "当前系统状态不支持此操作"),
	RESULT_OUT_OF_LIMIT(38, "操作频繁,请稍候再试"),
	RESULT_QUANTITY_DOES_NOT_CONFORM(39, "数量不符合交易所规定"),
	RESULT_ENTRUSTED_PRICE_DOES_NOT_CONFORM(40, "委托价格不符合交易所规定"),
	RESULT_NOT_ENOUGH_MONEY(41, "可取现金不足"),
	RESULT_NOT_ENOUGH_STOCK(42, "股票余额不足"),
	RESULT_CLOSED_TIME_CANOUT_BE_ENTRUSTED(43, "闭市时间不能委托"),
	RESULT_STOCK_IS_NOT_FOR_SUCH_DELEGATION(44, "此股不能进行此类委托"),
	RESULT_SUSPENDED(45, "此股票停牌，不能委托"),
	RESULT_DO_NOT_SPECIFY_TRANSACTION(46, "您未作指定交易"),
	RESULT_ENTRUST_FAIL(47, "委托失败"),
	RESULT_HAVE_NOT_ENTRUST(48, "无此委托"),
	RESULT_CAN_NOT_WITHDRAW(49, "此委托不能撤单"),
	RESULT_NO_SHENGOU_CODE(50, "无此申购代码"),
	RESULT_NO_MATCH_RECORD(51, "没有配号记录"),
	RESULT_QUERY_FAIL(52, "查询失败"),
	RESULT_NO_SHENGOU_CODE_ZHONGQIAN(53, "无此申购代码"),
	RESULT_NO_MATCH_RECORD_ZHONGQIAN(54, "没有中签记录"),
	RESULT_QUERY_FAIL_ZHONGQIAN(55,"查询中签失败"),
	RESULT_QUERY_FAIL_SHENGOU(56, "查询证券申购权益表失败"),
	RESULT_SYSTEM_COMM_ERROR(98, "系统通讯异常"),
	RESULT_SYSTEM_ERROR(99, "系统异常");

	private int resultcode;
	private String resultInfo;

	public int getResultcode() {
		return resultcode;
	}

	public void setResultcode(int resultcode) {
		this.resultcode = resultcode;
	}

	public String getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}

	private ResultInfoType(int resultcode, String resultInfo) {
		this.resultcode = resultcode;
		this.resultInfo = resultInfo;
	}

}
