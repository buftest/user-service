from __future__ import print_function

import logging

import grpc
from userservice.v1 import user_pb2
from userservice.v1 import user_pb2_grpc


def run():
    print("Will try to greet world ...")
    with grpc.insecure_channel("localhost:8089") as channel:
        stub = user_pb2_grpc.UserServiceStub(channel)
        user_id = "RANDOM_USER_ID"
        response = stub.GetUser(user_pb2.GetUserRequest(user_id=user_id))
    print("Greeter client received: " + response.message)


if __name__ == "__main__":
    logging.basicConfig()
    run()
