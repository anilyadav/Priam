/*
 * Copyright 2019 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.netflix.priam.defaultimpl;

import com.netflix.priam.scheduler.PriamScheduler;
import com.netflix.priam.scheduler.Task;
import com.netflix.priam.scheduler.TaskTimer;
import java.text.ParseException;
import org.quartz.SchedulerException;

/** Created by aagrawal on 3/9/19. */
public interface IService {
    void scheduleService() throws Exception;

    default void scheduleTask(
            PriamScheduler priamScheduler, Class<? extends Task> task, TaskTimer taskTimer)
            throws SchedulerException, ParseException {
        if (taskTimer == null) return;

        priamScheduler.addTask(task.getName(), task, taskTimer);
    }
}
