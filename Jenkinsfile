def UPSTREAM_PROJECTS_LIST = [ "Mule-runtime/mule-api/1.2.1-FEBRUARY-DRY-RUN" ]

Map pipelineParams = [ "upstreamProjects" : UPSTREAM_PROJECTS_LIST.join(','),
                       "projectType" : "Runtime" ]

runtimeBuild(pipelineParams)
