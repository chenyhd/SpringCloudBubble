package com.chenyh.provier.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Component
public class ServerCircuitBreaker implements ZuulFallbackProvider {

    @Override
    public String getRoute() {
        return "user-provider";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }

            @Override
            public InputStream getBody() throws IOException {
                ObjectMapper mapper = new ObjectMapper();
                Map<String,Object> map = new HashMap();
                map.put("Server", getRoute());
                map.put("StatusCode", getStatusCode());
                map.put("RawStatusCode", "Server Unavailable");
                map.put("Msg", "服务器累趴了");
                String json = mapper.writeValueAsString(map);
                return new ByteArrayInputStream(json.getBytes());
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_GATEWAY;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }
        };
    }
}
