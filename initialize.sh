# Documentation: 
# * https://docs.gradle.org/current/userguide/build_init_plugin.html
gradle init \
  --type kotlin-application \
  --dsl kotlin \
  --test-framework kotlintest \
  --package com.mycompany.app \
  --project-name my-app \
  --no-split-project  \
  --no-incubating \
  --java-version 21
