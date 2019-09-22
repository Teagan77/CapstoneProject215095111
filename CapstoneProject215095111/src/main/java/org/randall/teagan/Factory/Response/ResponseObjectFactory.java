package org.randall.teagan.Factory.Response;

import org.randall.teagan.Domain.Request.ResponseObject;

public class ResponseObjectFactory {
    public static ResponseObject buildGenericResponseObj(String responseCode, String responseDescription) {
        return new ResponseObject(responseCode, responseDescription);
    }
}
