package com.freenow.android_demo.network

import com.freenow.android_demo.models.TestUser
import com.google.gson.JsonParser
import okhttp3.OkHttpClient
import okhttp3.Request

fun fetchUser(): TestUser {
    val url = "https://randomuser.me/api/?seed=a1f30d446f820665"
    val request = Request.Builder().url(url).build()
    val client = OkHttpClient()
    val body = client.newCall(request).execute().body()?.string()
    val jsonParser = JsonParser()
    val jsonObject = jsonParser.parse(body).getAsJsonObject()
    val results = jsonObject.getAsJsonArray("results")
    val jsonElement = results.get(0)
    val jsonUser = jsonElement.getAsJsonObject()
    val login = jsonUser.getAsJsonObject("login")
    val username = login.get("username").asString
    val password = login.get("password").asString
    val salt = login.get("salt").asString
    val sha256 = login.get("sha256").asString
    return TestUser(username, password, salt, sha256)
}
