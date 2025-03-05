import jenkins.model.Jenkins

// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// Offending line - can't resolve import
import org.jenkinsci.plugins.workflow.job.properties.DisableResumeJobProperty
// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

def do_thing() {
    catchError {
        timestamps {
            def currentJob = Jenkins.instanceOrNull.getItemByFullName(currentBuild.fullProjectName)
            currentJob.addProperty(new DisableResumeJobProperty())
        }
    }
}