package com.android.uccapp

import java.io.Serializable

//Model class for the
class Faculty : Serializable {
    var id = 0
    var profile: String? = null
    var name: String? = null
    var position: String? = null
    var email: String? = null
    var phone: String? = null

    constructor(
        profile: String?,
        name: String?,
        position: String?,
        email: String?,
        phone: String?
    ) {
        this.profile = profile
        this.name = name
        this.position = position
        this.email = email
        this.phone = phone
    }

    constructor() {}

    override fun toString(): String {
        return "Faculty{" +
                "id=" + id +
                ", profile='" + profile + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}'
    }
}