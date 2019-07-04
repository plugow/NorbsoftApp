package com.plugow.norbsoftapp.util

import androidx.lifecycle.MutableLiveData

interface RefreshableList<T> {
    val items:MutableLiveData<List<T>>
    val isLoadingRefresh:MutableLiveData<Boolean>

    fun loadItems()

    fun onRefreshItems(){
        loadItems()
    }

    fun initValues(){
        if(items.value==null) {
            isLoadingRefresh.value=true
            loadItems()
        }
    }
}