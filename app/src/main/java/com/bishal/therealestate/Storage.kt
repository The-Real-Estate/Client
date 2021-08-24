  package com.bishal.therealestate

import com.bishal.therealestate.Entity.ArtistDetail


var listUsers = arrayListOf<ArtistDetail>()
var users = mutableMapOf<Int, ArtistDetail>( 0 to ArtistDetail( ))
var loggedIn: ArtistDetail? = null
class Storage (){
    fun appendUsers(student: ArtistDetail){
        listUsers.add(student)
        println(listUsers.size)
    }
    fun returnStudent():ArrayList<ArtistDetail>{
        return listUsers
    }
    fun deleteStudent(student: ArtistDetail){
        listUsers.remove(student)
    }
    public fun setLoggedIn(id: ArtistDetail?){
        println(id)
        loggedIn = id
    }
    public fun getLoggedIn(): ArtistDetail? {
        return loggedIn
    }

    public fun hasUsername(u: String?): ArtistDetail? {
        var found: ArtistDetail? = null
        for(i in users){
            if(u == i.value.name) {
                found = i.value
                break
            }
        }
        return found
    }

}