.PHONY: proto

start:
	PYTHONPATH="./gen" watchmedo auto-restart -d ./ -p "*.py" --recursive  -- python main.py

test:
	pytest .

proto:
	cd proto \
	&& buf mod update \
	&& buf lint \
	&& buf build \
	&& cd .. \
	&& buf generate proto


proto-update: proto buf-update
