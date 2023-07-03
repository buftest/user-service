import logging
from concurrent import futures
from datetime import datetime

import grpc
from grpc_reflection.v1alpha import reflection
from userservice.v1 import user_pb2
from userservice.v1 import user_pb2_grpc


users = [
    {
        "id": "211f9149-a999-4690-86aa-442438cd0959",
        "name": "Thomas Laz",
        "email": "thomas.laz@example.com",
        # "created_at": datetime(2001, 1, 1, 1, 1, 1),
    },
    {
        "id": "49d5bdac-0291-49bd-b458-c8fc50baf4b4",
        "name": "Lerato Stig",
        "email": "lerato.stig@example.com",
        "created_at": datetime(2004, 1, 1, 1, 1, 1),
    },
    {
        "id": "0d4515c4-231e-4806-9329-cf2bd110850b",
        "name": "Silverius Nova",
        "email": "silverius.nova@example.com",
        "created_at": datetime(2013, 1, 1, 1, 1, 1),
    },
    {
        "id": "8de4afb0-73c3-4d1f-816b-3455e02e3191",
        "name": "Tove Yeshayahu",
        "email": "tove.yeshayahu@example.com",
        "created_at": datetime(2022, 1, 1, 1, 1, 1),
    },
]


class UserService(user_pb2_grpc.UserServiceServicer):
    def GetUser(self, request, context):
        print("new request incomming")

        user = user_pb2.User()

        user.id = "211f9149-a999-4690-86aa-442438cd0959"
        user.name = "Thomas Laz"
        user.email = "thomas.laz@example.com"

        return user


def serve():
    port = "8089"
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))

    user_pb2_grpc.add_UserServiceServicer_to_server(UserService(), server)

    SERVICE_NAMES = (
        user_pb2.DESCRIPTOR.services_by_name["UserService"].full_name,
        reflection.SERVICE_NAME,
    )

    reflection.enable_server_reflection(SERVICE_NAMES, server)
    server.add_insecure_port("[::]:" + port)
    server.start()
    print("Server started, listening on " + port)
    try:
        server.wait_for_termination()
    except KeyboardInterrupt:
        print("server closed")


if __name__ == "__main__":
    logging.basicConfig()
    serve()
