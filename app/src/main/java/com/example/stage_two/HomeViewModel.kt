package com.example.stage_two

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel: ViewModel() {
    private var _name = MutableLiveData("Robinson Chemaimak")
    val name: LiveData<String> get()=_name
    private var _bio = MutableLiveData("Hi, \nMy name is Robin, I am an Android Developer," +
            " currently enrolled to HNGx internship...")
    val bio: LiveData<String> get()= _bio
    private var _gitUserName = MutableLiveData("RobinKeya")
    val gitUserName: LiveData<String> get()=_gitUserName
    private var _slackUserName = MutableLiveData("Robinson Chemaimak")
    val slackUserName: LiveData<String> get() = _slackUserName

    fun setName(name: String){
        _name.value = name
    }
    fun setBio(bio: String){
        _bio.value = bio
    }
    fun setGitUserName(gitName: String){
        _gitUserName.value = gitName
    }
    fun setSlackName(slackName: String){
        _slackUserName.value = slackName
    }
}