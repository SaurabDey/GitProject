
   def mvnHome
   stage'Build'
   figlet 'Code Checkout'
  node {
      //git 'https://github.com/SaurabDey/GitProject.git'
    mvnHome = tool 'M3'
    checkout([$class: 'GitSCM', 
    branches: [[name: '*/somebranch']], 
    doGenerateSubmoduleConfigurations: false, 
    extensions: [], submoduleCfg: [], 
    userRemoteConfigs: [[url: 'https://github.com/SaurabDey/GitProject.git']]])

   }
   stage 'Execute'
   figlet 'Execute Test'
   node {
      
    if (isUnix()) {
        sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
        bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
  stage "Reports"
  figlet 'Publish Reports' 
   node {
     
      publishHTML(target: [allowMissing: true, 
        alwaysLinkToLastBuild: false, 
        keepAll: true, 
        reportDir: 'target/surefire-reports/', 
        reportFiles: 'index.html', 
        reportName: 'TestNg Report'])
       
    publishHTML(target: [allowMissing: true, 
    alwaysLinkToLastBuild: false, 
    keepAll: true, 
    reportDir: 'Resource/', 
    reportFiles: 'SaurabGitJenkins.html', 
    reportName: 'Extent Report']) 
   }
   
stage 'Notification Message'
figlet 'Sending Notification Mail'
mail (to:'saurab.jeet@gmail.com',
cc: '', 
from: 'saurab.jeet@gmail.com', mimeType: 'text/html', 
subject: "Test Automation Results", 
body: """<p>Greetings</p>

<div>Test Automation execution has been completed on somebranch environment</div>
<div>Execution reports: </div>


Reports:
<div><a href="JBehave_Report">Jbehave Report</a></div><br/>
<div><a href="Serenity_Report">Serenity Report</a></div>

<br/>
<p>Thank you.
<br/>
<br/>
Regards,<br/>
<i>Automation Team.</i></p>

""")