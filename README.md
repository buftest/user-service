# user-service

## requirements

- python 3.11
- poetry
- precommit
- pyenv (recommended)

## getting started

```sh
$ git clone git@github.com:buftest/user-service.git && cd user-service
$ pyenv virtualenv 3.11.3 $(basename `pwd`)
$ pyenv local $(basename `pwd`)
$ poetry install
$ pre-commit install
$ make proto
$ make start
```
```sh
$ grpcurl -vv -plaintext -d '{"user_id": "example"}' localhost:8089 userservice.v1.UserService/GetUser
```

```sh
buf curl \
  --schema proto \
  --data '{"user_id": "PET_TYPE_SNAKE"}' \
  --http2-prior-knowledge \
  -v \
  http://localhost:8089/userservice.v1.UserService/GetUser
```

```sh
PYTHONPATH="./gen" python client.py
```
