package com.hw.api;

import com.google.gson.Gson;
import com.hw.api.requests.UsersRequests;

public class BaseTest {
    UsersRequests usersRequests = new UsersRequests();
    Gson gson = new Gson();
}
