all: build

build:
	gradle :spotlessApply test

.PHONY: all build
