#!/usr/bin/env groovy

def call(maven) {
  
  node {
          stage('clean previous repo') { 
                sh 'rm -rf pipeline-library-demo' 
          }
          stage('git clone') { 
                sh 'git clone https://github.com/vMahidhar/pipeline-library-demo.git' 
          }
          stage('echo') { 
                echo 'cloned project' 
          }   
          stage('clean') { 
                sh 'mvn clean -f pipeline-library-demo' 
          }
          stage('validate') { 
                  sh 'mvn validate -f pipeline-library-demo' 
          }
          stage('Deploy') { 
                  sh 'mvn package -f pipeline-library-demo'
          }
    }
}
