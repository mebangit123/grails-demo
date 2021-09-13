package com.bridgelabz

import grails.gorm.services.Service

@Service(Semester)
interface SemesterService {

    Semester get(Serializable id)

    List<Semester> list(Map args)

    Long count()

    void delete(Serializable id)

    Semester save(Semester semester)

}