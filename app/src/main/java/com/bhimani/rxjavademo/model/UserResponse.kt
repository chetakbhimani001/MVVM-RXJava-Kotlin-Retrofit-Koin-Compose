package com.bhimani.rxjavademo.model


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class UserResponse(
    var info: Info? = null,
    var results: List<Result?>? = null
) : Parcelable {
    @Parcelize
    data class Info(
        var page: Int? = null,
        var results: Int? = null,
        var seed: String? = null,
        var version: String? = null
    ) : Parcelable

    @Parcelize
    data class Result(
        var cell: String? = null,
        var dob: Dob? = null,
        var email: String? = null,
        var gender: String? = null,
        var id: Id? = null,
        var location: Location? = null,
        var login: Login? = null,
        var name: Name? = null,
        var nat: String? = null,
        var phone: String? = null,
        var picture: Picture? = null,
        var registered: Registered? = null
    ) : Parcelable {
        @Parcelize
        data class Dob(
            var age: Int? = null,
            var date: String? = null
        ) : Parcelable

        @Parcelize
        data class Id(
            var name: String? = null,
            var value: String? = null
        ) : Parcelable

        @Parcelize
        data class Location(
            var city: String? = null,
            var coordinates: Coordinates? = null,
            var country: String? = null,
            var postcode: Int? = null,
            var state: String? = null,
            var street: Street? = null,
            var timezone: Timezone? = null
        ) : Parcelable {
            @Parcelize
            data class Coordinates(
                var latitude: String? = null,
                var longitude: String? = null
            ) : Parcelable

            @Parcelize
            data class Street(
                var name: String? = null,
                var number: Int? = null
            ) : Parcelable

            @Parcelize
            data class Timezone(
                var description: String? = null,
                var offset: String? = null
            ) : Parcelable
        }

        @Parcelize
        data class Login(
            var md5: String? = null,
            var password: String? = null,
            var salt: String? = null,
            var sha1: String? = null,
            var sha256: String? = null,
            var username: String? = null,
            var uuid: String? = null
        ) : Parcelable

        @Parcelize
        data class Name(
            var first: String? = null,
            var last: String? = null,
            var title: String? = null
        ) : Parcelable

        @Parcelize
        data class Picture(
            var large: String? = null,
            var medium: String? = null,
            var thumbnail: String? = null
        ) : Parcelable

        @Parcelize
        data class Registered(
            var age: Int? = null,
            var date: String? = null
        ) : Parcelable
    }
}