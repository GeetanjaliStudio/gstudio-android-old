package com.koalatea.thehollidayinn.softwareengineeringdaily.network.response;

import com.google.gson.stream.JsonReader;
import com.koalatea.thehollidayinn.softwareengineeringdaily.test.BaseJsonParseUnitTest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kurian on 25-Sep-17.
 */
public class AuthResponseTest extends BaseJsonParseUnitTest {

    @Test
    public void parsing_AuthResponse_contains_expected_values() throws Exception {
        JsonReader reader = loadJson("200_auth_response.json");
        AuthResponse actual = gson.fromJson(reader, AuthResponse.class);
        assertNotNull(actual);
        assertEquals("test token", actual.token());
    }
}