package com.gorest.constants;

/**
 * Created by Jay
 */
public class EndPoints {

    /**
     * This is Endpoints of student api
     */
    public static final String USER = "/public/v2/users";
    public static final String GET_SINGLE_STUDENT_BY_ID = "/{studentID}";
    public static final String UPDATE_STUDENT_BY_ID = "/{studentID}";
    public static final String DELETE_STUDENT_BY_ID = "/{studentID}";

    /**
     * This is Endpoints of Authentication api
     */
    public static final String GET_ALL_DATA = "/users";
    public static final String USER_ID = "/{id}";
}
