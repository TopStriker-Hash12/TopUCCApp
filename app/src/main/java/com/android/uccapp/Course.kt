package com.android.uccapp

import java.io.Serializable

class Course : Serializable {
    //Courses Attribute
    var id = 0
    var name: String? = null
    var code: String? = null

    //Getter //Setter function
    var yearSemester: String? = null
    var creditHrs: String? = null
    var totalCreditHr: String? = null
    var preRec: String? = null
    var description: String? = null

    constructor(
        name: String?,
        code: String?,
        yearSemester: String?,
        creditHrs: String?,
        totalCreditHr: String?,
        preRec: String?,
        description: String?
    ) {
        this.name = name
        this.code = code
        this.yearSemester = yearSemester
        this.creditHrs = creditHrs
        this.totalCreditHr = totalCreditHr
        this.preRec = preRec
        this.description = description
    }

    constructor() {}
}