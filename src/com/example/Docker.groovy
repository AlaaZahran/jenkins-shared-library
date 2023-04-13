#!/usr/bin/env groovy
package com.example
class Docker implements Serializable{
    def script
    Docker(script){
    this.script=script
     }
    def buildDockerImage(String imageName){
        script.echo ' building docker image .....'
        script.sh "docker build . -t $imageName "

    }
    def dockerLogin(){
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            script.sh "echo $script.PASSWORD | docker login -u $script.USERNAME --password-stdin"
            }
    }
    def pushDockerImage(String imageName){
        script.echo "push docker image to dockerhub"
        script.sh "docker push $imageName"
    }
}