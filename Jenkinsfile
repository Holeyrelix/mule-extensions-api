def UPSTREAM_PROJECTS_LIST = [ "Mule-runtime/mule-api/master-JULY-DRY-RUN" ]

Map pipelineParams = [ "upstreamProjects" : UPSTREAM_PROJECTS_LIST.join(','),
                       "projectType" : "Runtime" ]

runtimeBuild(pipelineParams)
