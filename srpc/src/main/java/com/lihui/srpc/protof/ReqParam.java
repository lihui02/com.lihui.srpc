package com.lihui.srpc.protof;

/**
 * @author ex_lihui4
 * @date 2020-12-17  14:28
 */

public class ReqParam {
    private String serverAddress;
    private Object param;

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }
}
