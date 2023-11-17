pipeline {
        agent any
         environment {
        IMAGE_TAG = "${env.BUILD_NUMBER}"
        }
        tools{
            maven 'M2_HOME'
        }
        stages {
            stage('Chekout GIT'){
                steps {
                    echo 'Pulling...'
                        git branch: 'master' ,
                        url : 'https://github.com/Microservice-crew/5TWIN4-G3-projet2.git',
                        credentialsId: 'gits'

                }
            }
            stage('MVN CLEAN'){
                steps{
                    sh 'mvn clean';
                }
            }
            stage('MVN COMPILE'){
                steps{
                    sh 'mvn compile';
                }
            }
            stage('MVN TEST'){
                steps{
                    sh 'mvn clean test';
                }
            }
            stage('JaCoCo Reports') {
            steps {
                sh 'mvn jacoco:report'
            }
        }
            stage("Build") {
               steps {
                sh 'mvn install -DskipTests=true'
                }
            }

              stage('MVN SONARQUBE') {
                  steps {
                      sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar -Dmaven.test.skip=true';
                 }
              }

          stage('Nexus Deploy ') {
            steps {
                nexusArtifactUploader artifacts: [
                    [
                        artifactId: 'kaddem',
                        classifier: '',
                        file: 'target/kaddem.jar',
                        type: 'jar'
                    ]
                ],
                 credentialsId: 'nexus3',
                 groupId: 'tn.esprit.spring',
                 nexusUrl: 'localhost:8081',
                 nexusVersion: 'nexus3',
                 protocol: 'http',
                 repository: 'kaddem',
                 version: '0.0.1-SNAPSHOT'
            }
        }

             stage('Build backend docker image') {
    steps {
        sh 'docker build -t $DOCKERHUB_USERNAME/arijhajji-5twin4-g3-kaddem:$IMAGE_TAG .'
    }
}

// stage('Build frontend docker image') {
//     steps {
//         dir('Kaddem_FrontEnd') {
//             sh 'docker build -t $DOCKERHUB_USERNAME/arijhajji-5twin4-g3-kaddemfront:$IMAGE_TAG .'
//         }
//     }
// }





          stage('Push images to Dockerhub') {
              steps{
                      script{
                      sh 'docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD'
                      sh 'docker push  $DOCKERHUB_USERNAME/arijhajji-5twin4-g3-kaddem:$IMAGE_TAG'
                    //   sh 'docker push  $DOCKERHUB_USERNAME/arijhajji-5twin4-g3-kaddemfront:$IMAGE_TAG'
                      }
                  }
              }
          stage("Docker Compose ") {
             steps {
              echo "Docker compose"
              sh'docker compose down'
              sh 'docker compose up -d'
             }
            }


         }

        post {
        always {
            script {
                currentBuild.result = currentBuild.currentResult
            }

            emailext subject: "Pipeline Status  ${currentBuild.result}: ${currentBuild.projectName}",
                 body: """<html>
                        <body>
                            <p>Dear Team,</p>
                            <p>The pipeline for project <strong>${currentBuild.projectName}</strong> has completed with the status: <strong>${currentBuild.result}</strong>.</p>
                            <p>Thank you,</p>
                            <p>Your Jenkins Server</p>
                        </body>
                    </html>""",
            to: 'aroujahajji3@gmail.com',
            mimeType: 'text/html'

          }
        }

    }