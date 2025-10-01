/*
 * Copyright 2010-2022 Neotropic SAS <contact@neotropic.co>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.neotropic.flow.component.gantt.util;

/**
 * This class provides information about the attributes that make up the toolbar associated with the chart.
 * @author Mauricio Ruiz Beltrán {@literal <mauricio.ruiz@kuwaiba.org>}
 */
public class GanttToolbar {
    /**
     * Toolbar title.
     */
    private final String title;
    /**
     * Toolbar separator.
     */
    private final boolean separator;
    /**
     * Fit to content option.
     */
    private final boolean fitToContent;
    /**
     * Zoom in option.
     */
    private final boolean zoomIn;
    /**
     * Zoom out option.
     */
    private final boolean zoomOut;
    /**
     * Option to minimize to content.
     */
    private final boolean mini;

    /**
     * Constructor of the chart toolbar. 
     * With title and possible options such as a separator, fit to content, zoom in, zoom out, minimize content
     * @param title Toolbar title.
     * @param separator Defines whether the toolbar contains a separator.
     * @param fitToContent Defines whether the toolbar contains the fit to content option.
     * @param zoomIn Defines whether the toolbar contains the zoom in option.
     * @param zoomOut Defines whether the toolbar contains the zoom out option.
     * @param mini Defines whether the toolbar contains the option to minimize content.
     */
    public GanttToolbar(String title, boolean separator, boolean fitToContent, boolean zoomIn, boolean zoomOut, boolean mini) {
        this.title = title;
        this.separator = separator;
        this.fitToContent = fitToContent;
        this.zoomIn = zoomIn;
        this.zoomOut = zoomOut;
        this.mini = mini;
    }

    public String getTitle() {
        return title;
    }

    public boolean isSeparator() {
        return separator;
    }

    public boolean isFitToContent() {
        return fitToContent;
    }

    public boolean isZoomIn() {
        return zoomIn;
    }

    public boolean isZoomOut() {
        return zoomOut;
    }

    public boolean isMini() {
        return mini;
    }
}