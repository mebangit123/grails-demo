package com.bridgelabz

class Semester {
    Long id
    String semesterName
    String duration
    Date academicYear
    static hasMany = [offeredCourses: Course, students: Student]
    static constraints = {
        semesterName size: 3..40, blank: false
        duration blank: false
        academicYear nullable: false
    }
    @Override
    String toString() {
        return semesterName
    }
}
