#!/usr/bin/env groovy
def call(){
    echo 'building jar file ...'
    sh 'mvn clean package'
    sh 'mvn package'
}
