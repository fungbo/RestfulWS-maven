package com.tw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

public class HttpInfo {
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public class Args {
        private List<Object> args;

        public List<Object> getArgs() {
            return args;
        }

        public void setArgs(List<Object> args) {
            this.args = args;
        }
    }

    public class Headers {
        @JsonProperty("Accept")
        private String accept;
        @JsonProperty("Cache-Control")
        private String cacheControl;
        @JsonProperty("Content-Type")
        private String contentType;
        @JsonProperty("Host")
        private String host;
        @JsonProperty("Pragma")
        private String pragma;
        @JsonProperty("User-Agent")
        private String userAgent;

        public String getAccept() {
            return accept;
        }

        public void setAccept(String accept) {
            this.accept = accept;
        }

        public String getCacheControl() {
            return cacheControl;
        }

        public void setCacheControl(String cacheControl) {
            this.cacheControl = cacheControl;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getPragma() {
            return pragma;
        }

        public void setPragma(String pragma) {
            this.pragma = pragma;
        }

        public String getUserAgent() {
            return userAgent;
        }

        public void setUserAgent(String userAgent) {
            this.userAgent = userAgent;
        }
    }

    private Args args;
    private Headers headers;
    @JsonIgnore
    private String origin;
    private String url;

    public Args getArgs() {
        return args;
    }

    public void setArgs(Args args) {
        this.args = args;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
