package com.riztech.bus.data.model

import com.google.gson.annotations.SerializedName

sealed class BusApiResponse {

    data class UserToken(
        val access_token: String,
        val expires_in: Int,
        @SerializedName("not-before-policy")
        val not_before_policy: Int,
        val refresh_expires_in: Int,
        val refresh_token: String,
        val scope: String,
        val session_state: String,
        val token_type: String
    ): BusApiResponse()

    data class Lines(
        val content: List<Content>,
        val empty: Boolean,
        val first: Boolean,
        val last: Boolean,
        val number: Int,
        val numberOfElements: Int,
        val pageable: Pageable,
        val size: Int,
        val sort: SortX,
        val totalElements: Int,
        val totalPages: Int
    ): BusApiResponse()

    data class Content(
        val description: String,
        val id: String,
        val name: String,
        val plc_ip_address: String
    ): BusApiResponse()


    //default
    data class Pageable(
        val offset: Int,
        val pageNumber: Int,
        val pageSize: Int,
        val paged: Boolean,
        val sort: Sort,
        val unpaged: Boolean
    ): BusApiResponse()

    data class Sort(
        val empty: Boolean,
        val sorted: Boolean,
        val unsorted: Boolean
    ): BusApiResponse()

    data class SortX(
        val empty: Boolean,
        val sorted: Boolean,
        val unsorted: Boolean
    ): BusApiResponse()
}