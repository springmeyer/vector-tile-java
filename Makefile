all: build

build:
	gradle :spotlessApply build

test:
	gradle test

.PHONY: all build
