#!/usr/bin/env groovy

def call(maven) {
  
  node {
          stage('clean') { 
                sh 'mvn clean' 
          }
          stage('validate') { 
                  sh 'mvn validate' 
          }
          stage('Deploy') { 
                  sh 'mvn package'
          }
    }
}
