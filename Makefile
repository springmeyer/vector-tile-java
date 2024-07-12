all: build

build:
	gradle :spotlessApply build

test:
	gradle test

clean:
	rm -rf build

.PHONY: all build
