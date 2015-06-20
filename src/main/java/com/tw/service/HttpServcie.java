package com.tw.service;

import com.tw.Exception.AccountException;
import com.tw.common.Configuration;
import com.tw.common.Constants;
import com.tw.common.JsonUtils;
import com.tw.model.HttpInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class HttpServcie {
    private static final String HTTPBIN_ADDRESS = Configuration.getProperty("httpbin.address");
    private static HttpURLConnection connection;

    static {
        try {
            URL url = new URL(HTTPBIN_ADDRESS);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(RequestMethod.GET.name());
            connection.setConnectTimeout(5000);
            connection.setUseCaches(false);
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
        } catch (Exception e) {
            connection = null;
        }
    }


    public HttpInfo getHttpInfo() throws AccountException {
        if (isConnectionValid()) {
            try {
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    return JsonUtils.unmarshal(connection.getInputStream(), HttpInfo.class);
                } else {
                    throw new AccountException(Constants.CONNECTION_ERROR, "Response is " + responseCode);
                }
            } catch (IOException e) {
                System.out.println(e.toString());
                throw new AccountException(Constants.CONNECTION_ERROR, "Get httpbin error");
            }
        }
        throw new RuntimeException();
    }

    private boolean isConnectionValid() throws AccountException {
        if (connection == null) {
            throw new AccountException(Constants.CONNECTION_ERROR, "Connection error when get httpbin");
        }
        return true;
    }
}
