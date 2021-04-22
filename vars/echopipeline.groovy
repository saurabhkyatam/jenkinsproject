def call(body)
{
    
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline{
        agent any
        stages
        {

            stage("checkout")
            {
                steps{
                    echo "checkout"
                    //git credentialsId: "${config.gitcredentials}", url: "${config.gitrepo}"
                }
            }

            stage('Build Package ')
            {
                steps {
                    echo "build ready"
                    //bat 'mvn clean'
                    //bat 'mvn package -DdefaultValueOfSkip=true'
                }
           
            }
            stage("sonarqube report")
            {
                steps{
                    echo "report ready"
                    //withSonarQubeEnv('SonarQube') {
                    //bat "mvn clean install sonar:sonar -Dsonar.java.binaries=target/classes"
                    // }
                }
            }
            stage("qualitygate condition")
            {
                steps{
                    script 
                    {

                       
                            println "${config.condition.size()}"
                            int size=(int)"${config.condition.size()}"
                            println size.getClass()
                            sonarqubeQualityGate.createCondition("${config.sonarqubehost}","${config.condition.get(0).get(0)}","${config.gateName}","${config.condition.get(0).get(1)}","${config.condition.get(0).get(3)}")
                        
                    
                    
                    }                
                }
            }
        }   
    }    
}