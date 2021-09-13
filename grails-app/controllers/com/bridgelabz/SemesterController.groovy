package com.bridgelabz

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SemesterController {

    SemesterService semesterService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond semesterService.list(params), model:[semesterCount: semesterService.count()]
    }

    def show(Long id) {
        respond semesterService.get(id)
    }

    def create() {
        respond new Semester(params)
    }

    def save(Semester semester) {
        if (semester == null) {
            notFound()
            return
        }

        try {
            semesterService.save(semester)
        } catch (ValidationException e) {
            respond semester.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'semester.label', default: 'Semester'), semester.id])
                redirect semester
            }
            '*' { respond semester, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond semesterService.get(id)
    }

    def update(Semester semester) {
        if (semester == null) {
            notFound()
            return
        }

        try {
            semesterService.save(semester)
        } catch (ValidationException e) {
            respond semester.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'semester.label', default: 'Semester'), semester.id])
                redirect semester
            }
            '*'{ respond semester, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        semesterService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'semester.label', default: 'Semester'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'semester.label', default: 'Semester'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
