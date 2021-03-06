/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.springboot.autoconfigure;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jbpm")
public class JBPMProperties implements InitializingBean {

    private Executor executor = new Executor();
   
    public Executor getExecutor() {
        return executor;
    }
    
    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        
    }


    public static class Executor {
        private int interval = 0;
        private int threadPoolSize = 1;
        private int retries = 3;
        private String timeUnit = TimeUnit.SECONDS.name();
        
        private boolean enabled;
        
        public int getInterval() {
            return interval;
        }
        
        public void setInterval(int interval) {
            this.interval = interval;
        }
        
        public int getThreadPoolSize() {
            return threadPoolSize;
        }
        
        public void setThreadPoolSize(int threadPoolSize) {
            this.threadPoolSize = threadPoolSize;
        }
        
        public int getRetries() {
            return retries;
        }
        
        public void setRetries(int retries) {
            this.retries = retries;
        }
        
        public String getTimeUnit() {
            return timeUnit;
        }
        
        public void setTimeUnit(String timeUnit) {
            this.timeUnit = timeUnit;
        }
        
        public boolean isEnabled() {
            return enabled;
        }
        
        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }  
    }
}
