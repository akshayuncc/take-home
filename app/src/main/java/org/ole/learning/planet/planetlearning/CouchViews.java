package org.ole.learning.planet.planetlearning;

import com.couchbase.lite.Database;
import com.couchbase.lite.Emitter;
import com.couchbase.lite.Mapper;
import com.couchbase.lite.View;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by leonardmensah on 23/05/16.
 */
@SuppressWarnings("ALL")
public class CouchViews {
    public View CreateLoginByIdView(Database db) {
        View LoginByIdView = db.getView("MembersByLoginID");
            LoginByIdView.setMap(
                    new Mapper(){
                        @Override
                        public void map(Map<String, Object> document,Emitter emitter) {
                            if ("Member".equals(document.get("kind"))) {
                                emitter.emit((String) document.get("login"), (String) document.get("_id"));
                            }
                        }
                    }, "9"
            );
        return LoginByIdView;
    }
    public View CreateListByNameView(Database db) {
        View ListByNameView = db.getView("MembersByNameView");
        ListByNameView.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                    if ("Member".equals(document.get("kind"))) {
                            emitter.emit((String) document.get("firstName"), (String) document.get("_id"));
                    }
                    }
                }, "4"
        );
        return ListByNameView;
    }
    public View ReadShelfByIdView(Database db) {
        View shelfListByIdView = db.getView("ShelfByID");
        shelfListByIdView.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                    emitter.emit((String) document.get("memberId"), (String) document.get("_id"));
                    }
                }, "4"
        );
        return shelfListByIdView;
    }
    public View ReadAdmissionCourseList(Database db) {
        View AdmissionCourseByIdView = db.getView("AdmissionCourseById");
        AdmissionCourseByIdView.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                        emitter.emit((ArrayList) document.get("members"), (String) document.get("_id"));
                    }
                }, "3"
        );
        return AdmissionCourseByIdView;
    }
    public View ReadCourseList(Database db) {
        View CourseListByMemberIdView = db.getView("CourseByMemberID");
        CourseListByMemberIdView.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                        emitter.emit((ArrayList) document.get("members"), (String) document.get("_id"));
                    }
                }, "2"
        );
        return CourseListByMemberIdView;
    }
    public View ReadCourses(Database db) {
        View Courses = db.getView("Courses");
        Courses.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                        emitter.emit((String) document.get("CourseTitle"), (String) document.get("_id"));
                    }
                }, "2"
        );
        return Courses;
    }
    public View ReadCourseSteps(Database db) {
        View CourseSteps = db.getView("Coursestep");
        CourseSteps.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                        emitter.emit((String) document.get("_id"), (String) document.get("_id"));
                    }
                }, "5"
        );
        return CourseSteps;
    }
    public View ReadCourseStepsByCourseID(Database db,final String courseId) {
        View CourseSteps = db.getView("CourseStepsByCourseID");
        CourseSteps.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                        if (courseId.equals(document.get("courseId"))) {
                            emitter.emit((String) document.get("courseId"), (String) document.get("_id"));
                        }
                    }
                }, "2"
        );
        return CourseSteps;
    }
    public View ReadMemberCourseProgByMemberIdCourceId(Database db,final String courseId,final String memberId) {
        View CourseProgMemCourseID = db.getView("CourseMemberCourseId");
        CourseProgMemCourseID.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                        if (courseId.equals(document.get("courseId")) && memberId.equals(document.get("memberId"))) {
                            emitter.emit((String) document.get("courseId"), (String) document.get("_id"));
                        }
                    }
                }, "4"
        );
        return CourseProgMemCourseID;
    }
    public View ReadCourseMemberAnswers(Database db) {
        View CourseMemberAnswers = db.getView("CourseMemAnswers");
        CourseMemberAnswers.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                        emitter.emit((String) document.get("courseId"), (String) document.get("_id"));
                    }
                }, "3"
        );
        return CourseMemberAnswers;
    }
    public View ReadMemberCourseProg(Database db) {
        View CourseProg = db.getView("CourseProg");
        CourseProg.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                        emitter.emit((String) document.get("courseId"), (String) document.get("_id"));
                    }
                }, "3"
        );
        return CourseProg;
    }
    public View ReadMemberVisits(Database db) {
        View VisitsByMemberIdView = db.getView("visits");
        VisitsByMemberIdView.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                        emitter.emit((String) document.get("memberId"), (String) document.get("_id"));
                    }
                }, "1"
        );
        return VisitsByMemberIdView;
    }
    public View ReadMemberVisitsId(Database db) {
        View VisitsMemberVisitsIdView = db.getView("visits");
        VisitsMemberVisitsIdView.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                        emitter.emit((String) document.get("_id"), (String) document.get("_id"));
                    }
                }, "4"
        );
        return VisitsMemberVisitsIdView;
    }
    public View LocalServerInfo(Database db) {
        View ServerInfoView = db.getView("name");
        ServerInfoView.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                        emitter.emit((String) document.get("name"), (String) document.get("_id"));
                    }
                }, "2"
        );
        return ServerInfoView;
    }
    public View ReadResourceRatingByIdView(Database db) {
        View ResourceRatingByIdView = db.getView("ResourceRatingById");
        ResourceRatingByIdView.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                        emitter.emit((String) document.get("_id"), (String) document.get("_id"));
                    }
                }, "11"
        );
        return ResourceRatingByIdView;
    }
    public View ReadActivityLogById(Database db) {
        View ReadActivityLogByIdView = db.getView("ActivityLogById");
        ReadActivityLogByIdView.setMap(
                new Mapper(){
                    @Override
                    public void map(Map<String, Object> document,Emitter emitter) {
                        emitter.emit((String) document.get("_id"), (String) document.get("_id"));
                    }
                }, "3"
        );
        return ReadActivityLogByIdView;
    }
}
