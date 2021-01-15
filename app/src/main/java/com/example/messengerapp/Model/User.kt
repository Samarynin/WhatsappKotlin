package com.example.messengerapp.Model

class User {
    private var uid:String = ""
    private var email:String = ""
    private var cover:String = ""
    private var facebook:String = ""
    private var instagram:String = ""
    private var profile:String = ""
    private var search:String = ""
    private var username:String = ""
    private var vk:String = ""
    private var website:String = ""

    constructor()

    constructor(
        uid: String,
        email: String,
        cover: String,
        facebook: String,
        instagram: String,
        profile: String,
        search: String,
        username: String,
        vk: String,
        website: String
    ) {
        this.uid = uid
        this.email = email
        this.cover = cover
        this.facebook = facebook
        this.instagram = instagram
        this.profile = profile
        this.search = search
        this.username = username
        this.vk = vk
        this.website = website
    }

    fun getUID() : String?{
        return uid
    }

    fun setUID(uid: String){
        this.uid = uid
    }

    fun getEmail() : String?{
        return email
    }

    fun setEmail(email: String){
        this.email = email
    }

    fun getCover() : String?{
        return cover
    }

    fun setCover(cover: String){
        this.cover = cover
    }

    fun getFacebook() : String?{
        return facebook
    }

    fun setFacebook(facebook: String){
        this.facebook = facebook
    }

    fun getInstagram() : String?{
        return instagram
    }

    fun setInstagram(instagram: String){
        this.instagram = instagram
    }

    fun getProfile() : String?{
        return profile
    }

    fun setProfile(profile: String){
        this.profile = profile
    }

    fun getSearch() : String?{
        return search
    }

    fun setSearch(search: String){
        this.search = search
    }

    fun getUsername() : String?{
        return username
    }

    fun setUsername(username: String){
        this.username = username
    }

    fun getVk() : String?{
        return vk
    }

    fun setVk(vk: String){
        this.vk = vk
    }

    fun getWebsite() : String?{
        return website
    }

    fun setWebsite(website: String){
        this.website = website
    }

}