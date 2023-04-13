#!/usr/bin/env groovy
package com.example
class Docker implements serializable{
    def script
    Docker(script){
    this.script=script
     }
    def buildDockerImage(string imageName){
        script.echo ' building docker image .....'
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            script.sh "docker build . -t $imageName "
            script.sh "echo $script.PASSWORD | docker login -u $script.USERNAME --password-stdin"
            script.echo "push docker image to dockerhub"
            script.sh "docker push $imageName"}
    }
}