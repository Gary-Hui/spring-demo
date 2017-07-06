#!/usr/bin/env bash


function test_project() {
    ./gradlew test
}


function build_project() {
    ./gradlew build
}


case $1 in

    build )
        build_project
        ;;

    test )
        test_project
        ;;
esac
