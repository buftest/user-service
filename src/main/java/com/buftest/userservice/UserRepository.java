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
      .setId("1")
      .setCreatedAt(convertToDateTime("2023-07-04T10:30:00+00:00"))
      .build(),
    User.newBuilder()
      .setId("2")
      .setName("Lerato Stig")
      .setEmail("lerato.stig@example.com")
      .setCreatedAt(convertToDateTime("2004-07-04T10:30:00+00:00"))
      .build(),
    User.newBuilder()
      .setId("3")
      .setName("Silverius Nova")
      .setEmail("silverius.nova@example.com")
      .setCreatedAt(convertToDateTime("2013-07-04T10:30:00+00:00"))
      .build(),
    User.newBuilder()
      .setId("4")
      .setName("Tove Yeshayahu")
      .setEmail("tove.yeshayahu@example.com")
      .setCreatedAt(convertToDateTime("2017-07-04T10:30:00+00:00"))
      .build()
  );

  public User findUser(String userId) {
    return users.stream().filter((u) -> u.getId() == userId).findFirst().orElseGet(null);
  }



}
