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
import com.neotropic.flow.component.gantt.model.GanttChart;
import com.neotropic.flow.component.gantt.model.GanttReservation;
import com.neotropic.flow.component.gantt.model.GanttResource;
import com.neotropic.flow.component.gantt.services.ProjectsService;
import com.neotropic.flow.component.gantt.util.GanttToolbar;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Main View for Scheduling Chart demo.
 * @author Mauricio Ruiz Beltrán {@literal <mauricio.ruiz@kuwaiba.org>}
 */
@Route
public class MainView extends Scroller {
    /**
     * The resource list.
     */
    private List<GanttResource> resources;
    /**
     * The activity list.
     */
    private List<GanttActivity> activities;
    /**
     * The reservation list.
     */
    private List<GanttReservation> reservations;
    /**
     * Use it to add additional properties to a resource.
     * If an additional key is defined, it must be added to all resources. 
     * The value can be empty. 
     */
    private LinkedHashMap<String, Object> resourceProperties;
    /**
     * Use it to add additional properties to an activity.
     * If an additional key is defined, it must be added to all resources. 
     * The value can be empty. 
     */
    private LinkedHashMap<String, Object> activityProperties;
    /**
     * The resource columns list.
     */
    private List<GanttColumn> resourceColumns;
    /**
     * Gantt toolbar.
     */
    private GanttToolbar toolbar;
    
    /*
     * https://github.com/IBM/gantt-chart/find/master
     */
    public MainView() {
        setSizeFull();        
        setContent(new Gantt(new ProjectsService() {
            @Override
            public String createProject() {
                
                buildToolbar();
                buildData();
                
                // Build a scheduling chart with toolbar
                GanttChart gantt = new GanttChart(toolbar, resources, resourceColumns, activities, reservations);
                return gantt.schedulingChart();
            }
        }));
    }

    private void buildToolbar() {
        toolbar = new GanttToolbar("This is the toolbar title", true, true, true, true, true);
    }
    
    private void buildData() {
        // Init resources -->
        // Root
        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "JCOM-COL2");
        GanttResource resourceJCOM = new GanttResource("JCOM", "JCompany Employees", "", resourceProperties);

        // First level
        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "MKT-COL2");
        GanttResource resourceMKT = new GanttResource("MKT", "Marketing", resourceJCOM.getId(), resourceProperties);

        //Second level
        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "");
        GanttResource resourceBM = new GanttResource("BM", "Bill McDonald", resourceMKT.getId(), resourceProperties);

        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "SK-COL2");
        GanttResource resourceSK = new GanttResource("SK", "Steve Knoll", resourceMKT.getId(), resourceProperties);

        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "");
        GanttResource resourceMS = new GanttResource("MS", "Michael Smith", resourceMKT.getId(), resourceProperties);

        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "LP-COL2");
        GanttResource resourceLP = new GanttResource("LP", "Luc Dupont", resourceMKT.getId(), resourceProperties);

        // First level
        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "RND-COL2");
        GanttResource resourceRND = new GanttResource("RND", "Research and Development", resourceJCOM.getId(), resourceProperties);

        /*Second level*/
        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "");
        GanttResource resourceLD = new GanttResource("LD", "Linus Dane", resourceRND.getId(), resourceProperties);

        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "JH-COL2");
        GanttResource resourceJH = new GanttResource("JH", "James Hook", resourceRND.getId(), resourceProperties);

        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "SW-COL2");
        GanttResource resourceSW = new GanttResource("SW", "Scott Washington", resourceRND.getId(), resourceProperties);

        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "");
        GanttResource resourceGH = new GanttResource("GH", "Gill Hopper", resourceRND.getId(), resourceProperties);

        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "TM-COL2");
        GanttResource resourceTM = new GanttResource("TM", "Thomas Monahan", resourceRND.getId(), resourceProperties);

        // First Level
        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "DOC-COL2");
        GanttResource resourceDOC = new GanttResource("DOC", "Documentation", resourceJCOM.getId(), resourceProperties);

        //Second level
        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "SL-COL2");
        GanttResource resourceSL = new GanttResource("SL", "Sandy Ladd", resourceDOC.getId(), resourceProperties);

        resourceProperties = new LinkedHashMap<>();
        resourceProperties.put("propertyZ", "");
        GanttResource resourceBR = new GanttResource("BR", "Bob Robertson", resourceDOC.getId(), resourceProperties);

        resources = new ArrayList<>();
        resources.add(resourceJCOM);
        resources.add(resourceMKT);
        resources.add(resourceBM);
        resources.add(resourceSK);
        resources.add(resourceMS);
        resources.add(resourceLP);
        resources.add(resourceRND);
        resources.add(resourceLD);
        resources.add(resourceJH);
        resources.add(resourceSW);
        resources.add(resourceGH);
        resources.add(resourceTM);
        resources.add(resourceDOC);
        resources.add(resourceSL);
        resources.add(resourceBR);
        // <-- end resources

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
        
        // Init reservations -->
        GanttReservation reservation1 = new GanttReservation(resourceMS.getId(), activityA1_3.getId());
        GanttReservation reservation2 = new GanttReservation(resourceSK.getId(), activityA1_1_2.getId());
        GanttReservation reservation3 = new GanttReservation(resourceSL.getId(), activityA6_1.getId());
        GanttReservation reservation4 = new GanttReservation(resourceLD.getId(), activityA5_2.getId());
        GanttReservation reservation5 = new GanttReservation(resourceGH.getId(), activityA4_1_2.getId());
        GanttReservation reservation6 = new GanttReservation(resourceMS.getId(), activityA1_1_1.getId());
        GanttReservation reservation7 = new GanttReservation(resourceGH.getId(), activityA4_4.getId());
        GanttReservation reservation8 = new GanttReservation(resourceGH.getId(), activityA4_2_2.getId());
        GanttReservation reservation9 = new GanttReservation(resourceBR.getId(), activityA6_1.getId());
        GanttReservation reservation10 = new GanttReservation(resourceLP.getId(), activityA4_4.getId());
        GanttReservation reservation11 = new GanttReservation(resourceLP.getId(), activityA2_2.getId());
        GanttReservation reservation12 = new GanttReservation(resourceLD.getId(), activityA4.getId());
        GanttReservation reservation13 = new GanttReservation(resourceJH.getId(), activityA4_2.getId());
        GanttReservation reservation14 = new GanttReservation(resourceLP.getId(), activityA1_1_1.getId());
        GanttReservation reservation15 = new GanttReservation(resourceGH.getId(), activityA6_3.getId());
        GanttReservation reservation16 = new GanttReservation(resourceTM.getId(), activityA4_1_2.getId());
        GanttReservation reservation17 = new GanttReservation(resourceJH.getId(), activityA5.getId());
        GanttReservation reservation18 = new GanttReservation(resourceBM.getId(), activityA1_3.getId());
        GanttReservation reservation19 = new GanttReservation(resourceBM.getId(), activityA3.getId());
        GanttReservation reservation20 = new GanttReservation(resourceJH.getId(), activityA3.getId());
        GanttReservation reservation21 = new GanttReservation(resourceLP.getId(), activityA2_1.getId());
        GanttReservation reservation22 = new GanttReservation(resourceLD.getId(), activityA6_2.getId());
        GanttReservation reservation23 = new GanttReservation(resourceSL.getId(), activityA6_3.getId());
        GanttReservation reservation24 = new GanttReservation(resourceSW.getId(), activityA5_2.getId());
        GanttReservation reservation25 = new GanttReservation(resourceTM.getId(), activityA5_3.getId());
        GanttReservation reservation26 = new GanttReservation(resourceSW.getId(), activityA4_1.getId());
        GanttReservation reservation27 = new GanttReservation(resourceBM.getId(), activityA1_1.getId());
        GanttReservation reservation28 = new GanttReservation(resourceMS.getId(), activityA2_1.getId());
        GanttReservation reservation29 = new GanttReservation(resourceTM.getId(), activityA4_4.getId());
        GanttReservation reservation30 = new GanttReservation(resourceSK.getId(), activityA1_1_1.getId());
        GanttReservation reservation31 = new GanttReservation(resourceGH.getId(), activityA3.getId());
        GanttReservation reservation32 = new GanttReservation(resourceLP.getId(), activityA1_1_2.getId());
        GanttReservation reservation33 = new GanttReservation(resourceTM.getId(), activityA4_3.getId());
        GanttReservation reservation34 = new GanttReservation(resourceSW.getId(), activityA5_3.getId());
        GanttReservation reservation35 = new GanttReservation(resourceBR.getId(), activityA6_2.getId());
        GanttReservation reservation36 = new GanttReservation(resourceTM.getId(), activityA4_1_1.getId());
        GanttReservation reservation37 = new GanttReservation(resourceMS.getId(), activityA1_2.getId());
        GanttReservation reservation38 = new GanttReservation(resourceMS.getId(), activityA6_3.getId());
        GanttReservation reservation39 = new GanttReservation(resourceLD.getId(), activityA1_3.getId());
        GanttReservation reservation40 = new GanttReservation(resourceTM.getId(), activityA4_2_1.getId());
        GanttReservation reservation41 = new GanttReservation(resourceSW.getId(), activityA4_3.getId());
        GanttReservation reservation42 = new GanttReservation(resourceLD.getId(), activityA5_1.getId());

        reservations = new ArrayList<>();
        reservations.add(reservation1);
        reservations.add(reservation2);
        reservations.add(reservation3);
        reservations.add(reservation4);
        reservations.add(reservation5);
        reservations.add(reservation6);
        reservations.add(reservation7);
        reservations.add(reservation8);
        reservations.add(reservation9);
        reservations.add(reservation10);
        reservations.add(reservation11);
        reservations.add(reservation12);
        reservations.add(reservation13);
        reservations.add(reservation14);
        reservations.add(reservation15);
        reservations.add(reservation16);
        reservations.add(reservation17);
        reservations.add(reservation18);
        reservations.add(reservation19);
        reservations.add(reservation20);
        reservations.add(reservation21);
        reservations.add(reservation22);
        reservations.add(reservation23);
        reservations.add(reservation24);
        reservations.add(reservation25);
        reservations.add(reservation26);
        reservations.add(reservation27);
        reservations.add(reservation28);
        reservations.add(reservation29);
        reservations.add(reservation30);
        reservations.add(reservation31);
        reservations.add(reservation32);
        reservations.add(reservation33);
        reservations.add(reservation34);
        reservations.add(reservation35);
        reservations.add(reservation36);
        reservations.add(reservation37);
        reservations.add(reservation38);
        reservations.add(reservation39);
        reservations.add(reservation40);
        reservations.add(reservation41);
        reservations.add(reservation42);
        // <-- end reservations

        // Init resource columns -->
        GanttColumn columnPropertyZ = new GanttColumn("Col2", "object.propertyZ");
        resourceColumns = new ArrayList<>();
        resourceColumns.add(columnPropertyZ);
        // <-- end resource columns
    }
}