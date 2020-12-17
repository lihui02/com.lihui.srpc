package com.lihui.srpc.client;

import com.lihui.srpc.protof.Result;

/**
 * @author ex_lihui4
 * @date 2020-12-17  11:02
 */
public interface Client {
    <T> Result<T> call(String serverName, String serverAddress, Object param, Class<T> resultType);
}
