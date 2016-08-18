package cn.wuyl.frame.util.file.apose.log;

import cn.wuyl.frame.util.file.apose.Constant;

public class Logger extends cn.wuyl.frame.core.log.Logger implements ILogger{
    private static String logType = Constant.LOGGER_LEVLE;

    public Logger(Class cls) {
    	super(cls,logType);
		// TODO Auto-generated constructor stub
	}

    public Logger(Class cls,String logType) {
    	super(cls,logType);
		// TODO Auto-generated constructor stub
	}

}
