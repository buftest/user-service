package com.buftest.userservice;

import com.google.type.DateTime;
import com.userservice.v1.GetUserRequest;
import com.userservice.v1.GetUserResponse;
import com.userservice.v1.User;
import com.userservice.v1.UserServiceGrpc.UserServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class UserServiceImpl extends UserServiceImplBase {

  @Override
  public void getUser(GetUserRequest request, StreamObserver<GetUserResponse> responseObserver) {
    var user = User.newBuilder()
      .setName("Thomas Laz")
      .setEmail("thomas.laz@example.com")
      .setId("211f9149-a999-4690-86aa-442438cd0959")
      .setCreatedAt(convertToDateTime("2023-07-04T10:30:00+00:00"))
      .build();

    GetUserResponse response = GetUserResponse.newBuilder().setUser(user).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  public static DateTime convertToDateTime(String iso8601String) {
    LocalDateTime localDateTime = LocalDateTime.parse(iso8601String,
      DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneOffset.UTC);

    long seconds = zonedDateTime.toEpochSecond();
    int nanos = zonedDateTime.getNano();

    DateTime dateTime = DateTime.newBuilder()
      .setSeconds((int) seconds)
      .setNanos(nanos)
      .build();

    return dateTime;
  }
}
