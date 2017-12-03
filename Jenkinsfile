#!/usr/bin/env groovy

pipeline {
    agent {
        label 'master'
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '50'))
        timeout(time: 10, unit: 'MINUTES')
        disableConcurrentBuilds()
        timestamps()
    }
    environment {
        APP_NAME = 'USER'
        SOURCE_JOB = "${JOB_NAME}"
        BUILD_REPO_PATH = "/var/deploy"
    }
    stages {
        stage('Assembly') {
            steps {
                script {
                    sh '''mvn package'''
                }
            }
        }

        stage('Copy Assembly to build repo') {
            steps {
                script {
                    sh """cp ./target/user*.jar ${env.BUILD_REPO_PATH}/user_${
                        new Date().format('yyyyMMddhhmmssSSS')
                    }.jar"""
                }
            }
        }
        stage('Build Docker images') {
            when { branch 'master' }
            steps {
                script {
                }
            }
            post {
                failure {
                    echo "BUILDING of ${env.APP_NAME} images FAILED !"
                }
            }
        }
        stage('Deployment') {
            when { branch 'master' }
            steps {
                script {
                    echo "Deployment is skipped"
                }
            }
        }
    }
    post {
        failure {

        }
    }
}