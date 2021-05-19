package com.stef.rh.acceptance.util;

//@see https://github.com/albanoj2/order-rest-backend/blob/master/src/test/java/com/dzone/albanoj2/example/rest/test/acceptance/util/AbstractSteps.java

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.StreamUtils;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public abstract class AbstractSteps {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private JdbcTemplate jdbcTemplate;

    @Getter(AccessLevel.PROTECTED)
    private MockHttpServletResponse responseGetValue;
    @Getter(AccessLevel.PROTECTED)
    private MockHttpServletResponse responsePostValue;
    @Getter(AccessLevel.PROTECTED)
    private MockHttpServletResponse responsePutValue;
    @Getter(AccessLevel.PROTECTED)
    private MockHttpServletResponse responseDeleteValue;
    @Getter(AccessLevel.PROTECTED)
    private int statusCode;

    private static < T > T deserializeResponse(MockHttpServletResponse response, TypeReference< T > type) throws Exception {
        return deserialize(response.getContentAsString(), type);
    }

    protected static < T > T deserialize(String json, Class< T > type) throws JsonParseException, JsonMappingException, IOException {
        return mapper.readValue(json, type);
    }

    protected static < T > T deserialize(String json, TypeReference< T > type) throws JsonParseException, JsonMappingException, IOException {
        return mapper.readValue(json, type);
    }

    protected void get(String url, Object... urlVariable) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(url, urlVariable)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andDo(result -> {
                    responseGetValue = result.getResponse();
                    statusCode = responseGetValue.getStatus();
                });
    }

    protected void post(String url, String body, Object... urlVariables) throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(url, urlVariables)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print())
                .andDo(result -> {
                    responsePostValue = result.getResponse();
                    statusCode = responsePostValue.getStatus();
                });
    }

    protected void put(String url, String body) throws Exception {
        mvc.perform(MockMvcRequestBuilders.put(url)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andDo(print())
                .andDo(result -> {
                    responsePutValue = result.getResponse();
                    statusCode = responsePutValue.getStatus();
                });
    }

    protected void delete(String url, Object... urlVariables) throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete(url, urlVariables)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andDo(result -> {
                    responseDeleteValue = result.getResponse();
                    statusCode = responseDeleteValue.getStatus();
                });
    }

    protected < T > T getLastGetContentAs(TypeReference< T > type) throws Exception {
        return deserializeResponse(getResponseGetValue(), type);
    }

    protected < T > T getLastPostContentAs(TypeReference< T > type) throws Exception {
        return deserializeResponse(getResponsePostValue(), type);
    }

    protected void chargerDesRegions(String pathScriptSql) throws IOException {
        getJdbcTemplate().execute(StreamUtils.copyToString(new ClassPathResource(pathScriptSql).getInputStream(), UTF_8));
    }
}