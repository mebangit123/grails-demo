package com.bridgelabz

class Student {
    Long id
    String studentName
    String email
    String gender
    Date dateOfBirth
    static belongsTo = [Semester, Department]
    Semester semester
    Department department

    static constraints = {
        studentName size: 3..40, blank: false
        gender blank: false
        dateOfBirth nullable: false
        email blank: false
        semester nullable: false
        department nullable: false
    }
    @Override
    String toString() {
        return studentName
    }
}
