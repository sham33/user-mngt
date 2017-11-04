package com.example.user.mngt.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserilizer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser parser, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = null;
		try {
			date = formatter.parse(parser.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
