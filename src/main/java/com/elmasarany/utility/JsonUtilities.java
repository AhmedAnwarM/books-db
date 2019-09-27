package com.elmasarany.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Ahmed El Masarany
 */
public class JsonUtilities {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String convertToJson(Object o) throws JsonProcessingException {
        return mapper.writeValueAsString(o);
    }

    public static <T> T convertFromJson(String jsonString, Class<T> type) throws IOException {
        return mapper.readValue(jsonString, type);
    }

}
