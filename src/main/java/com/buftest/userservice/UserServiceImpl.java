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
import java.util.Arrays;
import java.util.List;

public class UserServiceImpl extends UserServiceImplBase {


  UserRepository repository = new UserRepository();


  @Override
  public void getUser(GetUserRequest request, StreamObserver<GetUserResponse> responseObserver) {
    var user = repository.findUser(request.getUserId());

    if (user == null) {
      throw new RuntimeException("User not found");
    }

    GetUserResponse response = GetUserResponse.newBuilder().setUser(user).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }


}
