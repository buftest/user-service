package com.buftest.userservice;

import static com.buftest.userservice.DateUtils.convertToDateTime;

import com.userservice.v1.User;
import java.util.Arrays;
import java.util.List;

public class UserRepository {


  List<User> users = Arrays.asList(
    User.newBuilder()
      .setName("Thomas Laz")
      .setEmail("thomas.laz@example.com")
      .setId("211f9149-a999-4690-86aa-442438cd0959")
      .setCreatedAt(convertToDateTime("2023-07-04T10:30:00+00:00"))
      .build(),
    User.newBuilder()
      .setId("49d5bdac-0291-49bd-b458-c8fc50baf4b4")
      .setName("Lerato Stig")
      .setEmail("lerato.stig@example.com")
      .setCreatedAt(convertToDateTime("2004-07-04T10:30:00+00:00"))
      .build(),
    User.newBuilder()
      .setId("0d4515c4-231e-4806-9329-cf2bd110850b")
      .setName("Silverius Nova")
      .setEmail("silverius.nova@example.com")
      .setCreatedAt(convertToDateTime("2013-07-04T10:30:00+00:00"))
      .build(),
    User.newBuilder()
      .setId("8de4afb0-73c3-4d1f-816b-3455e02e3191")
      .setName("Tove Yeshayahu")
      .setEmail("tove.yeshayahu@example.com")
      .setCreatedAt(convertToDateTime("2017-07-04T10:30:00+00:00"))
      .build()
  );

  public User findUser(String userId) {
    return users.stream().filter((u) -> u.getId() == userId).findFirst().orElseGet(null);
  }



}
