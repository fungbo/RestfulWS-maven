package com.tw.common;

import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;

public class CustomerNamespaceMapper extends NamespacePrefixMapper {
    private static final String FOO_PREFIX = "foo";
    private static final String FOO_URI = "http://www.example.com/FOO";

    private static final String BAR_PREFIX = "bar";
    private static final String BAR_URI = "http://www.example.com/BAR";

    private static final String DEFAULT_PREFIX = "";
    private static final String DEFAULT_URI = "http://www.example.com/default";

    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        if (FOO_URI.equals(namespaceUri)) {
            return FOO_PREFIX;
        } else if (BAR_URI.equals(namespaceUri)) {
            return BAR_PREFIX;
        }
        return DEFAULT_PREFIX;
    }

    @Override
    public String[] getPreDeclaredNamespaceUris() {
        return new String[]{FOO_URI, BAR_URI, DEFAULT_URI};
    }

}