#!/usr/bin/env groovy

def call(maven) {
  
  pipeline {
    
      stages {
          stage('clean') { 
               steps {
                sh 'mvn clean' 
              }
          }
          stage('validate') { 
              steps {
                  sh 'mvn validate' 
              }
          }
          stage('Deploy') { 
              steps {
                  sh 'mvn package'
              }
          }
      }
    }
}
