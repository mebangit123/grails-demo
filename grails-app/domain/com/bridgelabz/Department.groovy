package com.bridgelabz

class Department {
    Long id
    String deptName
    static hasMany = [students: Student]
    static constraints = {
        deptName size: 3..40, blank: false
    }
    @Override
    String toString() {
        return deptName
    }
}
