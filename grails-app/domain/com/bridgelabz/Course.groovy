package com.bridgelabz

class Course {
    Long id
    String courseName
    String code
    static belongsTo = [semester:Semester]
    static constraints = {
        courseName size: 3..40, blank: false
        code blank: false
    }
    @Override
    String toString() {
        return courseName
    }
}
