package com.BookMyShow.BookMyShow.Utill;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.AttributeConverter;

public class JsonShowConverter
implements AttributeConverter<JsonNode, String> {

        private static final ObjectMapper objectMapper = (new ObjectMapper()).registerModule(new JavaTimeModule());


        @Override
        public String convertToDatabaseColumn(JsonNode attribute) {
            try {
                if (attribute != null) {
                    return objectMapper.writeValueAsString(attribute);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public JsonNode convertToEntityAttribute(String dbData) {
            try {
                if (dbData != null) {
                    return objectMapper.readTree(dbData);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }