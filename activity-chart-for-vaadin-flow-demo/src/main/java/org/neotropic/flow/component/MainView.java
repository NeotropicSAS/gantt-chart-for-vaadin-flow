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
package org.neotropic.flow.component;

import com.neotropic.flow.component.gantt.Gantt;
import com.neotropic.flow.component.gantt.model.GanttActivity;
import com.neotropic.flow.component.gantt.model.GanttColumn;
import com.neotropic.flow.component.gantt.model.GanttConstraint;
import com.neotropic.flow.component.gantt.model.GanttConstraintType;
import com.neotropic.flow.component.gantt.model.GanttChart;
import com.neotropic.flow.component.gantt.services.ProjectsService;
import com.neotropic.flow.component.gantt.util.GanttToolbar;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Main View for GanttActivity Chart demo.
 * @author Mauricio Ruiz Beltrán {@literal <mauricio.ruiz@kuwaiba.org>}
 */
@Route
public class MainView extends Scroller {
    /**
     * The activity list.
     */
    private List<GanttActivity> activities;
    /**
     * The constraint list.
     */
    private List<GanttConstraint> constraints;
    /**
     * Use it to add additional properties to an activity.
     * If an additional key is defined, it must be added to all resources. 
     * The value can be empty. 
     */
    private LinkedHashMap<String, Object> activityProperties;
    /**
     * The activity columns list.
     */
    private List<GanttColumn> activityColumns;
    /**
     * Gantt toolbar.
     */
    private GanttToolbar toolbar;
    /*
     * https://www.unpkg.com/browse/ibm-gantt-chart@0.5.22/data/
     * https://github.com/IBM/gantt-chart/find/master
     */
    public MainView() {
        setSizeFull();        
        setContent(new Gantt(new ProjectsService() {
            @Override
            public String createProject() {
               
                buildToolbar();
                buildData();
             
                //Build an activity chart with toolbar
                GanttChart gantt = new GanttChart(toolbar, activities, activityColumns, constraints); 
                return gantt.activityChart();
            }
        }));
    }

    private void buildToolbar() {
        toolbar = new GanttToolbar("This is the toolbar title", true, true, true, true, false);
    }
    
    private void buildData() {
        // Init activities -->
        // Root
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Root");
        GanttActivity activityARoot = new GanttActivity("A-Root", "Project Summary",
                 new GregorianCalendar(2021, 11, 13, 10, 50).getTimeInMillis(),
                 new GregorianCalendar(2022, 8, 07).getTimeInMillis(),
                 "",
                 activityProperties);

        // First level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "First level");
        GanttActivity activityA1 = new GanttActivity("A-1", "Gather Requirements",
                 new GregorianCalendar(2021, 11, 14).getTimeInMillis(),
                 new GregorianCalendar(2022, 01, 10).getTimeInMillis(),
                 activityARoot.getId(),
                 activityProperties);

        // Second level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA1_1 = new GanttActivity("A-1.1", "Talk to customers",
                 new GregorianCalendar(2021, 11, 16).getTimeInMillis(),
                 new GregorianCalendar(2022, 0, 19).getTimeInMillis(),
                 activityA1.getId(),
                 activityProperties);

        // Third level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Third level");
        GanttActivity activityA1_1_1 = new GanttActivity("A-1.1.1", "Compile customer list",
                 new GregorianCalendar(2021, 11, 28, 10, 30).getTimeInMillis(),
                 new GregorianCalendar(2022, 00, 8).getTimeInMillis(),
                 activityA1_1.getId(),
                 activityProperties);

        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Third level");
        GanttActivity activityA1_1_2 = new GanttActivity("A-1.1.2", "Contact customers",
                 new GregorianCalendar(2022, 00, 9).getTimeInMillis(),
                 new GregorianCalendar(2022, 00, 19).getTimeInMillis(),
                 activityA1_1.getId(),
                 activityProperties);

        // Second level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA1_2 = new GanttActivity("A-1.2", "Write up requirements",
                 new GregorianCalendar(2022, 00, 21).getTimeInMillis(),
                 new GregorianCalendar(2022, 00, 29).getTimeInMillis(),
                 activityA1.getId(),
                 activityProperties);

        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA1_3 = new GanttActivity("A-1.3", "Review requirements",
                 new GregorianCalendar(2022, 01, 1).getTimeInMillis(),
                 new GregorianCalendar(2022, 01, 10).getTimeInMillis(),
                 activityA1.getId(),
                 activityProperties);

        // First level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "First level");
        GanttActivity activityA2 = new GanttActivity("A-2", "Marketing Specification",
                 new GregorianCalendar(2022, 01, 11).getTimeInMillis(),
                 new GregorianCalendar(2022, 02, 10).getTimeInMillis(),
                 activityARoot.getId(),
                 activityProperties);

        // Second level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA2_1 = new GanttActivity("A-2.1", "First Draft Specification",
                 new GregorianCalendar(2022, 01, 12).getTimeInMillis(),
                 new GregorianCalendar(2022, 01, 27).getTimeInMillis(),
                 activityA2.getId(),
                 activityProperties);

        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA2_2 = new GanttActivity("A-2.2", "Second Draft Specification",
                 new GregorianCalendar(2022, 02, 1).getTimeInMillis(),
                 new GregorianCalendar(2022, 02, 10).getTimeInMillis(),
                 activityA2.getId(),
                 activityProperties);

        // First level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "First level");
        GanttActivity activityA3 = new GanttActivity("A-3", "Engineering Review",
                 new GregorianCalendar(2022, 02, 11).getTimeInMillis(),
                 new GregorianCalendar(2022, 02, 21).getTimeInMillis(),
                 activityARoot.getId(),
                 activityProperties);

        // First level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "First level");
        GanttActivity activityA4 = new GanttActivity("A-4", "Proof of Concept",
                 new GregorianCalendar(2022, 02, 22).getTimeInMillis(),
                 new GregorianCalendar(2022, 05, 21).getTimeInMillis(),
                 activityARoot.getId(),
                 activityProperties);

        // Second level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA4_1 = new GanttActivity("A-4.1", "Rough Design",
                 new GregorianCalendar(2022, 03, 1).getTimeInMillis(),
                 new GregorianCalendar(2022, 03, 10).getTimeInMillis(),
                 activityA4.getId(),
                 activityProperties);

        // Third level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Third level");
        GanttActivity activityA4_1_1 = new GanttActivity("A-4.1.1", "CAD Layout",
                 new GregorianCalendar(2022, 03, 11).getTimeInMillis(),
                 new GregorianCalendar(2022, 03, 21).getTimeInMillis(),
                 activityA4_1.getId(),
                 activityProperties);

        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Third level");
        GanttActivity activityA4_1_2 = new GanttActivity("A-4.1.2", "Detailing",
                 new GregorianCalendar(2022, 03, 22).getTimeInMillis(),
                 new GregorianCalendar(2022, 03, 30).getTimeInMillis(),
                 activityA4_1.getId(),
                 activityProperties);

        // Second level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA4_2 = new GanttActivity("A-4.2", "Fabricate Prototype",
                 new GregorianCalendar(2022, 04, 01).getTimeInMillis(),
                 new GregorianCalendar(2022, 04, 10).getTimeInMillis(),
                 activityA4.getId(),
                 activityProperties);

        // Third level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Third level");
        GanttActivity activityA4_2_1 = new GanttActivity("A-4.2.1", "Order Materials",
                 new GregorianCalendar(2022, 04, 11).getTimeInMillis(),
                 new GregorianCalendar(2022, 04, 21).getTimeInMillis(),
                 activityA4_2.getId(),
                 activityProperties);

        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Third level");
        GanttActivity activityA4_2_2 = new GanttActivity("A-4.2.2", "Machining",
                 new GregorianCalendar(2022, 04, 22).getTimeInMillis(),
                 new GregorianCalendar(2022, 04, 30).getTimeInMillis(),
                 activityA4_2.getId(),
                 activityProperties);

        // Second level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA4_3 = new GanttActivity("A-4.3", "Burn-in Testing",
                 new GregorianCalendar(2022, 05, 01).getTimeInMillis(),
                 new GregorianCalendar(2022, 05, 10).getTimeInMillis(),
                 activityA4.getId(),
                 activityProperties);

        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA4_4 = new GanttActivity("A-4.4", "Prepare Demo",
                 new GregorianCalendar(2022, 05, 11).getTimeInMillis(),
                 new GregorianCalendar(2022, 05, 21).getTimeInMillis(),
                 activityA4.getId(),
                 activityProperties);

        // First level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "First level");
        GanttActivity activityA5 = new GanttActivity("A-5", "Design and Development",
                 new GregorianCalendar(2022, 05, 22).getTimeInMillis(),
                 new GregorianCalendar(2022, 06, 30).getTimeInMillis(),
                 activityARoot.getId(),
                 activityProperties);

        // Second level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA5_1 = new GanttActivity("A-5.1", "Phase I Development",
                 new GregorianCalendar(2022, 06, 01).getTimeInMillis(),
                 new GregorianCalendar(2022, 06, 10).getTimeInMillis(),
                 activityA5.getId(),
                 activityProperties);

        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA5_2 = new GanttActivity("A-5.2", "Phase II Development",
                 new GregorianCalendar(2022, 06, 11).getTimeInMillis(),
                 new GregorianCalendar(2022, 06, 21).getTimeInMillis(),
                 activityA5.getId(),
                 activityProperties);

        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA5_3 = new GanttActivity("A-5.3", "Phase III Development",
                 new GregorianCalendar(2022, 06, 22).getTimeInMillis(),
                 new GregorianCalendar(2022, 06, 30).getTimeInMillis(),
                 activityA5.getId(),
                 activityProperties);

        // First level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "First level");
        GanttActivity activityA6 = new GanttActivity("A-6", "Packaging",
                 new GregorianCalendar(2022, 07, 01).getTimeInMillis(),
                 new GregorianCalendar(2022, 8, 05).getTimeInMillis(),
                 activityARoot.getId(),
                 activityProperties);

        // Second level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA6_1 = new GanttActivity("A-6.1", "User Manual",
                 new GregorianCalendar(2022, 07, 11).getTimeInMillis(),
                 new GregorianCalendar(2022, 07, 21).getTimeInMillis(),
                 activityA6.getId(),
                 activityProperties);

        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA6_2 = new GanttActivity("A-6.2", "Installation Procedures",
                 new GregorianCalendar(2022, 07, 22).getTimeInMillis(),
                 new GregorianCalendar(2022, 07, 30).getTimeInMillis(),
                 activityA6.getId(),
                 activityProperties);

        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "Second level");
        GanttActivity activityA6_3 = new GanttActivity("A-6.3", "Update WebSite",
                 new GregorianCalendar(2022, 8, 01, 8, 30).getTimeInMillis(),
                 new GregorianCalendar(2022, 8, 05, 8, 30).getTimeInMillis(),
                 activityA6.getId(),
                 activityProperties);
        
        // First level
        activityProperties = new LinkedHashMap<>();
        activityProperties.put("propertyA", "First level");
        GanttActivity activityA7 = new GanttActivity("A-7", "End of project",
                 new GregorianCalendar(2022, 8, 06, 9, 30).getTimeInMillis(),
                 new GregorianCalendar(2022, 8, 06, 9, 30).getTimeInMillis(),
                 activityARoot.getId(),
                 activityProperties);

        activities = new ArrayList<>();
        activities.add(activityARoot);
        activities.add(activityA1);
        activities.add(activityA1_1);
        activities.add(activityA1_1_1);
        activities.add(activityA1_1_2);
        activities.add(activityA1_2);
        activities.add(activityA1_3);
        activities.add(activityA2);
        activities.add(activityA2_1);
        activities.add(activityA2_2);
        activities.add(activityA3);
        activities.add(activityA4);
        activities.add(activityA4_1);
        activities.add(activityA4_1_1);
        activities.add(activityA4_1_2);
        activities.add(activityA4_2);
        activities.add(activityA4_2_1);
        activities.add(activityA4_2_2);
        activities.add(activityA4_3);
        activities.add(activityA4_4);
        activities.add(activityA5);
        activities.add(activityA5_1);
        activities.add(activityA5_2);
        activities.add(activityA5_3);
        activities.add(activityA6);
        activities.add(activityA6_1);
        activities.add(activityA6_2);
        activities.add(activityA6_3);
        activities.add(activityA7);
        // <-- end activities
        
        // Init constraints -->
        GanttConstraint constraint1 = new GanttConstraint(activityA4_2_1.getId(), activityA4_2_2.getId(), GanttConstraintType.END_TO_START);
        GanttConstraint constraint2 = new GanttConstraint(activityA2.getId(), activityA3.getId(), GanttConstraintType.END_TO_START);
        GanttConstraint constraint3 = new GanttConstraint(activityA4_1_1.getId(), activityA4_1_2.getId(), GanttConstraintType.END_TO_START);
        GanttConstraint constraint4 = new GanttConstraint(activityA5_2.getId(), activityA6_1.getId(), GanttConstraintType.START_TO_START);
        GanttConstraint constraint5 = new GanttConstraint(activityA3.getId(), activityA4.getId(), GanttConstraintType.END_TO_START);
        GanttConstraint constraint6 = new GanttConstraint(activityA4_1_2.getId(), activityA4_2_1.getId(), GanttConstraintType.START_TO_START);
        GanttConstraint constraint7 = new GanttConstraint(activityA1_2.getId(), activityA1_3.getId(), GanttConstraintType.END_TO_START);
        GanttConstraint constraint8 = new GanttConstraint(activityA5_2.getId(), activityA5_3.getId(), GanttConstraintType.END_TO_START);
        GanttConstraint constraint9 = new GanttConstraint(activityA1_1_1.getId(), activityA1_1_2.getId(), GanttConstraintType.END_TO_START);
        GanttConstraint constraint10 = new GanttConstraint(activityA2_1.getId(), activityA2_2.getId(), GanttConstraintType.END_TO_START);
        GanttConstraint constraint11 = new GanttConstraint(activityA1_1.getId(), activityA1_2.getId(), GanttConstraintType.END_TO_START);
        GanttConstraint constraint12 = new GanttConstraint(activityA5_1.getId(), activityA5_2.getId(), GanttConstraintType.END_TO_START);
        GanttConstraint constraint13 = new GanttConstraint(activityA1.getId(), activityA2.getId(), GanttConstraintType.END_TO_START);
        GanttConstraint constraint14 = new GanttConstraint(activityA4.getId(), activityA5.getId(), GanttConstraintType.END_TO_START);
        
        constraints = new ArrayList<>();
        constraints.add(constraint1);
        constraints.add(constraint2);
        constraints.add(constraint3);
        constraints.add(constraint4);
        constraints.add(constraint5);
        constraints.add(constraint6);
        constraints.add(constraint7);
        constraints.add(constraint8);
        constraints.add(constraint9);
        constraints.add(constraint10);
        constraints.add(constraint11);
        constraints.add(constraint12);
        constraints.add(constraint13);
        constraints.add(constraint14);
        // <-- end constraints
        
        // Init activity columns -->
        GanttColumn columnPropertyA = new GanttColumn("Col2", "object.propertyA");
        activityColumns = new ArrayList<>();
        activityColumns.add(columnPropertyA);
        // <-- end activity columns
    }
}