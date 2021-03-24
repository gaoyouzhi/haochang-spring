package com.haochang.gateway.config;

import java.util.List;
import java.util.Objects;

/**
 * 网关白名单配置
 */
//@Component
//@ConfigurationProperties(prefix="secure.ignore")
public class IgnoreUrlsConfig {
    private List<String> urls;

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IgnoreUrlsConfig that = (IgnoreUrlsConfig) o;
        return Objects.equals(urls, that.urls);
    }

    @Override
    public int hashCode() {

        return Objects.hash(urls);
    }
}
